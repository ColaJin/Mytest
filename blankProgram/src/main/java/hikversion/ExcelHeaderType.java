package hikversion;

/**
 * @author:jinyandong
 * @description:Excel表头
 * @Date:2022/5/24
 */
public enum ExcelHeaderType {
    /**
     * 导入（读取文件根据列头获取数据）
     * 影响文件导入和模板导出
     *
     */
    IMPORT,

    /**
     * 导出（生成文件根据列头填充数据）
     */
    EXPORT,

    /**
     * 导入后返回结果文件相对IMPORT新增的列(与IMPORT共用排序）
     */
    IMPORT_RESULT,
    ;
}
