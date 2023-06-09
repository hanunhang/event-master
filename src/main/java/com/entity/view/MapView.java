package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.MapEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("announcement")
public class MapView extends MapEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public MapView(){

    }

    public MapView(MapEntity mapEntity){
        try {
            BeanUtils.copyProperties(this, mapEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
