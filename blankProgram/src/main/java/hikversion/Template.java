package hikversion;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:校验文件
 * @Date:2022/5/24
 */
public class Template {
    /**
     * 检查模板标题行模型是否匹配 不检查顺序（需要检查顺序的可自己优化）
     *
     * @param file 上传的excel 文件 对象
     * @param pojoClass 导入模型
     * @param titleRow 标题行下标
     * @return
     */
    public static Boolean checkTemplateTitle(File file, Class<?> pojoClass, Integer titleRow) {

        //excel中标题行的所有标题
        List<String> excelList = new ArrayList<>();
        //注解中所有标题
        List<String> list = new ArrayList<>();
        Field[] fields = pojoClass.getDeclaredFields();
        for (Field field : fields) {
            Annotation excelAnn = field.getAnnotation(ExcelHeader.class);
            if (null != excelAnn) {
                ExcelHeader ec = (ExcelHeader) excelAnn;
                String name = ec.value();
                if (StringUtils.isNotBlank(name)) {
                    list.add(name);
                }
            }
        }
        if (CollectionUtils.isEmpty(list)) {
            return true;
        }
        try {
            InputStream inputStream = new FileInputStream(file);
            if (!(inputStream.markSupported())) {
                inputStream = new PushbackInputStream(inputStream, 8);
            }
            Workbook book = WorkbookFactory.create(inputStream);
            Sheet sheet = book.getSheetAt(0);
            Row row = sheet.getRow(titleRow);
            for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                String value = row.getCell(i).getStringCellValue();
                if (StringUtils.isNotBlank(value)) {
                    excelList.add(value);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("读取文件表头报错");
        }
        if (CollectionUtils.isEmpty(excelList)) {
            return false;
        }
        int i = 0;
        for (String name : list) {
            if (!excelList.contains(name)) {
                i++;
            }
        }
        if (i == 19) {
            return true;
        }
        return false;

    }
}
