package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.CallSOSEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("sos")
public class CallSOSView extends CallSOSEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public CallSOSView(){

    }

    public CallSOSView(CallSOSEntity callSOSEntity){
        try {
            BeanUtils.copyProperties(this, callSOSEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
