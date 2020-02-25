package learn.lhb.my.shop.spring.boot.security.oauth2.permission.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

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
        // 配置默认的加密方式
        return new BCryptPasswordEncoder();
    }

    /**
     * 不用授权就能访问的url地址
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/oauth/check/token");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/login")
                .antMatchers("/oauth/authorize")
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()    // 自定义登录页面，这里配置了 loginPage, 就会通过 LoginController 的 login 接口加载登录页面
                .and().csrf().disable();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 模拟数据库的数据
        auth.inMemoryAuthentication()
                // 在内存中设置认证，并给该用户配置角色
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("USER");
    }

}
