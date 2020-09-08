/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package microservice.learning.com.core.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jader
 */
@Configuration
@ConfigurationProperties(prefix = "jwt.config")
@Setter
@Getter
public class JwtConfiguration {
    
    private String loginUrl = "/login/**";

    public String getLoginUrl() {
        return loginUrl;
    }
    
    @NestedConfigurationProperty
    private Header header = new Header();
    
    private int expiration = 3600;
    private String privateKey = "QqHk33aF89Ft4btoHhR2TebPL1ESge73";
    private String type = "encrypted";
    
    @Getter
    @Setter
    public static class Header {
        private String name = "Authorization";
        private String prefix = "Bearer";
    }
}
