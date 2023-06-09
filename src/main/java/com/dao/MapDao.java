package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MapEntity;
import com.entity.view.MapView;
import com.entity.vo.MapVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MapDao extends BaseMapper<MapEntity> {
    List<MapVO> selectListVO(@Param("ew") Wrapper<MapEntity> wrapper);

    MapVO selectVO(@Param("ew") Wrapper<MapEntity> wrapper);

    List<MapView> selectListView(@Param("ew") Wrapper<MapEntity> wrapper);

    List<MapView> selectListView(Pagination page, @Param("ew") Wrapper<MapEntity> wrapper);

    MapView selectView(@Param("ew") Wrapper<MapEntity> wrapper);

}
