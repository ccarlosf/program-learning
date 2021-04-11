package com.ccarlosf.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public String upload(MultipartFile file, String fileExtName) throws Exception;

    public String uploadOSS(MultipartFile file, String userId, String fileExtName) throws Exception;

}
