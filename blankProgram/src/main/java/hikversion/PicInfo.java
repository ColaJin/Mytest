package hikversion;

/**
 * @author:jinyandong
 * @description:播放列表图片信息
 * @Date:2023/10/9
 */
public class PicInfo {
    private Integer start = 0;
    private Integer end = 0;
    private String fileType = "";
    private String name = "";

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
