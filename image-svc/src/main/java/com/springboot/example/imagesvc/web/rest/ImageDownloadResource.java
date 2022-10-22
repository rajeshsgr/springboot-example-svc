package com.springboot.example.imagesvc.web.rest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;

/**
 * @author rajeshp
 * @Date 10/22/22
 */
@RestController
@RequestMapping("/image")
public class ImageDownloadResource {
    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<StreamingResponseBody> downloadLog() throws FileNotFoundException, IOException {

        File file = new ClassPathResource("image/img.png").getFile();

        InputStream inputStream = new FileInputStream(file);
        StreamingResponseBody body = outputStream -> FileCopyUtils.copy(inputStream, outputStream);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment;filename=img.png")
                .body(body);
    }
}

