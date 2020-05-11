package com.jsu.js.commons;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @description: 多文件上传
 * @author: sunc-idea
 * @time: 2020/5/4 19:35
 */
public class UploadUtils {

    private MultipartFile[] multipartFiles;


    /*
     *
     * @description: 文件保存
     * @param multipartFiles
     * @param targetDir     file save path
     * @return: void
     * @author: sunc_idea
     * @time: 2020/5/4 20:16
     */
    public final static void saveDocument(MultipartFile[] multipartFiles,String targetDir){
        boolean isSave = false;
        Arrays.stream(multipartFiles).forEach((MultipartFile multipartFile) -> {
            if (!multipartFile.isEmpty()) {
                try {
                    Path targetPath = Paths.get(targetDir);
                    if (Files.notExists(targetPath)||!Files.isDirectory(targetPath)) {
                        Files.createDirectories(targetPath);
                    }
                    //获取文件的名称
                    String filename = multipartFile.getOriginalFilename();
                    //保存到发布路径
                    Path target = Paths.get(targetDir, filename);
                    multipartFile.transferTo(target);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
