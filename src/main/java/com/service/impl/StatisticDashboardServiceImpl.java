package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.StatisticDashboardDao;
import com.entity.StatisticDashboardEntity;
import com.entity.view.StatisticDashboardView;
import com.entity.vo.StatisticDashboardVO;
import com.service.StatisticDashboardService;
import com.utils.PageUtils;
import com.utils.Query;

import java.util.List;
import java.util.Map;

public class StatisticDashboardServiceImpl extends ServiceImpl<StatisticDashboardDao, StatisticDashboardEntity> implements StatisticDashboardService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StatisticDashboardEntity> page = this.selectPage(
                new Query<StatisticDashboardEntity>(params).getPage(),
                new EntityWrapper<StatisticDashboardEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<StatisticDashboardVO> selectListVO(Wrapper<StatisticDashboardEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public StatisticDashboardVO selectVO(Wrapper<StatisticDashboardEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<StatisticDashboardView> selectListView(Wrapper<StatisticDashboardEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public StatisticDashboardView selectView(Wrapper<StatisticDashboardEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<StatisticDashboardEntity> wrapper) {
        Page<StatisticDashboardView> page =new Query<StatisticDashboardView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

}
