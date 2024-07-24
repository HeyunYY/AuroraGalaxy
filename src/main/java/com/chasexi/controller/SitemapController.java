package com.chasexi.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Chasexi
 * @version 1.0
 * @date: 2024/6/5 23:31
 * @Description: 网站地图
 */

@RestController
public class SitemapController {

    @GetMapping(value = "/sitemap.xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getSitemap() throws IOException {
        // 读取资源目录中的sitemap.xml文件内容并返回
        Resource resource = new ClassPathResource("sitemap.xml");
        InputStream inputStream = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }

        return ResponseEntity.ok().body(content.toString());
    }

    /**
     * robots.txt
     * @ return
     */

    @GetMapping("/robots.txt")
    public void robotsTxt(HttpServletResponse response) throws IOException {
        Writer writer = response.getWriter();
        String lineSeparator = System.getProperty("line.separator", "\n");
        writer.append("User-agent: *").append(lineSeparator);
        writer.append("Disallow:").append("/mapper").append(lineSeparator);
        writer.append("Disallow:").append("/static").append(lineSeparator);
        writer.append("Disallow:").append("/admin").append(lineSeparator);
        writer.append("Disallow:").append("/private").append(lineSeparator);
    }
}
