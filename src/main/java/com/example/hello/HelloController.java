package com.example.hello;

import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/hello")
@RestController
public class HelloController {

    private static final LocalDateTime NOW = LocalDateTime.now(ZoneId.of("Asia/Seoul"));

    @GetMapping
    public String hello() {
        return String.format("hello! started on %s%s", NOW, "main-branch");
    }
}
