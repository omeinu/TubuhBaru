package com.example.tubuhbaru;

import com.example.tubuhbaru.controller.HelloController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloControllerTest {
    @Test
    void helloReturnsMessage() {
        HelloController controller = new HelloController();
        assertEquals("Hello World", controller.hello().get("message"));
    }
}
