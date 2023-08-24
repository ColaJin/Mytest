package hikversion;

import java.io.*;
import java.util.*;

/**
 * @Auther: tengleilei
 * @Date: 2021/8/18 19 50
 * @Description:
 */
public class TlltestChannelUpdate {

    private static List<String> list1 = new ArrayList<>();

    private static List<String> list12 = new ArrayList<>();

    private static List<String> list13 = new ArrayList<>();

    private static List<String> list14 = new ArrayList<>();

    private static List<String> list2 = new ArrayList<>();

    private static List<String> list21 = new ArrayList<>();

    private static List<String> list22 = new ArrayList<>();

    private static List<String> list23 = new ArrayList<>();

    private static List<String> list3 = new ArrayList<>();

    private static List<String> listDev = new ArrayList<>();

    private static Map<String, String> mapDev = new HashMap<>();

    private static List<String> listXresDev = new ArrayList<>();


    private static Map<String, String> map2 = new HashMap<>();

    public static String readFileContent(String fileName, int i) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                //sbf.append(tempStr);
                String[] str = tempStr.split("\t");
                if (str.length == 1) {
                    str = tempStr.split(" ");
                    list3.add(String.format("%s-%s-%s", str[1], str[3], str[5]));
                    continue;
                }
                if (str.length != 3) {
                    System.out.println(tempStr);
                } else {
                    if (i == 0) {
                        list1.add(String.format("%s-%s-%s", str[0], str[1], str[2]));
                    } else if (i == 1) {
                        list2.add(String.format("%s-%s-%s", str[0], str[1], str[2]));
                        list21.add(str[0]);
                        list22.add(str[1]);
                    } else if (i == 2) {
                        list3.add(String.format("%s-%s-%s", str[1], str[2], str[3]));
                    }

                }
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }


    public static String readFileContent2(String fileName, int i) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                //sbf.append(tempStr);
                String[] str = tempStr.split(",");
                if (str.length != 3) {
                    if (str.length == 4) {
                        list3.add(String.format("%s-%s-%s", str[1], str[2], str[3]));
                        continue;
                    }
                    System.out.println(tempStr);
                } else {
                    if (i == 0) {
                        list1.add(String.format("%s-%s-%s", str[0], str[1], str[2]));
                    } else if (i == 1) {
                        list2.add(String.format("%s-%s-%s", str[0], str[1], str[2]));
                        list21.add(str[0]);
                        list22.add(str[1]);
                    } else if (i == 2) {
                        list3.add(String.format("%s-%s-%s", str[1], str[2], str[3]));
                    }
                }
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    /**
     * 读取tb_channel
     *
     * @param fileName
     * @param i
     * @return
     */
    public static String readFileContent3(String fileName, int i) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                //sbf.append(tempStr);
                String[] str = tempStr.split(",");

            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    public static String readFileContent4(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            int ii = 0;
            while ((tempStr = reader.readLine()) != null) {
                String[] str = tempStr.split(",");
                ii++;
                if (str.length == 71 || str.length == 70) {
                    listXresDev.add(tempStr);
                    //listXresDev.add(str[0]);
                    //list12.add(String.format("%s-%s-%s-%s-%s",str[0],str[25],str[4],str[5],str[38]));
                } else if (str.length >= 62) {
                    //resource device
                    //list2.add(String.format("%s-%s-%s-%s",str[2],str[15],str[16],str[17]));
                    mapDev.put(str[2], str[3]);
                    listDev.add(str[2]);
                } else {
                    int pp = 0;
                    pp++;
                }
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    private static void doChannel() {
        int ii = 0;
        int jj = 0;
        int kk = 0;
        int mm = 0;
        String content;
        int index = 0;
        try {
            FileWriter fileWriter = new FileWriter("D:\\排查\\20210818\\比对111\\updateChannel.csv");
            FileWriter fileWriter2 = new FileWriter("D:\\排查\\20210818\\比对111\\deleteChannelAndDev.csv");
            FileWriter fileWriter3 = new FileWriter("D:\\排查\\20210818\\比对111\\insertChannel.csv");
            FileWriter fileWriter4 = new FileWriter("D:\\排查\\20210818\\比对111\\deleteSameChannel.csv");
            FileWriter fileWriter5 = new FileWriter("D:\\排查\\20210818\\比对111\\sameChannel.csv");
            FileWriter fileWriter6 = new FileWriter("D:\\排查\\20210818\\比对111\\updateChannelByOne.csv");

            for (String s : list13) {
                String[] ss = s.split("-");
                //String str1 = list1.get(index);
                //if (!list2.contains(str1)){
                String str1 = list12.get(index);
                //根据 indecode-parentcode-channelno-channeltype-typecode
                if (!list22.contains(str1)) {
                    //xres和dac里面不一致  xres里面有 但是 dac没有
                    if (list21.contains(ss[1])) {
                        //在resource里面也存在这个通道编号  但是对应的通道其他信息不一样  筛选出来组成sql update语句
                        //判断这个通道所属的设备是否已经添加
                        String devId = ss[2].trim();//replace("\"","");
                        if (listDev.contains(devId)) {
                            ii++;
                            String str22 = String.format("%s-%s-%s-%s-0", ss[2], ss[3], ss[4], ss[5]);
                            if (list23.contains(str22)) {
                                mm++;
                                content = String.format("DELETE FROM public.resource_channel where c_parent_index_code='%s' and c_channel_no= '%s' and c_channel_type='%s' and c_device_type_code='%s' and i_status=0;\r\n",
                                        ss[2].replace("\"", ""), ss[3].replace("\"", ""),
                                        ss[4].replace("\"", ""), ss[5].replace("\"", ""));
                                fileWriter4.append(content);
                                System.out.println("存在一样的通道信息, 进行删除对应通道" + mm + "   " + ss[1].replace("\"", "") + "  " + str22);
                            }

                            int count = Collections.frequency(list14, str22);
                            if (count > 1) {
                                content = String.format("更新[xres存在多个]c_index_code = %s  %s;\r\n", ss[1], str22);
                                fileWriter5.append(content);
                            } else {
                                //只有一个
                                //设备编号存在  进行通道号更新
                                content = String.format("UPDATE public.resource_channel set c_parent_index_code='%s',c_top_parent_index_code='%s', c_channel_no= '%s',c_channel_type='%s',c_device_type_code='%s',i_status=0 where c_index_code = '%s';\r\n",
                                        ss[2].replace("\"", ""), ss[2].replace("\"", ""), ss[3].replace("\"", ""),
                                        ss[4].replace("\"", ""), ss[5].replace("\"", ""), ss[1].replace("\"", ""));
                                fileWriter6.append(content);
                            }

                            //设备编号存在  进行通道号更新
                            content = String.format("UPDATE public.resource_channel set c_parent_index_code='%s',c_top_parent_index_code='%s', c_channel_no= '%s',c_channel_type='%s',c_device_type_code='%s',i_status=0 where c_index_code = '%s';\r\n",
                                    ss[2].replace("\"", ""), ss[2].replace("\"", ""), ss[3].replace("\"", ""),
                                    ss[4].replace("\"", ""), ss[5].replace("\"", ""), ss[1].replace("\"", ""));
                            fileWriter.append(content);

                            System.out.println("通道需要更新:  " + ii + "   " + s);
                        } else {
                            //设备不存在  删除通道信息 和 删除该设备信息
                            //删除通道
                            jj++;
                            content = String.format("DELETE FROM public.resource_channel WHERE c_index_code='%s';\r\n", ss[1].replace("\"", ""));
                            fileWriter2.append(content);
                            //删除原设备  需要注意
                            String oldDev = map2.get(ss[1]).replace("\"", "");
                            content = String.format("DELETE FROM public.resource_device WHERE c_index_code='%s';\r\n", oldDev);
                            fileWriter2.append(content);
                            System.out.println("需要删除: " + jj + "  " + s);
                        }
                    } else {
                        //xres有这个通道号  但是 dac里面没有
                        if (listDev.contains(ss[2].trim())) {
                            //但是这个通道所属的设备存在  这种情况则进行insert 通道操作

                            String str22 = String.format("%s-%s-%s-%s-0", ss[2], ss[3], ss[4], ss[5]);
                            int count = Collections.frequency(list14, str22);
                            if (count > 1) {
                                content = String.format("插入[xres存在多个]c_index_code = %s  %s;\r\n", ss[1], str22);
                                fileWriter5.append(content);
                            } else {
                                //int count2 = Collections.frequency(list23, str22);
                                //if (count2)
                                if (list23.contains(str22)) {
                                    //在dac中 唯一约束存在
                                    //System.out.println(" 存在dac唯一约束  " + str22);
                                    content = String.format("插入[dac存在多个]c_index_code = %s  %s;\r\n", ss[1], str22);
                                    fileWriter5.append(content);
                                } else {
                                    kk++;
                                    //处理经纬度问题
                                    if (ss[6].equals("\"\"") || ss[7].equals("\"\"")) {
                                        ss[6] = "120";
                                        ss[7] = "22";
                                    }
                                    if (ss[6].length() >= 10 || ss[7].length() >= 10) {

                                        int i2 = ss[7].indexOf(".");
                                        if (i2 > 3) {
                                            System.out.println(ss[6] + "  " + ss[7]);
                                            ss[7] = ss[7].substring(1, ss[7].length());
                                        }
                                        i2 = ss[7].indexOf(".");
                                        if (i2 > 4) {
                                            ss[6] = ss[6].substring(1, ss[6].length());
                                        }

                                        ss[6] = ss[6].substring(0, 9);
                                        ss[7] = ss[7].substring(0, 9);
                                    }

                                    content = String.format("INSERT INTO public.resource_channel" +
                                                    "(c_index_code, c_name, c_org_index_code, c_device_type_code, d_create_time, d_update_time, i_status, i_data_version, i_belongsub, i_transtype, c_top_parent_index_code, c_parent_index_code, c_channel_type, c_channel_no, " +
                                                    "c_extend_json, i_extend_1, i_extend_2, c_extend_3, c_extend_4, i_latitude_degree, i_latitude_minute, i_latitude_second, i_longtitude_degree, i_longtitude_minute, i_longtitude_second, i_altitude, c_safe_watch_key, i_alarm_low, i_alarm_high, i_measure_low, i_measure_high, i_sensitive)" +
                                                    "VALUES('%s', '%s', '000000', '%s', '2021/8/19 10:01:43','2021/8/19 10:46:01', 0, 445539, 0, 1, '%s', '%s', '%s', '%s', '{\"longtitudeDegree\":%s,\"cameraChanNo\":\"%s\"}', 0, 0, '', '', %s, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0);\r\n",
                                            ss[1].replace("\"", ""), ss[0].replace("\"", ""), ss[5].replace("\"", ""),
                                            ss[2].replace("\"", ""), ss[2].replace("\"", ""), ss[4].replace("\"", ""),
                                            ss[3].replace("\"", ""), ss[6].replace("\"", ""), ss[3].replace("\"", ""), ss[7].replace("\"", ""));

                                    fileWriter3.append(content);
                                    System.out.println("需要插入: " + kk + "  " + s);
                                }
                            }
//                            content = String.format("INSERT INTO public.resource_channel" +
//                                            "(c_index_code, c_name, c_org_index_code, c_device_type_code, d_create_time, d_update_time, i_status, i_data_version, i_belongsub, i_transtype, c_top_parent_index_code, c_parent_index_code, c_channel_type, c_channel_no, " +
//                                            "c_extend_json, i_extend_1, i_extend_2, c_extend_3, c_extend_4, i_latitude_degree, i_latitude_minute, i_latitude_second, i_longtitude_degree, i_longtitude_minute, i_longtitude_second, i_altitude, c_safe_watch_key, i_alarm_low, i_alarm_high, i_measure_low, i_measure_high, i_sensitive)" +
//                                            "VALUES('%s', '%s', '000000', '%s', '2021/8/19 10:01:43','2021/8/19 10:46:01', 0, 445539, 0, 1, '%s', '%s', '%s', '%s', '{\"longtitudeDegree\":%s,\"cameraChanNo\":\"%s\"}', 0, 0, '', '', %s, 0, 0, 0, 0, 0, 0, '', 0, 0, 0, 0, 0);\r\n",
//                                    ss[1].replace("\"",""),ss[0].replace("\"",""),ss[5].replace("\"",""),
//                                    ss[2].replace("\"",""),ss[2].replace("\"",""),ss[4].replace("\"",""),
//                                    ss[3].replace("\"",""),ss[6].replace("\"",""),ss[3].replace("\"",""),ss[7].replace("\"",""));
//
//                            fileWriter3.append(content);
//                            System.out.println("需要插入: " + kk  +"  " + s);
                        }
                    }
                } else {
                    //System.out.println("=======存在： " + str1);
                }
                index++;
            }
            fileWriter.flush();
            fileWriter2.flush();
            fileWriter3.flush();
            fileWriter4.flush();
            fileWriter5.flush();
            fileWriter6.flush();

            fileWriter.close();
            fileWriter2.close();
            fileWriter3.close();
            fileWriter4.close();
            fileWriter5.close();
            fileWriter6.close();
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {

        }
    }

    private static void doDevice() {
        int ii = 0;
        int jj = 0;
        int kk = 0;
        String content;
        int index = 0;
        try {
            FileWriter fileWriter = new FileWriter("D:\\排查\\20210818\\比对111\\device_xres有dac无.csv");
            for (String s : listXresDev) {
                String[] s2 = s.split(",");
                if (!listDev.contains(s2[0])) {
                    ii++;
                    //xres 存在  dac不存在 的设备
                    content = String.format("%s,%s,%s,%s\r\n", s2[0], s2[1], s2[3], s2[4]);
                    fileWriter.append(content);
                    System.out.println("doDevice 不存在" + ii + "  " + content);
                }
            }

            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }


        //判断xres和dac上的设备 当das不一致时, 将dac所属的至为空
        try {
            FileWriter fileWriter = new FileWriter("D:\\排查\\20210818\\比对111\\device_setdacbelongnull.csv");
            for (String s : listXresDev) {
                String[] s2 = s.split(",");
                if (listDev.contains(s2[0])) {
                    //xres 存在  dac存在
                    String xresDas = s2[16].trim();
                    String dacDas = mapDev.get(s2[0]).trim();
                    if (!xresDas.equals(dacDas)) {
                        //两个的das不一致
                        ii++;
                        content = String.format("UPDATE public.resource_device SET c_belong_index_code='' WHERE c_index_code='%s';\r\n", s2[0].replace("\"", ""));
                        fileWriter.append(content);
                        System.out.println("doDevice das不一致 " + ii + "  " + content);
                    }
                    //content = String.format("%s,%s,%s,%s\r\n", s2[0], s2[1], s2[3], s2[4]);
                }
            }

            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }


    }

    /**
     * 读取文件
     *
     * @param fileName
     * @return
     */
    public static String readFileIndexCodes(String fileName) {
        String parentIndexCodes = "03f2c5230af74f659e7d24891eec7394,4686305107be4510b2c50857f51d4c65,c3b3da1d743b41fda9f6907e821f4c83,394c63ed97114dd98ae4ddaa8c09a438,4edd4ee1b84041cebd5b6a82670841f8,4686305107be4510b2c50857f51d4c65,4edd4ee1b84041cebd5b6a82670841f8,8e959b3f98ea40608a8633d55076e7f5,826d704e62054d37b848c749cd9f7968,fd5724f61a36423388968c216ce3750d,4d17ed1636d64ff69a52b85f4f0439ba,03f2c5230af74f659e7d24891eec7394,3dad2193acc6414a9bb4ea0faa0e6c87,395374fd7d4847fd9a6602614ffdb1b3,fd5724f61a36423388968c216ce3750d,4b6104c1f73c40d08a29325a6f76ddf6,8e959b3f98ea40608a8633d55076e7f5,4686305107be4510b2c50857f51d4c65,395374fd7d4847fd9a6602614ffdb1b3,4edd4ee1b84041cebd5b6a82670841f8,8e959b3f98ea40608a8633d55076e7f5,03f2c5230af74f659e7d24891eec7394,4b6104c1f73c40d08a29325a6f76ddf6,4d17ed1636d64ff69a52b85f4f0439ba,4d17ed1636d64ff69a52b85f4f0439ba,826d704e62054d37b848c749cd9f7968,c3b3da1d743b41fda9f6907e821f4c83,c3b3da1d743b41fda9f6907e821f4c83,98dc737574ff432e8189ad0c051d6aa4,395374fd7d4847fd9a6602614ffdb1b3,3dad2193acc6414a9bb4ea0faa0e6c87,3dad2193acc6414a9bb4ea0faa0e6c87,395374fd7d4847fd9a6602614ffdb1b3,fd5724f61a36423388968c216ce3750d,826d704e62054d37b848c749cd9f7968,4d17ed1636d64ff69a52b85f4f0439ba,03f2c5230af74f659e7d24891eec7394,98dc737574ff432e8189ad0c051d6aa4,4686305107be4510b2c50857f51d4c65,4b6104c1f73c40d08a29325a6f76ddf6,98dc737574ff432e8189ad0c051d6aa4,826d704e62054d37b848c749cd9f7968,3dad2193acc6414a9bb4ea0faa0e6c87,fd5724f61a36423388968c216ce3750d,4edd4ee1b84041cebd5b6a82670841f8,8e959b3f98ea40608a8633d55076e7f5,4b6104c1f73c40d08a29325a6f76ddf6,98dc737574ff432e8189ad0c051d6aa4,c3b3da1d743b41fda9f6907e821f4c83";
        String[] strAry = parentIndexCodes.split(",");
        List<String> deviceIndexCodes = Arrays.asList(strAry);
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {


            int ii = 0;
            // 每一行遍历需要找到所有的通道信息然后比对删除
            for (String indexcodes : deviceIndexCodes) {
                List<String> channels = new ArrayList<>();
                // 每次都要重头读取一遍
                reader = new BufferedReader(new FileReader(file));
                String tempStr;
                while ((tempStr = reader.readLine()) != null) {
                    String[] str = tempStr.split(",");
                    if (indexcodes.equals(str[12])) {
                        // 此时找出当前设备下的所有通道信息
                        channels.add(tempStr);
                    }
                }
                // 通道信息更新相同名称的通道的c_index_code、i_data_version、i_status

            }

            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    /**
     * 读取文件，查看数据是否存在重复数据,去掉第一行和存在对象的数据列(对象的数据列会导致数据根据，分割产生列不一致的问题)
     * 去掉存在的,影响列判断
     *
     * @param fileName
     * @return
     */
    public static String readFileFindDuplicated(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        // 用来记录唯一性
        Map<String, String> dupliatedChannels = new HashMap();
        List<String> channels = new ArrayList<>();
        // 用来记录存在相同数据的channel信息
        Map<String, List<String>> map = new HashMap();
        try {

            // 根据唯一性字段确认是否存在数据，输出原和新的通道信息
            // 遍历每行数据是存储c_parent_inde_code,c_device_type_code,i_status,c_channel_no,c_channel_type
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                StringBuffer sb = new StringBuffer();
                String[] str = tempStr.split(",");
                String i_status = str[3].replace("\"", "");
                int status = Integer.parseInt(i_status);
                // 只需要判断有效的数据即status >= 0
                if (status >= 0) {
                    // 需要去掉双引号
                    String c_parent_inde_code = str[11].replace("\"", "");
                    String c_device_type_code = str[21].replace("\"", "");
                    String c_name = str[1].replace("\"", "");
                    // 不能加上通道编号(唯一的)
                    // String c_channel_no = str[2].replace("\"", "");
                    String c_channel_type = str[5].replace("\"", "");
                    sb.append(c_parent_inde_code)
                            .append(c_device_type_code)
                            .append(i_status)
                            .append(c_name)
                            // .append(c_channel_no)
                            .append(c_channel_type);
                    /*if (channels.contains(sb.toString())) {
                        List<String> temp = map.get(sb.toString());
                        if (temp == null) {
                            // 防止空指针异常
                            temp = new ArrayList<>();
                        }
                        // 通道编号加入进去
                        temp.add(str[2].replace("\"", ""));
                        map.put(sb.toString(), temp);
                    } else {
                        channels.add(sb.toString());
                    }*/
                    if (dupliatedChannels.containsKey(sb.toString())) {
                        List<String> temp = map.get(sb.toString());
                        if (temp == null) {
                            // 防止空指针异常
                            temp = new ArrayList<>();
                        }
                        // 通道编号加入进去
                        temp.add(str[2].replace("\"", ""));
                        temp.add(dupliatedChannels.get(sb.toString()));
                        map.put(sb.toString(), temp);
                    } else {
                        // 需要带着通道编号存储然后比较之后存储，输出
                        dupliatedChannels.put(sb.toString(), str[2].replace("\"", ""));
                    }
                }

            }

            if (map.size() > 0) {
                for (String s : map.keySet()) {
                    System.out.println(map.get(s).toString());
                }
            }

            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    public static List<Map<String,String>> getResourceChannels(String fileName) {
        // 读取ResourceChannels的唯一的通道信息
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        // 用来记录唯一性
        List<Map<String, String>> onlyChannels = new ArrayList<>();
        try {

            // 根据唯一性字段确认是否存在数据，输出原和新的通道信息
            // 遍历每行数据是存储c_parent_inde_code,c_device_type_code,i_status,c_channel_no,c_channel_type
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                StringBuffer sb = new StringBuffer();
                String[] str = tempStr.split(",");
                String i_status = str[7].replace("\"", "");
                int status = Integer.parseInt(i_status);
                // 只需要判断有效的数据即status >= 0
                if (status >= 0) {
                    // 需要去掉双引号
                    String c_parent_inde_code = str[12].replace("\"", "");
                    String c_device_type_code = str[4].replace("\"", "");
                    // 不能加上通道编号(唯一的)
                    // 通道号
                    // String c_index_code = str[2].replace("\"", "");
                    String c_channel_no = str[14].replace("\"", "");
                    String c_channel_type = str[13].replace("\"", "");
                    sb.append(c_parent_inde_code)
                            .append(c_device_type_code)
                            .append(i_status)
                            .append(c_channel_no)
                            .append(c_channel_type);
                    Map<String,String> map = new HashMap<>();
                    map.put(sb.toString(),str[1].replace("\"", ""));
                    onlyChannels.add(map);
                }

            }

            reader.close();
            return onlyChannels;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return onlyChannels;
    }

    public static List<Map<String,String>> getTbChannels(String fileName) {
        // 读取ResourceChannels的唯一的通道信息
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        // 用来记录唯一性
        List<Map<String, String>> onlyChannels = new ArrayList<>();
        try {

            // 根据唯一性字段确认是否存在数据，输出原和新的通道信息
            // 遍历每行数据是存储c_parent_inde_code,c_device_type_code,i_status,c_channel_no,c_channel_type
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                StringBuffer sb = new StringBuffer();
                String[] str = tempStr.split(",");
                String i_status = str[3].replace("\"", "");
                int status = Integer.parseInt(i_status);
                // 只需要判断有效的数据即status >= 0
                if (status >= 0) {
                    // 需要去掉双引号
                    String c_parent_inde_code = str[11].replace("\"", "");
                    String c_device_type_code = str[21].replace("\"", "");
                    // String c_name = str[1].replace("\"", "");
                    // 不能加上通道编号(唯一的)
                    String c_channel_no = str[4].replace("\"", "");
                    String c_channel_type = str[5].replace("\"", "");
                    sb.append(c_parent_inde_code)
                            .append(c_device_type_code)
                            .append(i_status)
                            // .append(c_name)
                            .append(c_channel_no)
                            .append(c_channel_type);
                    Map<String,String> map = new HashMap<>();
                    map.put(sb.toString(),str[2].replace("\"", ""));
                    onlyChannels.add(map);
                }

            }

            reader.close();
            return onlyChannels;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return onlyChannels;
    }



    /**
     * 读取两个文件的结果，对比问题
     *
     * @param fileName
     * @return
     */
    public static String readFileBoth(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        // 用来记录唯一性
        Map<String, String> dupliatedChannels = new HashMap();
        List<String> channels = new ArrayList<>();
        // 用来记录存在相同数据的channel信息
        Map<String, List<String>> map = new HashMap();
        try {

            // 根据唯一性字段确认是否存在数据，输出原和新的通道信息
            // 遍历每行数据是存储c_parent_inde_code,c_device_type_code,i_status,c_channel_no,c_channel_type
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                StringBuffer sb = new StringBuffer();
                String[] str = tempStr.split(",");
                String i_status = str[3].replace("\"", "");
                int status = Integer.parseInt(i_status);
                // 只需要判断有效的数据即status >= 0
                if (status >= 0) {
                    // 需要去掉双引号
                    String c_parent_inde_code = str[11].replace("\"", "");
                    String c_device_type_code = str[21].replace("\"", "");
                    String c_name = str[1].replace("\"", "");
                    // 不能加上通道编号(唯一的)
                    // String c_channel_no = str[2].replace("\"", "");
                    String c_channel_type = str[5].replace("\"", "");
                    sb.append(c_parent_inde_code)
                            .append(c_device_type_code)
                            .append(i_status)
                            .append(c_name)
                            // .append(c_channel_no)
                            .append(c_channel_type);
                    /*if (channels.contains(sb.toString())) {
                        List<String> temp = map.get(sb.toString());
                        if (temp == null) {
                            // 防止空指针异常
                            temp = new ArrayList<>();
                        }
                        // 通道编号加入进去
                        temp.add(str[2].replace("\"", ""));
                        map.put(sb.toString(), temp);
                    } else {
                        channels.add(sb.toString());
                    }*/
                    if (dupliatedChannels.containsKey(sb.toString())) {
                        List<String> temp = map.get(sb.toString());
                        if (temp == null) {
                            // 防止空指针异常
                            temp = new ArrayList<>();
                        }
                        // 通道编号加入进去
                        temp.add(str[2].replace("\"", ""));
                        temp.add(dupliatedChannels.get(sb.toString()));
                        map.put(sb.toString(), temp);
                    } else {
                        // 需要带着通道编号存储然后比较之后存储，输出
                        dupliatedChannels.put(sb.toString(), str[2].replace("\"", ""));
                    }
                }

            }

            if (map.size() > 0) {
                for (String s : map.keySet()) {
                    System.out.println(map.get(s).toString());
                }
            }

            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }


    public static void main(String[] args) {
        // readFileIndexCodes("d://text.file");
        // readFileFindDuplicated("E:\\hikvision\\物联网接入项目\\问题\\210826\\tb_channel_new.csv");
        List<Map<String, String>> resourceChannels = getResourceChannels("E:\\hikvision\\物联网接入项目\\问题\\210826\\resource_channel_new.csv");
        // System.out.println(resourceChannels.toString());
        List<Map<String, String>> tbChannels = getTbChannels("E:\\hikvision\\物联网接入项目\\问题\\210826\\tb_channel_new.csv");
        // System.out.println(resourceChannels.toString());

        // 遍历tbchannels更新resourcechannels数据
        for (Map<String, String> tbChannel : tbChannels) {
            for (Map<String, String> resourceChannel : resourceChannels) {
                for (String tb : tbChannel.keySet()) {
                    for (String rs : resourceChannel.keySet()) {
                        if (tb.equals(rs)) {
                            if (!tbChannel.get(tb).equals(resourceChannel.get(rs))) {
                                // 结果未去重，重复的数据不需要修改
                                System.out.println("update public.resource_channel set c_index_code = '" + tbChannel.get(tb) +"' where c_index_code = '" +resourceChannel.get(rs) +"'");
                            }
                        }
                    }
                }

            }
        }
    }

}
