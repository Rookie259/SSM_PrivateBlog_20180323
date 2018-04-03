package com.muxi.reids.ssm.controller;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description: 图片上传
 *   @Author: MuXi
 *   @create: 2018-03-27 18:47
 */

import com.aliyun.oss.OSSClient;
import com.muxi.reids.ssm.tool.aliyun.OSSObjectLiteral;
import com.muxi.reids.ssm.tool.aliyun.OSSTool;
import com.muxi.reids.ssm.tool.commonTools.MultipartFileTranFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
/*测试  github更新   测试*/
@Controller
@RequestMapping("writeBlog")
public class ImageUploadController {

    @Autowired
    private MultipartFileTranFile multipartFileTranFile;

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public void imageUpload(MultipartFile upload, HttpServletResponse response, HttpServletRequest request, ModelMap map){
        File fileImage = multipartFileTranFile.multipartFileTranFile(upload);
        OSSClient ossClient = OSSTool.getOSSClient();
        String md5key = OSSTool.uploadObject2OSS(ossClient, fileImage, OSSObjectLiteral.Access_KEY_BUCKET_NAME, OSSObjectLiteral.FOLDER);
        String imgURL = OSSTool.achieveURLFB(md5key);
        String[] split = imgURL.split("\\?");
        String url = split[0].replaceAll(OSSObjectLiteral.ACCESS_KEY_ID, "") + OSSObjectLiteral.FOLDER + fileImage.getName();
        map.addAttribute("url", url);
        try {
            String callback = request.getParameter("CKEditorFuncNum");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + url + "',''" + ")");
            out.println("</script>");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setMultipartFileTranFile(MultipartFileTranFile multipartFileTranFile) {
        this.multipartFileTranFile = multipartFileTranFile;
    }
}
