package Activiti.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//必须加上否则不识别SpringUtils类为Bean不能自动注入
@ComponentScan({"Activiti.config"})
@EntityScan(basePackages = {"com.flying.cattle.system.entity"})

public class BootActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootActivitiApplication.class, args);
    }

}
