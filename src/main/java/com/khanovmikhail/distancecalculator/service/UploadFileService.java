package com.khanovmikhail.distancecalculator.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
    void uploadXml(MultipartFile multipartFile);
}
