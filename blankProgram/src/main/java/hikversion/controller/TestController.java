package hikversion.controller;

import com.alibaba.fastjson.JSONObject;
import entity.DemoData;
import hikversion.DeviceUser;
import hikversion.Template;
import hikversion.UpgradePostContent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:jinyandong
 * @description:测试浏览器请求
 * @Date:2022/5/25
 */
public class TestController {

    @GetMapping("/upload")
    public void e1(File file) {
        Template template = new Template();
        Boolean aBoolean = template.checkTemplateTitle(new File(""), DeviceUser.class, 2);
        System.out.println(aBoolean);
    }

    @PostMapping("/upgrade")
    public void e1(@RequestBody UpgradePostContent upgradePostContent) {
        System.out.println(JSONObject.toJSONString(upgradePostContent));
    }
}
