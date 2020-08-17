package gof23.prototype.demo01;

import java.util.Date;

/**
 * Video
 * 1、实现一个接口   Cloneable
 * 2、重写一个方法   clone
 */

public class Video implements Cloneable {
    //克隆视频
    private String name;
    private Date createTime;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        //实现深克隆 (方法：序列化、反序列化、改造克隆方法)
        Video v = (Video) obj;
        v.createTime= (Date) this.createTime.clone();//将对象的属性值也进行克隆

        return obj;
    }

    public Video() {
    }

    public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
