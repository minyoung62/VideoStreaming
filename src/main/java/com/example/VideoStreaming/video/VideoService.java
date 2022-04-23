package com.example.VideoStreaming.video;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepo videoRepo;

    public Video getVideo(String name) {
        if(!videoRepo.existsByName(name)) {
            throw new VideoAlreadyExistsException();
        }
        return videoRepo.findByName(name);
    }

    public List<String> getAllVideoNames() {
        return videoRepo.getAllEntryNames();
    }

    public void saveVideo(MultipartFile file, String name) throws IOException {
        if(videoRepo.existsByName(name)) {
            throw new VideoAlreadyExistsException();
        }
        Video newVideo = new Video(name, file.getBytes());
        videoRepo.save(newVideo);
    }

}
