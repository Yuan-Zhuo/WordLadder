package com.yuan.wordladder.app;

import com.yuan.wordladder.func.Path;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@SpringBootApplication
public class Controller {

    @GetMapping("hello.html")
    public String hello() {
        return "hello.html";
    }

    @GetMapping("index")
    public Object index(Authentication authentication) {
        // return SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    @RequestMapping("/")
    public Path path(@RequestParam(value="word1", defaultValue="") String str1,
                     @RequestParam(value="word2", defaultValue="") String str2) {
        Path ladder = new Path(str1, str2);
        return ladder;
    }
}
