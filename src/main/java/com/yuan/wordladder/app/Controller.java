package com.yuan.wordladder.app;

import com.yuan.wordladder.func.Path;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@SpringBootApplication
public class Controller {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/word")
    public Path path(@RequestParam(value="word1", defaultValue="") String str1,
                     @RequestParam(value="word2", defaultValue="") String str2) {
        Path ladder = new Path(str1, str2);
        return ladder;
    }
}
