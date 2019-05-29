package com.example.a41845.day02_zuoye2;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class bean {

    @Id(autoincrement = true)
    private Long id;

    private String name;

    @Generated(hash = 428879723)
    public bean(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 222412539)
    public bean() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
