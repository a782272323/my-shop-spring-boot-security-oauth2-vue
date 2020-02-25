package learn.lhb.my.shop.spring.boot.security.oauth2.permission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author 梁鸿斌
 * @date 2020/2/24.
 * @time 11:37
 */
@SpringBootApplication
@EnableResourceServer // 作为资源服务器
public class PermissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PermissionApplication.class, args);
    }
}
