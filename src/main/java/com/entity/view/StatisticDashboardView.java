package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.MapEntity;
import com.entity.StatisticDashboardEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

@TableName("userdetails")
public class StatisticDashboardView extends StatisticDashboardEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public StatisticDashboardView(){

    }

    public StatisticDashboardView(StatisticDashboardEntity statisticDashboardEntity){
        try {
            BeanUtils.copyProperties(this, statisticDashboardEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
