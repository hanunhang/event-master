package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MapEntity;
import com.entity.UploadBulletinEntity;
import com.entity.view.UploadBulletinView;
import com.entity.vo.UploadBulletinVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UploadBulletinDao extends BaseMapper<UploadBulletinEntity> {
    List<UploadBulletinVO> selectListVO(@Param("ew") Wrapper<UploadBulletinEntity> wrapper);

    UploadBulletinVO selectVO(@Param("ew") Wrapper<UploadBulletinEntity> wrapper);

    List<UploadBulletinView> selectListView(@Param("ew") Wrapper<UploadBulletinEntity> wrapper);

    List<UploadBulletinView> selectListView(Pagination page, @Param("ew") Wrapper<UploadBulletinEntity> wrapper);

    UploadBulletinView selectView(@Param("ew") Wrapper<UploadBulletinEntity> wrapper);

}
