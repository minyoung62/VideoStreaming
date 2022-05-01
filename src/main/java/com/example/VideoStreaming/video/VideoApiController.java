package com.example.VideoStreaming.video;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("video")
@RequiredArgsConstructor
@Slf4j
public class VideoApiController {

    private final VideoService videoService;

    @PostMapping()
    public ResponseEntity<String> saveVideo(@RequestParam("file")MultipartFile file, @RequestParam("name") String name) throws IOException {
        videoService.saveVideo(file, name);
        log.info("save");
        return ResponseEntity.ok("Video saved complete");
    }

    @GetMapping("{name}")

    public ResponseEntity<Resource> getVideoByName(@PathVariable("name") String name) {
        System.out.println("name12" + name);
        return ResponseEntity
                .ok(new ByteArrayResource(videoService.getVideo(name).getData()));
    }

    @GetMapping("all")
    public ResponseEntity<List<String>> getAllVideoNames() {
        return ResponseEntity
                .ok(videoService.getAllVideoNames());
    }

}
