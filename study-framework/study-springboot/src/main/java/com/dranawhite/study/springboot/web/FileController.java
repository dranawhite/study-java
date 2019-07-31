package com.dranawhite.study.springboot.web;

import com.dranawhite.api.model.DranaResponse;
import com.dranawhite.common.resource.ResourceLoader;

import lombok.extern.slf4j.Slf4j;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author dranawhite
 * @version : FileController.java, v 0.1 2019-07-31 18:06 dranawhite Exp $$
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @PostMapping("/upload")
    public DranaResponse<Boolean> uploadFile(MultipartFile file) {
        log.info("FileName = [{}]", file.getOriginalFilename());
        return DranaResponse.success(Boolean.TRUE);
    }

    @GetMapping("/{fileName}/download")
    public ResponseEntity<FileSystemResource> downloadFile(@PathVariable String fileName) {
        log.info("FileName = [{}]", fileName);
        File file = ResourceLoader.getClasspathFile("static/index.html");
        return buildDownloadResponseHeader(file, fileName);
    }


    private static ResponseEntity<FileSystemResource> buildDownloadResponseHeader(File file, String fileName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=" + fileName);
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        FileSystemResource result = new FileSystemResource(file);
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(result);
    }
}
