package com.soomin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ WebMvcConifg.class, TransactionConfig.class, MyBatisConfig.class })
public class ContextConfig {

}
