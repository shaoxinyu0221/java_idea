package com.bbs.entity;

public class Remark {

    private Integer id;
    private String content;
    private Integer main;
    /**
     * 外键user 的id
     */
    private Integer author;
    private String remarktime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMain() {
        return main;
    }

    public void setMain(Integer main) {
        this.main = main;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getRemarktime() {
        return remarktime;
    }

    public void setRemarktime(String remarktime) {
        this.remarktime = remarktime;
    }

    @Override
    public String toString() {
        return "Remark{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", main=" + main +
                ", author=" + author +
                ", remarktime='" + remarktime + '\'' +
                '}';
    }
}
