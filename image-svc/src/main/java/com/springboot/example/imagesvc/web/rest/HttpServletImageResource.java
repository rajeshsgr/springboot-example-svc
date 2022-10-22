package com.springboot.example.imagesvc.web.rest;

import com.springboot.example.imagesvc.service.ImageResourceHttpRequestHandler;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/images")
public class HttpServletImageResource {
    @Resource
    private ImageResourceHttpRequestHandler imageResourceHttpRequestHandler;

    /**
     * Displays image on the browser
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    @GetMapping("/displayOnBrowser")
    public void download(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        File file = new ClassPathResource("image/img.png").getFile();
        httpServletRequest.setAttribute(ImageResourceHttpRequestHandler.ATTRIBUTE_FILE, file);
        imageResourceHttpRequestHandler.handleRequest(httpServletRequest, httpServletResponse);

    }
}
