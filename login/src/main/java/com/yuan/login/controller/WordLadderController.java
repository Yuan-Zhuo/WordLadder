package com.yuan.login.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.yuan.login.service.WordLadderService;

@RestController
@RequestMapping(value = "/wordladder")
public class WordLadderController {

    @Autowired
    WordLadderService wordladderService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public String path(@RequestParam(value="word1", defaultValue="") String str1,
                     @RequestParam(value="word2", defaultValue="") String str2) {
        return wordladderService.getPath(str1, str2);
    }
}
