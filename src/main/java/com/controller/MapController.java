package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.MapEntity;
import com.entity.view.MapView;
import com.service.MapService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * 地图公告
 * 后端接口
 *
 *
 */
@RestController
@RequestMapping("/Map")
public class MapController {

    @Autowired
    private MapService mapService;

    /**
     * 后端列表
     *
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, MapEntity map,
                  HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("announcement")) {
            map.setAnnouncement_id((long)request.getSession().getAttribute("announcement_description"));
        }
        EntityWrapper<MapEntity> ew = new EntityWrapper<MapEntity>();

        PageUtils page = mapService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, map), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     *
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MapEntity map,
                  HttpServletRequest request){
        EntityWrapper<MapEntity> ew = new EntityWrapper<MapEntity>();

        PageUtils page = mapService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, map), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     *
     */
    @RequestMapping("/lists")
    public R list( MapEntity map){
        EntityWrapper<MapEntity> ew = new EntityWrapper<MapEntity>();
        ew.allEq(MPUtil.allEQMapPre( map, "map"));
        return R.ok().put("data", mapService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MapEntity map){
        EntityWrapper< MapEntity> ew = new EntityWrapper< MapEntity>();
        ew.allEq(MPUtil.allEQMapPre( map, "map"));
        MapView mapView =  mapService.selectView(ew);
        return R.ok("查询上传报名成功").put("data", mapView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MapEntity map = mapService.selectById(id);
        return R.ok().put("data", map);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MapEntity map = mapService.selectById(id);
        return R.ok().put("data", map);
    }

    /**
     * 后端保存
     *///这里这里这里
    @RequestMapping("/save")
    public R save(@RequestBody MapEntity map, HttpServletRequest request){
        map.setAnnouncement_id(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(map);
        mapService.insert(map);
        return R.ok();
    }

    /**
     * 前端保存
     *///这里这里这里
    @RequestMapping("/add")
    public R add(@RequestBody MapEntity map, HttpServletRequest request){
        map.setAnnouncement_id(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(map);
        mapService.insert(map);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MapEntity map, HttpServletRequest request){
        //ValidatorUtils.validateEntity(map);
        mapService.updateById(map);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mapService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
    @RequestMapping("/remind/{columnName}/{type}")
    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
                         @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
        map.put("column", columnName);
        map.put("type", type);

        if(type.equals("2")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date remindStartDate = null;
            Date remindEndDate = null;
            if(map.get("remindstart")!=null) {
                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH,remindStart);
                remindStartDate = c.getTime();
                map.put("remindstart", sdf.format(remindStartDate));
            }
            if(map.get("remindend")!=null) {
                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH,remindEnd);
                remindEndDate = c.getTime();
                map.put("remindend", sdf.format(remindEndDate));
            }
        }

        Wrapper<MapEntity> wrapper = new EntityWrapper<MapEntity>();
        if(map.get("remindstart")!=null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend")!=null) {
            wrapper.le(columnName, map.get("remindend"));
        }

        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("announcement")) {
            wrapper.eq("announcement_id", (String)request.getSession().getAttribute("announcement_description"));
        }

        int count = mapService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}
