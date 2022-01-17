package ua.od.atomspace;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("ua.od.atomspace")
@Configuration
@EnableAspectJAutoProxy
public class MyConfig {
}
