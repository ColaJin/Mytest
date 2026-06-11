package hikversion.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.oracle.jrockit.jfr.EventInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author tengleilei
 * @date 2024/9/26 18:09
 * @description: TODO
 */
public class JettyHttpServletHandler extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(JettyHttpServletHandler.class);

    private String m_port;

    public JettyHttpServletHandler(String port) {
        super();
        m_port = port;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


    /*protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理POST请求的逻辑

        //System.out.println("requestxxxxx" + req.getContentType());
        String contentType = req.getContentType();
        if (contentType != null && contentType.startsWith("multipart/form-data")){
            //1.1\1.2
            *//*String cameraCode = req.getParameter("cameraCode");
            System.out.println("multipart/form-data" + cameraCode);
            Map<String, String[]> parameterMap = req.getParameterMap();
            for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
                System.out.println(stringEntry.getKey());
            }
            resp.getWriter().write("Parameters: " + parameterMap);*//*



        }else if (contentType != null && contentType.startsWith("image/jpeg")){
            //1.3图片
            System.out.println("jpeg");
        }else if (contentType != null && contentType.startsWith("video/mpeg4")){
            //1.3视频
            System.out.println("video");
        }
        *//*String cameraCode = req.getParameter("cameraCode");
        System.out.println("cameraCode"+cameraCode);
        String reduce = req.getReader().lines().reduce("", (acc, line) -> acc + line);
        System.out.println("reduce" + reduce);*//*
     *//*for (Part part : req.getParts()) {
            if (part.getName().equals("file")) {
                InputStream input = part.getInputStream();
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int length;
                while ((length = input.read(buffer)) != -1) {
                    output.write(buffer, 0, length);
                }
                byte[] fileBytes = output.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(fileBytes);
                System.out.println("base64Image"+base64Image);
            }
        }*//*
     *//*if (req.getContentType().startsWith("multipart/form-data")) {
            Part part = req.getPart("file");
            if (part != null) {
                String fileName = part.getSubmittedFileName();
                String savePath = getServletContext().getRealPath("/uploads") + File.separator + fileName;
                File saveFile = new File(savePath);
                // 保存文件
                part.write(saveFile.getAbsolutePath());
            }
        }*//*
    }*/

    @Override
    /*protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理POST请求的逻辑
        String contentType = req.getContentType();

        HashMap<String, Object> headers = new HashMap<>();
        HashMap<String, Object> body = new HashMap<>();
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            headers.put(headerName, headerValue);
        }
        if (contentType != null && contentType.contains("multipart/form-data")) {
            // 处理multipart/form-data，例如文件上传
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> items = upload.parseRequest(req);
                for (FileItem item : items) {
                    if (!item.isFormField()) {
                        String fieldName = item.getFieldName();
                        String fileName = item.getName();
                        String fileContentType = item.getContentType();
                        if (fileName != null && !fileName.isEmpty()) {
                            // 文件为图片
                            if (fileContentType != null && fileContentType.startsWith("image/")) {
                                body.put(fieldName, Base64.getEncoder().encodeToString(item.get()));
                            } else if (fileContentType != null && fileContentType.startsWith("video/")) {
                                // 文件为视频
                                String fileType = fileContentType.split("/")[1];
                                String filePath = queryTempFileDictionary() + File.separator + UUID.randomUUID().toString() + "." + fileType;
                                File storeFile = new File(filePath);
                                item.write(storeFile);
                                body.put(fieldName, filePath);
                            }
                        }
                    } else {
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString(); // 获取表单字段值
                        body.put(fieldName, fieldValue);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (contentType != null && contentType.startsWith("image/")) {
            // 创建一个字节数组输出流来存储文件数据
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ServletInputStream inputStream = req.getInputStream();
            // 缓冲区
            byte[] buffer = new byte[1024];
            int bytesRead;

            // 读取数据并写入到输出流中
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            body.put("fileUrl", Base64.getEncoder().encodeToString(outputStream.toByteArray()));
            body.putAll(headers);

        } else if (contentType != null && contentType.startsWith("video/")) {
            // 创建一个字节数组输出流来存储文件数据
            String filePath = queryTempFileDictionary();
            Path path = Paths.get(filePath);
            String fileType = contentType.split("/")[1];
            if (!Files.exists(path)) {
                Files.createDirectories(path);
                System.out.println("目录创建成功。");
            }

            String fileName = filePath + File.separator + UUID.randomUUID().toString() + "." + fileType;
//            ServletInputStream inputStream = req.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(new File(fileName));
            ServletInputStream inputStream = req.getInputStream();
            // 缓冲区
            byte[] buffer = new byte[1024];
            int bytesRead;

            // 读取数据并写入到输出流中
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            body.put("fileUrl", fileName);
            body.putAll(headers);
        } else {
            // 处理JSON数据
            String data = req.getReader().lines().reduce("", (acc, line) -> acc + line);
            body = JSONObject.parseObject(data, new TypeReference<HashMap<String, Object>>() {
            });
        }
        String data = JSONObject.toJSONString(body);

        System.out.println("data info" + data);
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.flush();
        out.close();
    }*/

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理POST请求的逻辑
        String contentType = req.getContentType();

        HashMap<String, Object> headers = new HashMap<>();
        HashMap<String, Object> body = new HashMap<>();
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            headers.put(headerName, headerValue);
        }
        if (contentType != null && contentType.contains("multipart/form-data")) {
            // 处理multipart/form-data，例如文件上传
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> items = upload.parseRequest(req);
                for (FileItem item : items) {
                    if (!item.isFormField()) {
                        // String fieldName = item.getFieldName();
                        String fileName = item.getName();
                        String fileContentType = item.getContentType();
                        if (fileName != null && !fileName.isEmpty()) {
                            // 文件为图片
                            if (fileContentType != null && fileContentType.startsWith("image/")) {
                                // body.put(fieldName, Base64.getEncoder().encodeToString(item.get()));
                                body.put("picInfo", Base64.getEncoder().encodeToString(item.get()));
                            } else if (fileContentType != null && fileContentType.startsWith("video/")) {
                                // 文件为视频
                                String fileType = fileContentType.split("/")[1];
                                String filePath = queryTempFileDictionary() + File.separator + UUID.randomUUID().toString() + "." + fileType;
                                File storeFile = new File(filePath);
                                item.write(storeFile);
                                // body.put(fieldName, filePath);
                                body.put("fileUrl", filePath);
                            }
                        }
                    } else {
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString(); // 获取表单字段值
                        body.put(fieldName, fieldValue);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (contentType != null && contentType.startsWith("image/")) {
            ByteArrayOutputStream outputStream = null;
            ServletInputStream inputStream = null;
            try {
                // 创建一个字节数组输出流来存储文件数据
                outputStream = new ByteArrayOutputStream();
                inputStream = req.getInputStream();
                // 缓冲区
                byte[] buffer = new byte[8192];
                int bytesRead;

                // 读取数据并写入到输出流中
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                body.put("picInfo", Base64.getEncoder().encodeToString(outputStream.toByteArray()));
                body.putAll(headers);
            } catch (IOException e) {
                logger.error("文件处理失败", e);
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } else if (contentType != null && contentType.startsWith("video/")) {
            // 创建一个字节数组输出流来存储文件数据
            String filePath = queryTempFileDictionary();
            Path path = Paths.get(filePath);
            String fileType = contentType.split("/")[1];
            if (!Files.exists(path)) {
                Files.createDirectories(path);
                System.out.println("目录创建成功。");
            }
//            String fileName = filePath + File.separator + UUID.randomUUID().toString() + "." + fileType;
            String fileName = filePath + File.separator + UUID.randomUUID().toString() + ".mp4";
            FileOutputStream outputStream = null;
            ServletInputStream inputStream = null;
            boolean isComplete = false;
            // 方案1：设置超时阈值（例如10分钟无新数据视为完成）
            long lastReadTime = System.currentTimeMillis();
            try {
                outputStream = new FileOutputStream(new File(fileName));
                inputStream = req.getInputStream();
                // 缓冲区
                byte[] buffer = new byte[8192];
                int bytesRead;

                body.put("fileUrl", fileName);
                body.putAll(headers);
                // 读取数据并写入到输出流中
                while (!isComplete && (bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                    // 超过30秒无新数据则主动终止
                    if (System.currentTimeMillis() - lastReadTime > 30000) {
                        logger.warn("主动终止读取：连续30秒无新数据");
                        isComplete = true;
                    }
                    lastReadTime = System.currentTimeMillis();
                }
            } catch (IOException e) {
                logger.error("文件处理失败", e);
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }

        } else if (contentType.contains("application/json")) {
            // 处理JSON数据
            try {
                String data = req.getReader().lines().reduce("", (acc, line) -> acc + line);
                body = JSONObject.parseObject(data, new TypeReference<HashMap<String, Object>>() {
                });
            } catch (Exception e) {
                logger.error("文件处理失败", e);
            }

        } else if (contentType.contains("text/plain") || contentType.contains("text/xml") ||
                contentType.contains("application/xml") || contentType.contains("application/x-www-form-urlencoded")) {
            // 处理ASCII文本数据
            try (BufferedReader reader = req.getReader()) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                String asciiData = sb.toString();
                body.put("bodyData", asciiData);
                logger.info("Received ASCII data: {}", asciiData);
            } catch (IOException e) {
                logger.error("ASCII data processing failed", e);
            }
        }
        String data = JSONObject.toJSONString(body);

        resp.setContentType("application/json; charset=utf-8");
        ResultData resultData = new ResultData();
        resultData.setCode("0");
        PrintWriter out = resp.getWriter();
        out.append(JSON.toJSONString(resultData));
        out.flush();
        out.close();
    }

    private String queryTempFileDictionary() {
        String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        String scriptPath = "";
        try {
            int lastIndex = path.lastIndexOf(File.separator) + 1;
            if (lastIndex > 0) {
                scriptPath = path.substring(0, lastIndex) + File.separator + "tempfile";
                ;
            } else {
                scriptPath = System.getProperty("user.dir") + "//blankProgram//src//main//resources//tempfile";

            }
        } catch (Exception e) {
            logger.error("loadScriptPath error", e);
        }
        return scriptPath;
    }

}
