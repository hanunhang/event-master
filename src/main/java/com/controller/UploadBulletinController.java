package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.UploadBulletinEntity;
import com.entity.view.UploadBulletinView;
import com.service.UploadBulletinService;
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
 * 上传报告
 * 后端接口
 *
 *
 */
@RestController
@RequestMapping("/Upload Bulletin")
public class UploadBulletinController {

    @Autowired
    private UploadBulletinService uploadBulletinService;

    /**
     * 后端列表
     *
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, UploadBulletinEntity uploadBulletin,
                  HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("announcement")) {
            uploadBulletin.setAnnouncement_id((long)request.getSession().getAttribute("announcement_description"));
        }
        EntityWrapper<UploadBulletinEntity> ew = new EntityWrapper<UploadBulletinEntity>();

        PageUtils page = uploadBulletinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, uploadBulletin), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     *
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,UploadBulletinEntity uploadBulletin,
                  HttpServletRequest request){
        EntityWrapper<UploadBulletinEntity> ew = new EntityWrapper<UploadBulletinEntity>();

        PageUtils page = uploadBulletinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, uploadBulletin), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     *
     */
    @RequestMapping("/lists")
    public R list( UploadBulletinEntity uploadBulletin){
        EntityWrapper<UploadBulletinEntity> ew = new EntityWrapper<UploadBulletinEntity>();
        ew.allEq(MPUtil.allEQMapPre( uploadBulletin, "uploadBulletin"));
        return R.ok().put("data", uploadBulletinService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(UploadBulletinEntity uploadBulletin){
        EntityWrapper< UploadBulletinEntity> ew = new EntityWrapper< UploadBulletinEntity>();
        ew.allEq(MPUtil.allEQMapPre( uploadBulletin, "uploadBulletin"));
        UploadBulletinView uploadBulletinView =  uploadBulletinService.selectView(ew);
        return R.ok("查询公告成功").put("data", uploadBulletinView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        UploadBulletinEntity uploadBulletin = uploadBulletinService.selectById(id);
        return R.ok().put("data", uploadBulletin);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        UploadBulletinEntity uploadBulletin = uploadBulletinService.selectById(id);
        return R.ok().put("data", uploadBulletin);
    }

    /**
     * 后端保存
     *///这里这里这里
    @RequestMapping("/save")
    public R save(@RequestBody UploadBulletinEntity uploadBulletin, HttpServletRequest request){
        uploadBulletin.setAnnouncement_id(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(uploadBulletin);
        uploadBulletinService.insert(uploadBulletin);
        return R.ok();
    }

    /**
     * 前端保存
     *///这里这里这里
    @RequestMapping("/add")
    public R add(@RequestBody UploadBulletinEntity uploadBulletin, HttpServletRequest request){
        uploadBulletin.setAnnouncement_id(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(uploadBulletin);
        uploadBulletinService.insert(uploadBulletin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody UploadBulletinEntity uploadBulletin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(uploadBulletin);
        uploadBulletinService.updateById(uploadBulletin);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        uploadBulletinService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<UploadBulletinEntity> wrapper = new EntityWrapper<UploadBulletinEntity>();
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

        int count = uploadBulletinService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}
