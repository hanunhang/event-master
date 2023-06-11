package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.CallSOSEntity;
import com.entity.view.CallSOSView;
import com.entity.vo.CallSOSVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CallSOSDao extends BaseMapper<CallSOSEntity> {
    List<CallSOSVO> selectListVO(@Param("ew") Wrapper<CallSOSEntity> wrapper);

    CallSOSVO selectVO(@Param("ew") Wrapper<CallSOSEntity> wrapper);

    List<CallSOSView> selectListView(@Param("ew") Wrapper<CallSOSEntity> wrapper);

    List<CallSOSView> selectListView(Pagination page, @Param("ew") Wrapper<CallSOSEntity> wrapper);

    CallSOSView selectView(@Param("ew") Wrapper<CallSOSEntity> wrapper);

}
