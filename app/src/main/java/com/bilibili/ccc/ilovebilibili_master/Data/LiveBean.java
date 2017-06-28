package com.bilibili.ccc.ilovebilibili_master.Data;

/**
 * 专题数据Bean
 */
public class LiveBean {

    private String title;
    private int count;
    private int imageId;

    public LiveBean() {
    }

    public LiveBean(String title, int count,int imageId) {
        this.title = title;
        this.count = count;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LiveBean{" +
                "title='" + title + '\'' +
                ", count=" + count +
                '}';
    }
}
