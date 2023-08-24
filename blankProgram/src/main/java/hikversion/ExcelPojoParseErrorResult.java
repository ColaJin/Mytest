package hikversion;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * csv文件数据转换位指定类型对象的错误结果
 *
 * @author zhouziyue5
 * @since 1.0.0
 */

@NoArgsConstructor
@AllArgsConstructor
public class ExcelPojoParseErrorResult {

    /**
     * excel文件的值map, key:列名，value：值
     */
    private Map<String, String> valueMap;

    /**
     * 转换失败的错误原因，当pojo中存在reason=true的字段才会将该导出到文件
     */
    private String reason;

    public Map<String, String> getValueMap() {
        return valueMap;
    }

    public void setValueMap(Map<String, String> valueMap) {
        this.valueMap = valueMap;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
