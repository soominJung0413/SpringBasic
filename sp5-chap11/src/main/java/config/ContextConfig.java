package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ MemberConfig.class, MvcConfig.class })
public class ContextConfig {

}
