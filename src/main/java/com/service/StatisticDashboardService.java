package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.StatisticDashboardEntity;
import com.entity.view.StatisticDashboardView;
import com.entity.vo.StatisticDashboardVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StatisticDashboardService extends IService<StatisticDashboardEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<StatisticDashboardVO> selectListVO(Wrapper<StatisticDashboardEntity> wrapper);

    StatisticDashboardVO selectVO(@Param("ew") Wrapper<StatisticDashboardEntity> wrapper);

    List<StatisticDashboardView> selectListView(Wrapper<StatisticDashboardEntity> wrapper);

    StatisticDashboardView selectView(@Param("ew") Wrapper<StatisticDashboardEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<StatisticDashboardEntity> wrapper);
}
