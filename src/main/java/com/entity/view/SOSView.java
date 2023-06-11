package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.SOSEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("userdetails")
public class SOSView extends SOSEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public SOSView(){

    }

    public SOSView(SOSEntity sosEntity){
        try {
            BeanUtils.copyProperties(this, sosEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
