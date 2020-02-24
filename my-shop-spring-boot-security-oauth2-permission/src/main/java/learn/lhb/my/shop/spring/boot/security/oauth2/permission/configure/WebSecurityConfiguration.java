package learn.lhb.my.shop.spring.boot.security.oauth2.permission.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 服务器安全配置（认证过程)
 *
 * todo 完善前面几个没写完的项目里面的todo提示和代码
 * todo 把spring security oauth2 涉及的源码做个笔记
 * todo 把spring的工具类 HttpStatus 做个笔记
 * @author 梁鸿斌
 * @date 2020/2/24.
 * @time 11:55
 */
@Configuration
@EnableWebSecurity // 开启权限认证
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)// 全局方法拦截
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 配置默认的非对称性的加密方式
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 模拟数据库的数据
        auth.inMemoryAuthentication()
                // 在内存中设置认证，并给该用户配置角色
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("USER");
    }
}
