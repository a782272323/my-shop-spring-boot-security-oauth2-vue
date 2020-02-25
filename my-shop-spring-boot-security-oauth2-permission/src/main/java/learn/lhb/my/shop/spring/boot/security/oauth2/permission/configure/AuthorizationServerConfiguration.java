package learn.lhb.my.shop.spring.boot.security.oauth2.permission.configure;

import learn.lhb.my.shop.spring.boot.security.oauth2.commons.constant.AllConstantUtils;
import learn.lhb.my.shop.spring.boot.security.oauth2.commons.constant.UrlConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * 配置认证服务器
 *
 * @author 梁鸿斌
 * @date 2020/2/24.
 * @time 12:01
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 配置令牌端点(Token Endpoint)的安全约束.
     *
     * @param oauthServer
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    /**
     * 配置客户端详情服务（ClientDetailsService）
     * 客户端详情信息在这里进行初始化
     * 通过数据库来存储调取详情信息()
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 配置客户端
        clients
                // 使用内存设置
                .inMemory()

                // client_id
                .withClient(AllConstantUtils.CLIENT_ID)
                // client_secret
                .secret(passwordEncoder.encode(AllConstantUtils.CLIENT_SECRET))
                // 配置授权类型,授权码类型
                .authorizedGrantTypes("authorization_code")
                // 授权范围
                .scopes(AllConstantUtils.TEST_SCOPES)
                // 自动认证
                .autoApprove(true)
                // 注册回调地址
                .redirectUris(UrlConstantUtils.TEST_BAIDU_URL);
    }
}
