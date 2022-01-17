package com.dmitryshulga.spring.springboot.springboot_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// эта аннотация заменяет множество аннотаций, таких как:
// @Configuration, @EnableAutoConfiguration - говорит, что конфигурация данного приложения была создана автоматически,
// @ComponentScan, в ее параметрах можно указать пакет, в котором будет происходить сканирование,
// по дэфолту пакет и его субпакеты, в котором находится данный класс
public class SpringbootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApplication.class, args);
	}

}
