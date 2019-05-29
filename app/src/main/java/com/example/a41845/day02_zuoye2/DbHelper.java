package com.example.a41845.day02_zuoye2;

import com.example.a41845.day02_zuoye2.dao.DaoMaster;
import com.example.a41845.day02_zuoye2.dao.DaoSession;
import com.example.a41845.day02_zuoye2.dao.beanDao;

import java.util.List;

public class DbHelper {

    private static DbHelper dbHelper;
    private final com.example.a41845.day02_zuoye2.dao.beanDao beanDao;

    public DbHelper(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getApp(), "ss.db");

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());

        DaoSession daoSession = daoMaster.newSession();

        beanDao = daoSession.getBeanDao();
    }

    public static DbHelper getDbHelper() {
        if (dbHelper == null){
            synchronized (DbHelper.class){
                if (dbHelper == null){
                    dbHelper = new DbHelper();
                }
            }
        }
        return dbHelper;
    }

    public void insert(bean bean){
        if (has(bean)){
            return;
        }
        beanDao.insertOrReplace(bean);
    }

    public List<bean> query(){
        return beanDao.queryBuilder().list();
    }

    public boolean has(bean bean){
        List<com.example.a41845.day02_zuoye2.bean> list = beanDao.queryBuilder().where(com.example.a41845.day02_zuoye2.dao.beanDao.Properties.Name.eq(bean.getName())).list();
        if (list.size()>0){
            return true;
        }
        return false;
    }
}
