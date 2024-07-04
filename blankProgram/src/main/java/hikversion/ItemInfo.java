package hikversion;

import java.util.List;

/**
 * @author:jinyandong
 * @description:列表相关动作参数
 * @Date:2023/8/11
 */
public class ItemInfo {
    private Integer number = 0;
    private Integer stayTime=0;
    private String enterType= "";
    //private String stayType= "";
    private String outType= "";
    private Integer speed= 2;
    private List<Content> contentList;

    private List<PicInfo> picList;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStayTime() {
        return stayTime;
    }

    public void setStayTime(Integer stayTime) {
        this.stayTime = stayTime;
    }

    public String getEnterType() {
        return enterType;
    }

    public void setEnterType(String enterType) {
        this.enterType = enterType;
    }

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    public List<PicInfo> getPicList() {
        return picList;
    }

    public void setPicList(List<PicInfo> picList) {
        this.picList = picList;
    }

    public ItemInfo() {
    }
}
