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
import java.util.Map;
import java.util.Random;

/**
 * @ClassName SaveInfoServlet
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-22 8:50
 * @Version 1.0
 */

@WebServlet("/save_info")
public class SaveInfoServlet extends HttpServlet {

    //固定上传地址
    private String parent = "d:/image/";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletRequestContext reqCtx = new ServletRequestContext(req);
        Random random = new Random();
        int i = random.nextInt(9999);
        String newFile = i+".jpg";

        //检查是否具有上传文件格式
        if (FileUpload.isMultipartContent(reqCtx)){

            //1.解析请求中的文件组(2组: account, pic)
            FileItemFactory factory = new DiskFileItemFactory();
            FileUpload fileUpload = new FileUpload(factory);

            try {
                List<FileItem> items = fileUpload.parseRequest(reqCtx);

                //2.循环请求参数
                for (FileItem f1 : items) {
                    //3.检查是否为普通字段或者上传字段
                    boolean r1 = f1.isFormField();
                    if (r1){
                        //普通字段:直接使用存储数据库即可
                        System.out.println("普通字段: "+f1.getFieldName());
                    }else {
                        //4.如果上传文件则需要存储磁

                        f1.write(new File( parent+newFile));

                    }
                }

                //文件地址传递回去:提供下载和预览
                req.setAttribute("file_path",parent+newFile);

                //5.响应: 跳往下载页面
                req.getRequestDispatcher("/down.jsp").forward(req,resp);


            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
