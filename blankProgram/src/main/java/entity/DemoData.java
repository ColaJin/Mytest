package entity;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import org.apache.poi.ss.usermodel.FillPatternType;

@Data
public class DemoData {
    @ColumnWidth
     // 定义宽度
    @ExcelProperty("用户名") // 定义列名称
    /*@ContentStyle(fillPatternType = FillPatternType.SOLID_FOREGROUND, fillForegroundColor = 40)*/
    private String username;
    @ExcelProperty("密码")
    private String password;
}
