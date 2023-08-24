package hikversion;

import java.util.List;

/**
 * @author:jinyandong
 * @description:
 * @Date:2023/8/22
 */
public class Layer {
    private String repeat;
    private List<Source> sources;

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }
}
