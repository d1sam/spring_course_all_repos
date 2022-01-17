package ua.od.atomspace;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("myApp.properties")
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean(){
        return new Cat();
    }

    @Bean
    @Scope("prototype")
    public Person personBean(){
        return new Person(catBean());
    }
}
