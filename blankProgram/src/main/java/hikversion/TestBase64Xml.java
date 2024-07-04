package hikversion;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author:jinyandong
 * @description:测试base64处理数据
 * @Date:2023/10/24
 */
public class TestBase64Xml {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*String str = "我要测试Base64";
        // byte[] decode = Base64.getDecoder().decode(str);

        byte[] encode = Base64.getEncoder().encode(str.getBytes());
        String temp = new String(encode);
        System.out.println(temp);
        byte[] decode = Base64.getDecoder().decode(temp);
        System.out.println(new String(decode));*/
        /*String orgin = "安全高于一切 责任重于泰山";
        String fileDetail = Base64.getEncoder().encodeToString(orgin.getBytes("GBK"));*/
        // String str = "W3BsYXlsaXN0XQppdGVtX25vPTMKaXRlbTA9MzAwLDEsMSxcQzAwMDAwMFxmczMyMzJcYzAwMDAwMDAwMDI1NVxTMDBcYjAwMDAwMDAwMDAwMMm9uqPT0MfpXEMwMDAwMzJcZnMzMjMyXGMwMDAwMDAwMDAyNTVcUzAwXGIwMDAwMDAwMDAwMDDM7MHJtdjE/gppdGVtMT0zMDAsMSwxLFxDMDAwMDAwXGZzMzIzMlxjMDAwMDAwMDAwMjU1XFMwMFxiMDAwMDAwMDAwMDAw0/bT0MqpuaRcQzAwMDAzMlxmczMyMzJcYzAwMDAwMDAwMDI1NVxTMDBcYjAwMDAwMDAwMDAwMNei0uKx3MjDCml0ZW0yPTMwMCwxLDEsXEMwMDAwMDBcZnMzMjMyXGMwMDAwMDAwMDAyNTVcUzAwXGIwMDAwMDAwMDAwMDDAptT6wM65zFxDMDAwMDMyXGZzMzIzMlxjMDAwMDAwMDAwMjU1XFMwMFxiMDAwMDAwMDAwMDAw0c+9+9LFyPYK";
        String fileInfo = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4NCjxjb25maWd1cmU+DQogIDxjbXM+DQogICAgPEFkZHI+MDwvQWRkcj4NCiAgICA8SW1hZ2VUeXBlPjA8L0ltYWdlVHlwZT4NCiAgICA8V2lkdGg+NDg8L1dpZHRoPg0KICAgIDxVbml0SGVpZ2h0PjQ4PC9Vbml0SGVpZ2h0Pg0KICAgIDxIZWlnaHQ+OTY8L0hlaWdodD4NCiAgICA8VW5pdE51bT44PC9Vbml0TnVtPg0KICAgIDxMRURXaWR0aD4xOTI8L0xFRFdpZHRoPg0KICAgIDxEcml2ZXJDb3VudD40PC9Ecml2ZXJDb3VudD4NCiAgICA8TG9nTW9kZT4wPC9Mb2dNb2RlPg0KICA8L2Ntcz4NCiAgPG5ldHdvcms+DQogICAgPFNlcmlhbEZsYWc+MTwvU2VyaWFsRmxhZz4NCiAgICA8QmF1ZF9SYXRlPjk2MDA8L0JhdWRfUmF0ZT4NCiAgICA8RGF0YV9CaXRzPjg8L0RhdGFfQml0cz4NCiAgICA8UGFyaXR5PjA8L1Bhcml0eT4NCiAgICA8U3RvcF9iaXRzPjE8L1N0b3BfYml0cz4NCiAgICA8SXBGbGFnPjIzPC9JcEZsYWc+DQogICAgPElwTmFtZT5ldGgwPC9JcE5hbWU+DQogICAgPElwQWRkcj4xOTIuMTY4LjEuMTAwPC9JcEFkZHI+DQogICAgPElwR2F0ZVdheT4xOTIuMTY4LjEuMTwvSXBHYXRlV2F5Pg0KICAgIDxJcE5ldE1hc2s+MjU1LjI1NS4yNTUuMDwvSXBOZXRNYXNrPg0KICAgIDxJcFBvcnQ+NTAwOTwvSXBQb3J0Pg0KICAgIDxJcE5hbWUxPmV0aDE8L0lwTmFtZTE+DQogICAgPElwQWRkcjE+MTAuNjIuNy40MDwvSXBBZGRyMT4NCiAgICA8SXBHYXRlV2F5MT4xMC42Mi43LjEwPC9JcEdhdGVXYXkxPg0KICAgIDxJcE5ldE1hc2sxPjI1NS4yNTUuMjU1LjA8L0lwTmV0TWFzazE+DQogICAgPElwUG9ydDE+NTAwOTwvSXBQb3J0MT4NCiAgICA8TmV0UmVzdGFydFRpbWU+MjA8L05ldFJlc3RhcnRUaW1lPg0KICAgIDxCbGFja1RpbWU+MDwvQmxhY2tUaW1lPg0KICA8L25ldHdvcms+DQogIDxpbnRlcmZhY2U+DQogICAgPElzU2tpcD4wPC9Jc1NraXA+DQogICAgPElzRGlzVUk+MTwvSXNEaXNVST4NCiAgPC9pbnRlcmZhY2U+DQogIDxkaXNwbGF5RGV2aWNlPg0KICAgIDxSZWRSYXRlPjI1NTwvUmVkUmF0ZT4NCiAgICA8R3JlZW5SYXRlPjI1NTwvR3JlZW5SYXRlPg0KICAgIDxCbHVlUmF0ZT4yNTU8L0JsdWVSYXRlPg0KICAgIDxZZWxsb3dSYXRlPjI1NTwvWWVsbG93UmF0ZT4NCiAgICA8SXNVc2VDb2xvcj4wPC9Jc1VzZUNvbG9yPg0KICAgIDxJc0Nsb3NlU2NyQnJpZ2h0PjA8L0lzQ2xvc2VTY3JCcmlnaHQ+DQogICAgPEZvbGlvV2lkdGg+MDwvRm9saW9XaWR0aD4NCiAgICA8Rm9saW9IZWlnaHQ+MDwvRm9saW9IZWlnaHQ+DQogICAgPEZ1bGxDb2xvclVuaXRXaWR0aD4zMjwvRnVsbENvbG9yVW5pdFdpZHRoPg0KICAgIDxDdXJQbGF5TGlzdD5wbGF5MDEubHN0PC9DdXJQbGF5TGlzdD4NCiAgICA8RFg+MTwvRFg+DQogICAgPERZPjEyMTwvRFk+DQogICAgPENvbG9yVHlwZT4xMTEsMTExLDExMSwxMTEsMTExLDExMSwxMTEsMTExLDExMSwxMTEsMTExLDExMSwxMTEsMTExLDExMSwxMTEsMTExLDExMTwvQ29sb3JUeXBlPg0KICA8L2Rpc3BsYXlEZXZpY2U+DQogIDxtb25pdG9yPg0KICAgIDxTZWxUaW1lSG91cj4yMzwvU2VsVGltZUhvdXI+DQogICAgPFNlbFRpbWVNaW51dGU+NTk8L1NlbFRpbWVNaW51dGU+DQogICAgPFNlbE5vPjE8L1NlbE5vPg0KICAgIDxTYW1wbGVUaW1lPjEwPC9TYW1wbGVUaW1lPg0KICA8L21vbml0b3I+DQogIDxjb250cm9sPg0KICAgIDxUZW1wTG93PjMwPC9UZW1wTG93Pg0KICAgIDxUZW1wSGlnaHQ+MzA8L1RlbXBIaWdodD4NCiAgICA8VGVtcENsb3NlU2NyZWVuPjYwPC9UZW1wQ2xvc2VTY3JlZW4+DQogICAgPFRlbXBDbG9zZUZhbj4yMDwvVGVtcENsb3NlRmFuPg0KICAgIDxUZW1wT3BlblNjcmVlbj4zMDwvVGVtcE9wZW5TY3JlZW4+DQogICAgPFRlbXBPcGVuRmFuPjMwPC9UZW1wT3BlbkZhbj4NCiAgICA8UmVkQnJpZ2h0PjI1NTwvUmVkQnJpZ2h0Pg0KICAgIDxHcmVlbkJyaWdodD4yNTU8L0dyZWVuQnJpZ2h0Pg0KICAgIDxCbHVlQnJpZ2h0PjI1NTwvQmx1ZUJyaWdodD4NCiAgICA8YmFkTnVtPjA8L2JhZE51bT4NCiAgICA8Q29udHJvbFRpbWU+MjA8L0NvbnRyb2xUaW1lPg0KICAgIDxJZGxlVGltZT4wPC9JZGxlVGltZT4NCiAgICA8SXNBdXRvVGVtcD4wPC9Jc0F1dG9UZW1wPg0KICAgIDxQaXhlbFBlcmNlbnQ+MDwvUGl4ZWxQZXJjZW50Pg0KICAgIDxNc2dQaXhlbFBlcmNlbnQ+NTA8L01zZ1BpeGVsUGVyY2VudD4NCiAgICA8VGltZU91dFRpbWU+MjA8L1RpbWVPdXRUaW1lPg0KICAgIDxwb3dlck1vZGU+MDwvcG93ZXJNb2RlPg0KICAgIDxmYW5Nb2RlPjA8L2Zhbk1vZGU+DQogIDwvY29udHJvbD4NCiAgPENsaWVudFNldD4NCiAgICA8SXNEb21lc3RpYz50cnVlPC9Jc0RvbWVzdGljPg0KICAgIDxOZWVkQ2hhbmdlQ29sb3I+dHJ1ZTwvTmVlZENoYW5nZUNvbG9yPg0KICA8L0NsaWVudFNldD4NCiAgPENvbG9ycz4NCiAgICA8Y29sb3IgY29sb3IxPSIjMDBmZjAwIiBjb2xvcjI9IiMwMGZmMDAiIC8+DQogIDwvQ29sb3JzPg0KPC9jb25maWd1cmU+DQo=";
        //String sss = new String(str.getBytes(),"GBK");
        byte[] decode = Base64.getDecoder().decode(fileInfo);
        String temp = new String(decode, "GBK");
        System.out.println(temp);

        /*// 测试处理字节流转换成播放列表实体类
        int item_no = temp.indexOf("ITEM000");
        String itemInfoStr = temp.substring(item_no);

        String[] itemStr = itemInfoStr.split("ITEM*");
        List<ItemInfo> itemInfoList = new ArrayList<>();
        for (String itemTemp : itemStr) {
            ItemInfo itemInfo = new ItemInfo();
            // 每个是一条动作
            if (StringUtils.isEmpty(itemTemp)) {
                continue;
            }
            String stayTimeStr = itemTemp.substring(itemTemp.indexOf("=") + 1);
            int stayTimeIndex = stayTimeStr.indexOf(",");
            // 处理停留时间
            String stayTimeSub = stayTimeStr.substring(0, stayTimeIndex);
            itemInfo.setStayTime(Integer.valueOf(stayTimeSub.replaceFirst("^0*", "")));

            String enterTypeStr = stayTimeStr.substring(stayTimeIndex + 1);
            int enterTypeIndex = enterTypeStr.indexOf(",");
            // 处理入屏
            String enterTypeSub = enterTypeStr.substring(0, enterTypeIndex);
            itemInfo.setEnterType(enterTypeSub);


            String stayTypeStr = enterTypeStr.substring(enterTypeIndex + 1);
            int stayTypeIndex = stayTypeStr.indexOf(",");


            String outTypeStr = stayTypeStr.substring(stayTypeIndex + 1);
            int outTypeIndex = outTypeStr.indexOf(",");
            // 处理出屏
            String outTypeSub = outTypeStr.substring(0, outTypeIndex);
            itemInfo.setOutType(outTypeSub);


            String speedStr = outTypeStr.substring(outTypeIndex + 1);
            int speedIndex = speedStr.indexOf(",");
            // 处理停留时间
            String speedSub = outTypeStr.substring(0, speedIndex);
            itemInfo.setSpeed(Integer.valueOf(speedSub));

            String textInfo = speedStr.substring(speedIndex+1);

            List<Content> contents = new ArrayList<>();
            List<PicInfo> picInfos = new ArrayList<>();
            String[] textInfoArr = textInfo.split("\\\\C");
            for (String s : textInfoArr) {
                if (StringUtils.equals("", s)) {
                    continue;
                }
                Integer start = Integer.valueOf(s.substring(0, 3));
                Integer end = Integer.valueOf(s.substring(3, 6));
                s = s.substring(7);
                if (s.contains("\\W")) {
                    Content content = new Content();
                    content.setStart(start);
                    content.setEnd(end);
                    UUID uuid = UUID.randomUUID();
                    String str = uuid.toString();
                    String onlyReplace = str.replace("-", "");
                    if (s.contains("\\\\")) {
                        s = s.replace("\\\\", onlyReplace);
                    }
                    String[] textTypeArr = s.split("\\\\");
                    for (String texType : textTypeArr) {
                        if (texType.startsWith("T")) {
                            content.setRed(Integer.valueOf(texType.substring(1, 4)));
                            content.setGreen(Integer.valueOf(texType.substring(4, 7)));
                            content.setBlue(Integer.valueOf(texType.substring(7, 10)));
                            content.setAmber(Integer.valueOf(texType.substring(10, 13)));
                        } else if (texType.startsWith("K")) {
                            content.setBgRed(Integer.valueOf(texType.substring(1, 4)));
                            content.setBgGreen(Integer.valueOf(texType.substring(4, 7)));
                            content.setBgBlue(Integer.valueOf(texType.substring(7, 10)));
                            content.setBgAmber(Integer.valueOf(texType.substring(10, 13)));
                        } else if (texType.startsWith("M")) {
                            content.setSpace(Integer.valueOf(texType.substring(1, 3)));
                        } else if (texType.startsWith("F")) {
                            String fontTemp = texType.substring(1, 2);
                            content.setFont(fontTemp);
                            content.setHigh(Integer.valueOf(texType.substring(2, 4)));
                            content.setWidth(Integer.valueOf(texType.substring(4, 6)));
                        } else if (texType.startsWith("N")) {
                            content.setFlashTimes(Integer.valueOf(texType.substring(1, 3)));
                        } else if (texType.startsWith("R")) {
                            content.setFlashAreaLeft(Integer.valueOf(texType.substring(1, 4)));
                            content.setFlashAreaDown(Integer.valueOf(texType.substring(4, 7)));
                            content.setFlashAreaRight(Integer.valueOf(texType.substring(7, 10)));
                            content.setFlashAreaDown(Integer.valueOf(texType.substring(7, 10)));
                        } else if (texType.startsWith("W")) {
                            String text = texType.substring(1);
                            if (text.contains(onlyReplace)) {
                                text = text.replace(onlyReplace, "\\");
                            }
                            content.setContent(text);
                        } else if (texType.startsWith("A")) {
                            content.setWarp(true);
                        } else if (s.contains("\\")) {

                        }
                    }
                    contents.add(content);
                } else {
                    // 图片
                    PicInfo picInfo = new PicInfo();
                    String[] picTypeArr = s.split("\\\\");
                    picInfo.setStart(start);
                    picInfo.setEnd(end);
                    for (String picType : picTypeArr) {
                        if (picType.startsWith("B")) {
                            picInfo.setFileType("bmp");
                            picInfo.setName(picType.substring(1, 4));
                        } else if (picType.startsWith("P")) {
                            picInfo.setFileType("png");
                            picInfo.setName(picType.substring(1, 4));
                        } else if (picType.startsWith("J")) {
                            picInfo.setFileType("jpg");
                            picInfo.setName(picType.substring(1, 4));
                        } else if (picType.startsWith("G")) {
                            picInfo.setFileType("gif");
                            picInfo.setName(picType.substring(1, 4));
                        }
                    }
                    picInfos.add(picInfo);
                }
            }
            itemInfo.setContentList(contents);
            itemInfo.setPicList(picInfos);
            itemInfoList.add(itemInfo);
        }

        System.out.println(JSONObject.toJSONString(itemInfoList));*/
    }
}
