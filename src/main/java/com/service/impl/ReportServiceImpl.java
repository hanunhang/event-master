package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.dao.ReportDao;
import com.entity.ReportEntity;
import com.entity.view.ReportView;
import com.entity.vo.ReportVO;
import com.service.ReportService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("reportService")
public class ReportServiceImpl extends ServiceImpl<ReportDao, ReportEntity> implements ReportService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ReportEntity> page = this.selectPage(
                new Query<ReportEntity>(params).getPage(),
                new EntityWrapper<ReportEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<ReportVO> selectListVO(Wrapper<ReportEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public ReportVO selectVO(Wrapper<ReportEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<ReportView> selectListView(Wrapper<ReportEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ReportView selectView(Wrapper<ReportEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ReportEntity> wrapper) {
        Page<ReportView> page =new Query<ReportView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
