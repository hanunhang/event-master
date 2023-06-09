package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.MapEntity;
import com.entity.view.MapView;
import com.entity.vo.MapVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MapService extends IService<MapEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<MapVO> selectListVO(Wrapper<MapEntity> wrapper);

    MapVO selectVO(@Param("ew") Wrapper<MapEntity> wrapper);

    List<MapView> selectListView(Wrapper<MapEntity> wrapper);

    MapView selectView(@Param("ew") Wrapper<MapEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<MapEntity> wrapper);
}
