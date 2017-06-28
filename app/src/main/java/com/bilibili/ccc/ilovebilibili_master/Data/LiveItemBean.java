package com.bilibili.ccc.ilovebilibili_master.Data;


public class LiveItemBean {
    private int image;
    private String title;
    private String name;
    private int count;

    public LiveItemBean() {
    }

    public LiveItemBean(int image, String title , String name, int count) {
        this.image = image;
        this.title = title;
        this.name = name;
        this.count = count;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LiveItemBean{" +
                "Image=" + image +
                ", title='" + title + '\'' +
                ", content='" + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
