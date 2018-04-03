package com.muxi.reids.ssm.tool.commonTools;/*
 *   @program: SSM_PrivateBlog_20180323
 *   @description: MultipartFile转File
 *   @Author: MuXi
 *   @create: 2018-03-27 19:21
 */

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

public class MultipartFileTranFile {

    public File multipartFileTranFile(MultipartFile multipartFile){
        CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
        //这个myfile是MultipartFile的
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        File file = fi.getStoreLocation();
        return file;
    }
}
