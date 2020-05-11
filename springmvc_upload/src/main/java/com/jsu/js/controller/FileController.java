package com.jsu.js.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: sunc-idea
 * @time: 2020/5/7 8:58
 */
@Controller
@RequestMapping("file")
public class FileController {

    /*
     *
     * @description:扫描用户目录文件，将文件名返回给浏览器
     * @param request
     * @param model
     * @return: java.lang.String
     * @author: sunc_idea
     * @time: 2020/5/7 9:26
     */
    @RequestMapping("fileDownload")
    public String fileDownload(HttpServletRequest request, Model model) {

        List<String> fileList = new ArrayList<>(10);

        //1.用户上传的文件路径
        //String userNSame = "";
        String userFolder = "upload" + File.separator;
        String uploadDir = request.getServletContext().getRealPath(userFolder);

        Path uploadDirTarget = Paths.get(uploadDir);
        //读取文件目录，但不是递归的
        try {
            Files.list(uploadDirTarget).forEach((Path path) -> {
                fileList.add(path.getFileName().toString());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("fileList", fileList);
        System.out.println(fileList);
        return "downLoad";
    }


    @RequestMapping("fileDownloads")
    public void fileDownloads(@RequestParam("fileName") String fileName, HttpServletResponse response, HttpServletRequest request) {
        //String userName;
        OutputStream os = null;
        FileInputStream fileInp = null;

        // "upload/+userName"
        fileName = request.getServletContext().getRealPath("upload") + File.separator + fileName;
        try {
            //如果想要浏览器下载文本文件需要设置响应头
            response.setHeader("Content-Type", "application/x-msdownload" );
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName,"UTF-8"));
            //输入流
            fileInp = new FileInputStream(fileName);

            //输出流
            os = response.getOutputStream();

            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = fileInp.read(bytes)) != -1) {
                os.write(bytes, 0, length);
                os.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
