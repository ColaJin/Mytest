package hikversion;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author:jinyandong
 * @description:测试excel读取
 * @Date:2022/5/24
 */
public class TestExcel {

    public static void main(String[] args) {
        /*Template template = new Template();
        template.checkTemplateTitle(new File(""),DeviceUser.class,2);*/

        // getFieldNameMapByClassExcelHeaders(DeviceUser.class);

        // readCsv2MapImportDevice(new File("D:/testImport.xlsx"), DeviceUser.class);
        //readCsv2MapImportDevice(new File("D:/testImport.xlsx"), DeviceUser.class);

        List<DeviceUser> list = new ArrayList<>();
        DeviceUser deviceUser = new DeviceUser();
        deviceUser.setArea("市政局");
        deviceUser.setDeviceIndexCode("13439u43hfe872hu32873-88");
        list.add(deviceUser);

        List<String> fieldExcelHeaders = getAndSortExcelHeaderValueList(DeviceUser.class, new HashMap<>(), ExcelHeaderType.EXPORT);
        List<String[]> values = pojo2StringArrayWithExcelort(list, DeviceUser.class, ExcelHeaderType.EXPORT);
        if (!CollectionUtils.isEmpty(values)) {
            for (String[] content : values) {
                for (int i = 0; i< content.length;i++) {
                    System.out.println(content[i]);
                }
            }
        }

    }

    private static List<String> getExcelHeaderValueList(Class<?> pojoClass) {
        Set<String> fieldSet = new HashSet<>();
        Field[] fields = pojoClass.getDeclaredFields();
        for (Field field : fields) {
            ExcelHeader csvHeader = field.getAnnotation(ExcelHeader.class);
            if (csvHeader != null) {
                fieldSet.add(csvHeader.value());
            }
        }
        Class<?> superClass = pojoClass.getSuperclass();
        if (superClass != null) {
            fieldSet.addAll(getExcelHeaderValueList(superClass));
        }
        return fieldSet.stream().collect(Collectors.toList());
    }

    private static Map<String, String> getFieldNameMapByClassExcelHeaders(Class<?> pojoClass) {
        Map<String, String> fieldMap = new HashMap<>();
        Field[] fields = pojoClass.getDeclaredFields();
        for (Field field : fields) {
            ExcelHeader excelHeader = field.getAnnotation(ExcelHeader.class);
            if (excelHeader != null) {
                fieldMap.put(excelHeader.value(), field.getName());
            }
        }
        if (pojoClass.getSuperclass() != null) {
            fieldMap.putAll(getFieldNameMapByClassExcelHeaders(pojoClass.getSuperclass()));
        }
        return fieldMap;
    }

    private static <T> ExcelImportResult<T> readCsv2MapImportDevice(File file, Class<T> pojoClass) {

        List<T> successResults = new ArrayList<>();

        List<ImportDeviceUserFailedInfo> importDeviceFailedInfos = new ArrayList<>();

        Workbook workbook = null;
        List<Map<String, String>> results = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        try {
            workbook = WorkbookFactory.create(file);

            // 获取一张表 根据表格的头确定是否是西电的
            Sheet sheet0 = workbook.getSheetAt(1);
            // 查看第一个sheet的表格列数是否为4是则为基线，否则为西电
            // 取得第1行数据
            Row rowFirst = sheet0.getRow(0);

            String[] headers = new String[22];
            for (int j = 0; j < 22; j++) {
                if (rowFirst.getCell(j) != null) {
                    String col = rowFirst.getCell(j + 1).toString();
                    headers[j] = col;
                }
            }

            // 验证文件格式是否正确
            List<String> excelHeaderValueList = getExcelHeaderValueList(pojoClass);
            for (int i = 0; i < 22; i++) {
                if (!CollectionUtils.isEmpty(excelHeaderValueList)) {
                    if (!excelHeaderValueList.contains(headers[i])) {
                        return new ExcelImportResult<>(new ArrayList<>(), false, new ArrayList<>());
                    }
                } else {
                    return new ExcelImportResult<>(new ArrayList<>(), false, new ArrayList<>());
                }
            }

            String value = "";
            for (int i = 1; i <= sheet0.getLastRowNum(); i++) {
                Row row = sheet0.getRow(i);
                for (int curLine = 0; curLine < headers.length; curLine++) {
                    // 需要判断空指针异常
                    value = "";
                    Cell cell = row.getCell(curLine + 1);

                    if (cell != null) {
                        // Cannot get a STRING value from a NUMERIC cell
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        value = cell.getStringCellValue();
                    }

                    map.put(headers[curLine], value);
                }


                Map<String, String> fieldMap = getFieldNameMapByClassExcelHeaders(pojoClass);
                Map<String, String> pojoValueMapForFieldName = new HashMap<>();//maintainer3:null deviceFir:基础网络
                Map<String, String> pojoValueMapForExcelName = new HashMap<>();
                for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                    if (!StringUtils.equals(map.get(entry.getKey()), "")) {
                        pojoValueMapForFieldName.put(entry.getValue(), map.get(entry.getKey()));
                        pojoValueMapForExcelName.put(entry.getKey(), map.get(entry.getKey()));
                    } else {
                        pojoValueMapForFieldName.put(entry.getValue(), null);
                        pojoValueMapForExcelName.put(entry.getKey(), null);
                    }

                }

                List<String> deviceIndexCodesInDB = new ArrayList<>();
                deviceIndexCodesInDB.add("386236770:234150912-ec57e87353c8425a957a43f4c9280ab7");
                deviceIndexCodesInDB.add("386236770:234150912-5239984537924364914b909fc150e4cd");
                deviceIndexCodesInDB.add("386236770:234150912-0e5cf09fb4294f8397530dbbef3fc7ef");
                deviceIndexCodesInDB.add("386209373:627625472-5d0cfeb9fc0e4ed3b0d1f7600b9647cc");
                List<String> userIndexCodeInDB = new ArrayList<>();
                userIndexCodeInDB.add("21560166");
                userIndexCodeInDB.add("19050109");
                userIndexCodeInDB.add("16030256");
                userIndexCodeInDB.add("6516");
                userIndexCodeInDB.add("19070089");

                // 需要校验字段是否
                String errorMsg = validateFieldValue(pojoValueMapForFieldName, deviceIndexCodesInDB, userIndexCodeInDB);
                if (StringUtils.isEmpty(errorMsg)) {
                    successResults.add(JSON.parseObject(JSON.toJSONString(pojoValueMapForFieldName), pojoClass));
                } else {

                    importDeviceFailedInfos.add(new ImportDeviceUserFailedInfo(String.valueOf(i + 1), errorMsg));
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }

        return new ExcelImportResult<>(successResults, true, importDeviceFailedInfos);

    }

    /*private static <T> ExcelImportResult<T> readExcelPojoImportDeviceUser(File file, Class<T> pojoClass) {

        List<ExcelPojoParseErrorResult> csvPojoParseErrorResults = new ArrayList<>();
        List<T> successResults = new ArrayList<>();
        Map<String, String> fieldMap = getFieldNameMapByClassExcelHeaders(pojoClass);
        ExcelImportResult<Map<String, String>> valueMapResult = readCsv2MapImportDevice(file, pojoClass);
        if (!valueMapResult.getFormatCorrect() || CollectionUtils.isEmpty(valueMapResult.getList()) || CollectionUtils.isEmpty(fieldMap)) {
            return new ExcelImportResult<>(successResults, valueMapResult.getFormatCorrect(), csvPojoParseErrorResults);
        }
        for (Map<String, String> valueMap : valueMapResult.getList()) {
            Map<String, String> pojoValueMapForFieldName = new HashMap<>();//maintainer3:null deviceFir:基础网络
            Map<String, String> pojoValueMapForCsvName = new HashMap<>();//维保人2姓名:null 设备一级分类：基础网络
            for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                if (!StringUtils.equals(valueMap.get(entry.getKey()), "")) {
                    pojoValueMapForFieldName.put(entry.getValue(), valueMap.get(entry.getKey()));
                    pojoValueMapForCsvName.put(entry.getKey(), valueMap.get(entry.getKey()));
                } else {
                    pojoValueMapForFieldName.put(entry.getValue(), null);
                    pojoValueMapForCsvName.put(entry.getKey(), null);
                }
            }

            successResults.add(JSON.parseObject(JSON.toJSONString(pojoValueMapForFieldName), pojoClass));
        }
        return new ExcelImportResult<>(successResults, true, new ArrayList<>());
    }*/

    private static String getReasonExcelHeaderName(Class<?> pojoClass, ExcelHeaderType... excelHeaderType) {
        Field[] fields = pojoClass.getDeclaredFields();
        for (Field field : fields) {
            ExcelHeader excelHeader = field.getAnnotation(ExcelHeader.class);
            // 用于检查两个指定的集合是否不相交。如果两个指定的集合没有相同的元素，则返回true。
            if (excelHeader != null && !Collections.disjoint(Arrays.asList(excelHeader.type()), Arrays.asList(excelHeaderType))) {
                return excelHeader.value();
            }
        }
        return null;
    }

    private static String validateFieldValue(Map<String, String> valueMap, Class<?> pojoClass) {
        StringBuffer errorMsg = new StringBuffer();
        // 设备编号不能为空且要存在
        // 运维老师不能同时为空
        // 维保人员不能同时为空
        String teacher1 = "";
        String teacher2 = "";
        String maintainer1 = "";
        String maintainer2 = "";
        String maintainer3 = "";
        for (Map.Entry<String, String> entry : valueMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (StringUtils.equals(key, "设备编号")) {
                if (StringUtils.isBlank(value)) {
                    errorMsg.append("设备编号为空");
                    return errorMsg.toString();
                } else {
                    // 验证设备编号是否存在不存在则返回
                    errorMsg.append("设备编号不存在");
                    return errorMsg.toString();
                }
            } else if (StringUtils.equals(key, "运维老师1")) {
                teacher1 = value;
            } else if (StringUtils.equals(key, "运维老师2")) {
                teacher2 = value;
            } else if (StringUtils.equals(key, "维保人员1")) {
                maintainer1 = value;
            } else if (StringUtils.equals(key, "维保人员2")) {
                maintainer2 = value;
            } else if (StringUtils.equals(key, "维保人员3")) {
                maintainer3 = value;
            }

        }

        if (StringUtils.isBlank(teacher1) && StringUtils.isBlank(teacher2)) {
            errorMsg.append("运维老师1和运维老师2均为空");
            return errorMsg.toString();
        }

        if (StringUtils.isBlank(maintainer1) && StringUtils.isBlank(maintainer2) && StringUtils.isBlank(maintainer3)) {
            errorMsg.append("维保人1、维保人2、维保人3均为空");
            return errorMsg.toString();
        }
        return errorMsg.toString();
    }

    public static String validateFieldValue(Map<String, String> valueMap, List<String> deviceIndexCodesInDB, List<String> userIndexCodeInDB) {

        DeviceUser deviceUser = JSON.parseObject(JSON.toJSONString(valueMap), DeviceUser.class);

        StringBuffer errorMsg = new StringBuffer();
        // 设备编号不能为空且要存在
        // 运维老师不能同时为空
        // 维保人员不能同时为空
        String teacher1 = "";
        String teacher2 = "";
        String maintainer1 = "";
        String maintainer2 = "";
        String maintainer3 = "";
        boolean teacher1false = false;
        boolean teacher2false = false;
        boolean maintainer1false = false;
        boolean maintainer2false = false;
        boolean maintainer3false = false;
        /*for (Map.Entry<String, String> entry : valueMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (StringUtils.equals(key, "deviceIndexCode")) {
                if (StringUtils.isBlank(value)) {
                    errorMsg.append("设备编号为空");
                    return errorMsg.toString();
                } else {
                    // 验证设备编号是否存在不存在则返回
                    if (!deviceIndexCodesInDB.contains(value)) {
                        errorMsg.append("设备编号不存在");
                        return errorMsg.toString();
                    }
                }
            } else if (StringUtils.equals(key, "user1")) {
                if (userIndexCodeInDB.contains(teacher1)) {
                    teacher1 = value;
                } else {
                    teacher1false = true;
                    errorMsg.append("运维老师1不存在");
                }
            } else if (StringUtils.equals(key, "user2")) {
                if (userIndexCodeInDB.contains(teacher2)) {
                    teacher2 = value;
                } else {
                    teacher2false = true;
                    errorMsg.append("运维老师2不存在");
                }
            } else if (StringUtils.equals(key, "maintainer1")) {
                if (userIndexCodeInDB.contains(maintainer1)) {
                    maintainer1 = value;
                } else {
                    maintainer1false = true;
                    errorMsg.append("维保人员1不存在");
                }
            } else if (StringUtils.equals(key, "maintainer2")) {
                if (userIndexCodeInDB.contains(maintainer2)) {
                    maintainer2 = value;
                } else {
                    maintainer2false = true;
                    errorMsg.append("维保人员2不存在");
                }
            } else if (StringUtils.equals(key, "maintainer3")) {
                if (userIndexCodeInDB.contains(maintainer3)) {
                    maintainer3 = value;
                } else {
                    maintainer3false = true;
                    errorMsg.append("维保人员3不存在");
                }
            }

        }

        if (StringUtils.isBlank(teacher1) && StringUtils.isBlank(teacher2)) {
            if (teacher1false && teacher2false) {
                // 两个运维老师都不存在
                return errorMsg.toString();
            }
            errorMsg.append("运维老师1和运维老师2均为空");
            return errorMsg.toString();
        }

        if (StringUtils.isBlank(maintainer1) && StringUtils.isBlank(maintainer2) && StringUtils.isBlank(maintainer3)) {
            if (maintainer1false && maintainer2false && maintainer3false) {
                // 三个维保人员
                return errorMsg.toString();
            }
            errorMsg.append("维保人1、维保人2、维保人3均为空");
            return errorMsg.toString();
        }
        return errorMsg.toString();*/

        if (StringUtils.equals(deviceUser.getDeviceIndexCode(), "386236770:234150912-ec57e87353c8425a957a43f4c9280ab7")) {
            System.out.println("dddsddede");
        }

        if (deviceUser == null) {
            return errorMsg.append("此行为空").toString();
        } else {
            if (StringUtils.isBlank(deviceUser.getDeviceIndexCode())) {
                return errorMsg.append("设备编号为空").toString();
            } else {
                if (!deviceIndexCodesInDB.contains(deviceUser.getDeviceIndexCode())) {
                    errorMsg.append("设备编号不存在");
                    return errorMsg.toString();
                }
            }

            if (!StringUtils.isBlank(deviceUser.getUserNo1())) {
                if (userIndexCodeInDB.contains(deviceUser.getUserNo1())) {
                } else {
                    errorMsg.append("运维老师1不存在，");
                }
            } else {
                teacher1false = true;
            }
            if (!StringUtils.isBlank(deviceUser.getUserNo2())) {
                if (userIndexCodeInDB.contains(deviceUser.getUserNo2())) {
                } else {
                    errorMsg.append("运维老师2不存在，");
                }
            } else {
                teacher2false = true;
            }


            if (!StringUtils.isBlank(deviceUser.getMaintainerNo1())) {
                if (userIndexCodeInDB.contains(deviceUser.getMaintainerNo1())) {
                } else {
                    errorMsg.append("维保人1不存在，");
                }
            } else {
                maintainer1false = true;
            }

            if (!StringUtils.isBlank(deviceUser.getMaintainerNo2())) {
                if (userIndexCodeInDB.contains(deviceUser.getMaintainerNo2())) {
                } else {
                    errorMsg.append("维保人2不存在，");
                }
            } else {
                maintainer2false = true;
            }

            if (!StringUtils.isBlank(deviceUser.getMaintainerNo3())) {
                if (userIndexCodeInDB.contains(deviceUser.getMaintainerNo2())) {
                } else {
                    errorMsg.append("维保人3不存在，");
                }
            } else {
                maintainer3false = true;
            }

        }

        if (teacher1false && teacher2false) {
            // 两个运维老师都不存在
            errorMsg.append("运维老师1，运维老师2均为空");
            return errorMsg.toString();
        }

        if (maintainer1false && maintainer2false && maintainer3false) {
            // 三个维保人员
            errorMsg.append("维保人1，维保人2，维保人3均为空");
            return errorMsg.toString();
        }

        if (!StringUtils.isBlank(errorMsg.toString())) {
            return removeDH(errorMsg.toString());
        }

        return errorMsg.toString();
    }

    public static String removeDH(String s) {
        //若最后一个字符为逗号，则通过substring截取需要的值
        if (s.charAt(s.length() - 1) == ',') {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }


    /*private static File createExcelByPojo(String filePath, String fileName, boolean append, List<?> pojos, Class<?> pojoClass, List<ExcelPojoParseErrorResult> pojoParseErrorResults, ExcelHeaderType... excelHeaderType) {

        return createExcel(filePath, fileName, append, fieldCsvHeaders.toArray(new String[0]), pojo2StringArrayWithCsvSort(pojos, pojoClass, pojoParseErrorResults, excelHeaderType));
    }*/

    private static List<String[]> pojo2StringArrayWithExcelort(List<?> pojos, Class<?> pojoClass, ExcelHeaderType... excelHeaderType) {

        //TODO 暂存
        Map<String, Field> fieldMap = getFieldMapByClassExcelHeaders(pojoClass, excelHeaderType);
        List<String> sortHeaders = getAndSortExcelHeaderValueList(pojoClass, new HashMap<>(), excelHeaderType);
        List<String[]> valueArrayList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(pojos)) {
            for (Object pojo : pojos) {
                List<String> values = new ArrayList<>();
                for (String sortHeader : sortHeaders) {
                    try {
                        //TODO 暂存
                        Object value = fieldMap.get(sortHeader).get(pojo);
                        values.add(value == null ? "" : value.toString());
                    } catch (IllegalAccessException e) {
                        System.out.println("[Excel] field get error");
                    }
                }
                valueArrayList.add(values.toArray(new String[values.size()]));
            }
        }
        return valueArrayList;
    }

    private static Map<String, Field> getFieldMapByClassExcelHeaders(Class<?> pojoClass, ExcelHeaderType... excelHeaderType) {
        Map<String, Field> fieldMap = new HashMap<>();
        Field[] fields = pojoClass.getDeclaredFields();
        for (Field field : fields) {
            ExcelHeader excelHeader = field.getAnnotation(ExcelHeader.class);
            if (excelHeader != null && !Collections.disjoint(Arrays.asList(excelHeader.type()), Arrays.asList(excelHeaderType))) {
                field.setAccessible(true);
                fieldMap.put(excelHeader.value(), field);
            }
        }
        if (pojoClass.getSuperclass() != null) {
            fieldMap.putAll(getFieldMapByClassExcelHeaders(pojoClass.getSuperclass(), excelHeaderType));
        }
        return fieldMap;
    }

    private static List<String> getAndSortExcelHeaderValueList(Class<?> pojoClass, Map<String, Integer> orderMap, ExcelHeaderType... excelHeaderType) {
        Set<String> fieldSet = new HashSet<>();
        Field[] fields = pojoClass.getDeclaredFields();
        for (Field field : fields) {
            ExcelHeader excelHeader = field.getAnnotation(ExcelHeader.class);
            if (excelHeader != null && !Collections.disjoint(Arrays.asList(excelHeader.type()), Arrays.asList(excelHeaderType))) {
                fieldSet.add(excelHeader.value());
                orderMap.put(excelHeader.value(), excelHeader.order());
            }
        }
        Class<?> superClass = pojoClass.getSuperclass();
        if (superClass != null) {
            fieldSet.addAll(getAndSortExcelHeaderValueList(superClass, orderMap, excelHeaderType));
        }
        return fieldSet.stream().sorted(Comparator.comparingInt(orderMap::get)).collect(Collectors.toList());
    }
}
