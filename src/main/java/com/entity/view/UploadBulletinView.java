package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.MapEntity;
import com.entity.UploadBulletinEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("announcement")
public class UploadBulletinView extends UploadBulletinEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    public UploadBulletinView(){

    }
    public UploadBulletinView(UploadBulletinEntity uploadBulletinEntity){
        try {
            BeanUtils.copyProperties(this, uploadBulletinEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
