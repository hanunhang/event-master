package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.SOSDao;
import com.entity.SOSEntity;
import com.entity.view.SOSView;
import com.entity.vo.SOSVO;
import com.service.SOSService;
import com.utils.PageUtils;
import com.utils.Query;

import java.util.List;
import java.util.Map;

public class SOSServiceImpl extends ServiceImpl<SOSDao, SOSEntity> implements SOSService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SOSEntity> page = this.selectPage(
                new Query<SOSEntity>(params).getPage(),
                new EntityWrapper<SOSEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<SOSVO> selectListVO(Wrapper<SOSEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public SOSVO selectVO(Wrapper<SOSEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<SOSView> selectListView(Wrapper<SOSEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public SOSView selectView(Wrapper<SOSEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<SOSEntity> wrapper) {
        Page<SOSView> page =new Query<SOSView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
