package config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Hanz
 * @date 2020/5/11
 */
@Data
@Component
@ConfigurationProperties(prefix = "adconf.mysql")
public class MYSQLConfig {
    private String host;
    private Integer port;
    private String username;
    private String password;

}
