package hikversion;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 网络工具返回
 */
public class TabulationDto implements Comparable<TabulationDto>{

    @JsonProperty("key")
    private String key;
    @JsonProperty("label")
    private String label;
    @JsonProperty("order")
    private Integer order;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public int compareTo(TabulationDto other) {
        return this.order.compareTo(other.getOrder()); // 根据名称进行排序
    }
}
