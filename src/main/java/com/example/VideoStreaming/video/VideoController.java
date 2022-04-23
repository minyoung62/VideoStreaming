package com.example.VideoStreaming.video;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoController {

    @GetMapping("/")
    public String index(){
        return "main";
    }
}
