package com.bbs.entity;

import java.util.List;

public class User {

    private Integer id;
    private String account;
    private String password;
    private String nickname;
    private String email;
    private Integer score;
    private String avatar;
    private Integer topicnums;
    private Integer replaynums;
    private String regtime;
    private String role;
    public static final String MASTER = "0";

    private List<Main> mainList;

    public List<Main> getMainList() {
        return mainList;
    }

    public void setMainList(List<Main> mainList) {
        this.mainList = mainList;
    }

        public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getTopicnums() {
        return topicnums;
    }

    public void setTopicnums(Integer topicnums) {
        this.topicnums = topicnums;
    }

    public Integer getReplaynums() {
        return replaynums;
    }

    public void setReplaynums(Integer replaynums) {
        this.replaynums = replaynums;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", score=" + score +
                ", avatar='" + avatar + '\'' +
                ", topicnums=" + topicnums +
                ", replaynums=" + replaynums +
                ", regtime='" + regtime + '\'' +
                ", role=" + role +
                '}';
    }
}
