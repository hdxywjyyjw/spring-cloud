package com.xu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jitwxs
 * @date 2021年12月17日 14:54
 */

@Data
@Component   //在启动是自动装载成bin
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    private String hahah;
    private  String xixixi;
}
