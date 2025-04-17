package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DatabaseConfig.class, RepositoryConfig.class, ServiceConfig.class})
public class AppConfig {



}
