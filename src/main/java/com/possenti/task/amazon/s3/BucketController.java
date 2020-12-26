package com.possenti.task.amazon.s3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/storage/")
public class BucketController {

    @Autowired
    private AWSS3Service awss3Service;

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.awss3Service.uploadFile(file);
    }
}
