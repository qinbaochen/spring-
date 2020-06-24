package top.noobchen.springshiro.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.ShiroWebConfiguration;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
    @Bean
    public DefaultWebSecurityManager defaultSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(@Qualifier("defaultSecurityManager") DefaultSecurityManager defaultSecurityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(defaultSecurityManager);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("/user/add","perms[user:add]");
        map.put("/user/*","authc");
        map.put("/logout","logout");
        filterFactoryBean.setFilterChainDefinitionMap(map);
        filterFactoryBean.setLoginUrl("/toLogin");

        return filterFactoryBean;
    }
}
