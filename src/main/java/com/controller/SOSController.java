package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.SOSEntity;
import com.entity.view.SOSView;
import com.service.SOSService;
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
 * 求救板
 * 后端接口
 *
 *
 */
@RestController
@RequestMapping("/sos")
public class SOSController {
    @Autowired
    private SOSService sosService;

    /**
     * 后端列表
     *
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, SOSEntity sos,
                  HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("userdetails")) {
            sos.setUserID((long)request.getSession().getAttribute("Name"));
        }
        EntityWrapper<SOSEntity> ew = new EntityWrapper<SOSEntity>();

        PageUtils page = sosService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sos), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     *
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SOSEntity sos,
                  HttpServletRequest request){
        EntityWrapper<SOSEntity> ew = new EntityWrapper<SOSEntity>();

        PageUtils page = sosService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sos), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     *
     */
    @RequestMapping("/lists")
    public R list( SOSEntity sos){
        EntityWrapper<SOSEntity> ew = new EntityWrapper<SOSEntity>();
        ew.allEq(MPUtil.allEQMapPre( sos, "sos"));
        return R.ok().put("data", sosService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SOSEntity sos){
        EntityWrapper< SOSEntity> ew = new EntityWrapper< SOSEntity>();
        ew.allEq(MPUtil.allEQMapPre( sos, "sos"));
        SOSView sosView =  sosService.selectView(ew);
        return R.ok("查询信息成功").put("data", sosView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SOSEntity sos = sosService.selectById(id);
        return R.ok().put("data", sos);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SOSEntity sos = sosService.selectById(id);
        return R.ok().put("data", sos);
    }

    /**
     * 后端保存
     *///这里这里这里
    @RequestMapping("/save")
    public R save(@RequestBody SOSEntity sos, HttpServletRequest request){
        sos.setUserID(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(sos);
        sosService.insert(sos);
        return R.ok();
    }

    /**
     * 前端保存
     *///这里这里这里
    @RequestMapping("/add")
    public R add(@RequestBody SOSEntity sos, HttpServletRequest request){
        sos.setUserID(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(sos);
        sosService.insert(sos);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SOSEntity sos, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sos);
        sosService.updateById(sos);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sosService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<SOSEntity> wrapper = new EntityWrapper<SOSEntity>();
        if(map.get("remindstart")!=null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if(map.get("remindend")!=null) {
            wrapper.le(columnName, map.get("remindend"));
        }

        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("userdetails")) {
            wrapper.eq("UserID", (String)request.getSession().getAttribute("Name"));
        }

        int count = sosService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}
