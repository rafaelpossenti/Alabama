package com.possenti.task.amazon.s3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class AWSS3ServiceImpl implements AWSS3Service {

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @Override
    @Async
    public String uploadFile(final MultipartFile multipartFile) {
        String fileUrl = "";
        try {
            final File file = convertMultiPartToFile(multipartFile);
            fileUrl = uploadFileToS3Bucket(bucketName, file);
            file.delete();
        } catch (final AmazonServiceException | IOException ex) {
            throw new RuntimeException("Ero ao fazer o upload do arquivo", ex);
        }
        return fileUrl;
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private String uploadFileToS3Bucket(final String bucketName, final File file) {
        final String uniqueFileName = LocalDateTime.now() + "_" + file.getName();
        final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
        amazonS3.putObject(putObjectRequest);
        return amazonS3.getUrl(bucketName, uniqueFileName).toString();
    }
}