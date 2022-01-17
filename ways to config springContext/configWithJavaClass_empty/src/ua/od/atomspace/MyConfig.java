package ua.od.atomspace;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("ua.od.atomspace")
@PropertySource("myApp.properties")
public class MyConfig {
}
