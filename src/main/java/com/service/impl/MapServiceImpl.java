package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.MapDao;
import com.entity.MapEntity;
import com.entity.view.MapView;
import com.entity.view.ReportView;
import com.entity.vo.MapVO;
import com.service.MapService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("mapService")
public class MapServiceImpl extends ServiceImpl<MapDao, MapEntity> implements MapService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MapEntity> page = this.selectPage(
                new Query<MapEntity>(params).getPage(),
                new EntityWrapper<MapEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<MapVO> selectListVO(Wrapper<MapEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public MapVO selectVO(Wrapper<MapEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<MapView> selectListView(Wrapper<MapEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public MapView selectView(Wrapper<MapEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<MapEntity> wrapper) {
        Page<MapView> page =new Query<MapView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
