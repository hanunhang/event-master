package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.UploadBulletinEntity;
import com.entity.view.UploadBulletinView;
import com.entity.vo.UploadBulletinVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UploadBulletinService extends IService<UploadBulletinEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<UploadBulletinVO> selectListVO(Wrapper<UploadBulletinEntity> wrapper);

    UploadBulletinVO selectVO(@Param("ew") Wrapper<UploadBulletinEntity> wrapper);

    List<UploadBulletinView> selectListView(Wrapper<UploadBulletinEntity> wrapper);

    UploadBulletinView selectView(@Param("ew") Wrapper<UploadBulletinEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<UploadBulletinEntity> wrapper);
}
