package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.StatisticDashboardEntity;
import com.entity.view.StatisticDashboardView;
import com.entity.vo.StatisticDashboardVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatisticDashboardDao extends BaseMapper<StatisticDashboardEntity> {

    List<StatisticDashboardVO> selectListVO(@Param("ew") Wrapper<StatisticDashboardEntity> wrapper);

    StatisticDashboardVO selectVO(@Param("ew") Wrapper<StatisticDashboardEntity> wrapper);

    List<StatisticDashboardView> selectListView(@Param("ew") Wrapper<StatisticDashboardEntity> wrapper);

    List<StatisticDashboardView> selectListView(Pagination page, @Param("ew") Wrapper<StatisticDashboardEntity> wrapper);

    StatisticDashboardView selectView(@Param("ew") Wrapper<StatisticDashboardEntity> wrapper);
}
