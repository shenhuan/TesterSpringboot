package com.vue;

import com.vue.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableConfigurationProperties(value = {Person.class})
public class DemoApplicationTests {
    @Autowired
    Person person;

    @Test
    void contextLoads(){
        System.out.println(person);
    }
}
