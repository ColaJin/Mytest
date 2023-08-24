package hikversion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * csv导入结果
 *
 * @author zhouziyue5
 * @since 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExcelImportResult<T> {

    /**
     * 数据合规结果集
     */
    private List<T> list;

    /**
     * 文件格式是否与模板一致
     * false时不会进行数据读取，list和pojoParseErrorResults结果为空
     */
    private Boolean formatCorrect;

    /**
     * 待导入pojo对象自定义验证和字段转换错误结果集
     */
    private List<ImportDeviceUserFailedInfo> pojoParseErrorResults;

}
