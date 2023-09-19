package com.packt.cardatabase;

import com.packt.cardatabase.web.CarController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest
class CardatabaseApplicationTests {
    @Autowired
    private CarController controller;

    @Test
    @DisplayName("First example test case")
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
