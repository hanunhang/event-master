package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.HuodongbaomingEntity;
import com.entity.QuxiaobaomingEntity;
import com.entity.ReportEntity;
import com.entity.view.HuodongbaomingView;
import com.entity.view.ReportView;
import com.entity.vo.HuodongbaomingVO;
import com.entity.vo.QuxiaobaomingVO;
import com.entity.vo.ReportVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportDao extends BaseMapper<ReportEntity> {

    List<ReportVO> selectListVO(@Param("ew") Wrapper<ReportEntity> wrapper);

    ReportVO selectVO(@Param("ew") Wrapper<ReportEntity> wrapper);

    List<ReportView> selectListView(@Param("ew") Wrapper<ReportEntity> wrapper);

    List<ReportView> selectListView(Pagination page, @Param("ew") Wrapper<ReportEntity> wrapper);

    ReportView selectView(@Param("ew") Wrapper<ReportEntity> wrapper);
}
