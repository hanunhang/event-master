package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.UploadBulletinDao;
import com.entity.UploadBulletinEntity;
import com.entity.view.UploadBulletinView;
import com.entity.vo.UploadBulletinVO;
import com.service.UploadBulletinService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("uploadBulletinService")
public class UploadBulletinImpl extends ServiceImpl<UploadBulletinDao, UploadBulletinEntity> implements UploadBulletinService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UploadBulletinEntity> page = this.selectPage(
                new Query<UploadBulletinEntity>(params).getPage(),
                new EntityWrapper<UploadBulletinEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public List<UploadBulletinVO> selectListVO(Wrapper<UploadBulletinEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public UploadBulletinVO selectVO(Wrapper<UploadBulletinEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<UploadBulletinView> selectListView(Wrapper<UploadBulletinEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public UploadBulletinView selectView(Wrapper<UploadBulletinEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<UploadBulletinEntity> wrapper) {
        Page<UploadBulletinView> page =new Query<UploadBulletinView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }
}
