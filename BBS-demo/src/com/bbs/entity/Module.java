package com.bbs.entity;

import java.util.List;

public class Module {

    private Integer id;
    private String name;
    private String description;
    /**
     * 外键user的id
     */
    private Integer master;
    private User user;

    private List<Main> mainList;

//    private String account;
//    private String email;
//    private String regtime;



//    public String getAccount() {
//        return account;
//    }
//
//    public void setAccount(String account) {
//        this.account = account;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getRegtime() {
//        return regtime;
//    }
//
//    public void setRegtime(String regtime) {
//        this.regtime = regtime;
//    }


    public List<Main> getMainList() {
        return mainList;
    }

    public void setMainList(List<Main> mainList) {
        this.mainList = mainList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaster() {
        return master;
    }

    public void setMaster(Integer master) {
        this.master = master;
    }

//    @Override
//    public String toString() {
//        return "Module{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", master=" + master +
//                ", account='" + account + '\'' +
//                ", email='" + email + '\'' +
//                ", regtime='" + regtime + '\'' +
//                '}';
//    }

//    @Override
//    public String toString() {
//        return "Module{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", master=" + master +
//                ", user=" + user +
//                '}';
//    }


    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", master=" + master +
                ", user=" + user +
                ", mainList=" + mainList +
                '}';
    }
}
