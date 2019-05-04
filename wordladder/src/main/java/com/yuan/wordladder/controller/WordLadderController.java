package com.yuan.wordladder.controller;

import org.springframework.web.bind.annotation.*;
import com.yuan.wordladder.func.Path;

@RestController
@RequestMapping(value="/api")
public class WordLadderController {

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public Path path(@RequestParam(value="word1", defaultValue="") String str1,
                     @RequestParam(value="word2", defaultValue="") String str2) {
        Path ladder = new Path(str1, str2);
        return ladder;
    }

}
