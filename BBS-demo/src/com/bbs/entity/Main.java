package com.bbs.entity;

public class Main {

    private Integer id;
    private String title;
    private String content;
    /**
     * 外键user的id
     */
    private Integer author;
    private Integer module;
    private String addtime;
    private Integer viewnum;
    private Integer remarknum;
    private String name;
    private String nickname;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public Integer getViewnum() {
        return viewnum;
    }

    public void setViewnum(Integer viewnum) {
        this.viewnum = viewnum;
    }

    public Integer getRemarknum() {
        return remarknum;
    }

    public void setRemarknum(Integer remarknum) {
        this.remarknum = remarknum;
    }

    @Override
    public String toString() {
        return "Main{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", Module=" + module +
                ", addtime='" + addtime + '\'' +
                ", viewnum=" + viewnum +
                ", remarknum=" + remarknum +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
