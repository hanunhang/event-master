package com.controller;


import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.StatisticDashboardEntity;
import com.entity.view.StatisticDashboardView;
import com.service.StatisticDashboardService;
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
 * 用户仪表盘
 * 后端接口
 *
 *
 */

@RestController
@RequestMapping("/viewStatisticDashboard")
public class StatisticDashboardController {

    @Autowired
    private StatisticDashboardService statisticDashboardService;

    /**
     * 后端列表
     *
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, StatisticDashboardEntity statisticDashboard,
                  HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("userdetails")) {
            statisticDashboard.setUserID((long)request.getSession().getAttribute("Name"));
        }
        EntityWrapper<StatisticDashboardEntity> ew = new EntityWrapper<StatisticDashboardEntity>();

        PageUtils page = statisticDashboardService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, statisticDashboard), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     *
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,StatisticDashboardEntity statisticDashboard,
                  HttpServletRequest request){
        EntityWrapper<StatisticDashboardEntity> ew = new EntityWrapper<StatisticDashboardEntity>();

        PageUtils page = statisticDashboardService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, statisticDashboard), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     *
     */
    @RequestMapping("/lists")
    public R list( StatisticDashboardEntity statisticDashboard){
        EntityWrapper<StatisticDashboardEntity> ew = new EntityWrapper<StatisticDashboardEntity>();
        ew.allEq(MPUtil.allEQMapPre( statisticDashboard, "statisticDashboard"));
        return R.ok().put("data", statisticDashboardService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(StatisticDashboardEntity statisticDashboard){
        EntityWrapper< StatisticDashboardEntity> ew = new EntityWrapper< StatisticDashboardEntity>();
        ew.allEq(MPUtil.allEQMapPre( statisticDashboard, "statisticDashboard"));
        StatisticDashboardView statisticDashboardView =  statisticDashboardService.selectView(ew);
        return R.ok("查询信息成功").put("data", statisticDashboardView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        StatisticDashboardEntity statisticDashboard = statisticDashboardService.selectById(id);
        return R.ok().put("data", statisticDashboard);
    }

    /**
     * 前端详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        StatisticDashboardEntity statisticDashboard = statisticDashboardService.selectById(id);
        return R.ok().put("data", statisticDashboard);
    }

    /**
     * 后端保存
     *///这里这里这里
    @RequestMapping("/save")
    public R save(@RequestBody StatisticDashboardEntity statisticDashboard, HttpServletRequest request){
        statisticDashboard.setUserID(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(statisticDashboard);
        statisticDashboardService.insert(statisticDashboard);
        return R.ok();
    }

    /**
     * 前端保存
     *///这里这里这里
    @RequestMapping("/add")
    public R add(@RequestBody StatisticDashboardEntity statisticDashboard, HttpServletRequest request){
        statisticDashboard.setUserID(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
        //ValidatorUtils.validateEntity(statisticDashboard);
        statisticDashboardService.insert(statisticDashboard);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody StatisticDashboardEntity statisticDashboard, HttpServletRequest request){
        //ValidatorUtils.validateEntity(statisticDashboard);
        statisticDashboardService.updateById(statisticDashboard);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        statisticDashboardService.deleteBatchIds(Arrays.asList(ids));
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

        Wrapper<StatisticDashboardEntity> wrapper = new EntityWrapper<StatisticDashboardEntity>();
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

        int count = statisticDashboardService.selectCount(wrapper);
        return R.ok().put("count", count);
    }
}
