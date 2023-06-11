package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.SOSEntity;
import com.entity.view.SOSView;
import com.entity.vo.SOSVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SOSService extends IService<SOSEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<SOSVO> selectListVO(Wrapper<SOSEntity> wrapper);

    SOSVO selectVO(@Param("ew") Wrapper<SOSEntity> wrapper);

    List<SOSView> selectListView(Wrapper<SOSEntity> wrapper);

    SOSView selectView(@Param("ew") Wrapper<SOSEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<SOSEntity> wrapper);
}
