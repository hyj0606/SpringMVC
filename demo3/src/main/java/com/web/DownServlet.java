package com.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @ClassName SaveInfoServlet
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-22 8:50
 * @Version 1.0
 */

@WebServlet("/down")
public class DownServlet extends HttpServlet {

    //固定上传地址
    private String parent = "d:/image/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.解析下载文件路径:
        String filePath = req.getParameter("file");

        //2.声明响应头之客户端为: 下载方式

        //3.开始响应:


    }
}
