package com.possenti.task.amazon.s3;

import org.springframework.web.multipart.MultipartFile;

public interface AWSS3Service {

    String uploadFile(final MultipartFile multipartFile);
}
