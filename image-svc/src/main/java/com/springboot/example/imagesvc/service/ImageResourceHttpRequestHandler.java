package com.springboot.example.imagesvc.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import javax.servlet.http.HttpServletRequest;
import java.io.File;


@Component
public class ImageResourceHttpRequestHandler extends ResourceHttpRequestHandler {
    public static final String ATTRIBUTE_FILE = "DOWNLOADING_FILE";
    @Override
    protected Resource getResource(HttpServletRequest request) {
        File file = (File) request.getAttribute(ATTRIBUTE_FILE);
        return new FileSystemResource(file);
    }
}
