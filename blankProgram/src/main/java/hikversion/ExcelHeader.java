package hikversion;

import java.lang.annotation.*;

/**
 * @author:jinyandong
 * @description:Excel表头
 * @Date:2022/5/24
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface ExcelHeader {
    /**
     * 列头名称
     * @return
     */
    String value();

    /**
     * 列头类型，导入、导出、导入结果
     * @return
     */
    ExcelHeaderType[] type() default {ExcelHeaderType.IMPORT, ExcelHeaderType.EXPORT};

    /**
     * 顺序字段 0最前
     * @return
     */
    int order() default 0;
}
