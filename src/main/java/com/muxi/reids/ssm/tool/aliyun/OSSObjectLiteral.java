package com.muxi.reids.ssm.tool.aliyun;

import java.util.Date;

public class OSSObjectLiteral {
    //aliyunAPI外网的域名
    public static final String ENDPOINT = "oss-cn-beijing.aliyuncs.com";
    //aliyunAPI的密钥AccessKeyId
    public static final String ACCESS_KEY_ID = "LTAInTAv3VVJKRJF";
    //阿里云API的密钥Access Key Secret
    public static final String ACCESS_KEY_SECRET = "BIvjNTya8HCHCIgxD96sa1MsQvp7ov";
    //阿里云API的bucket名称
    public static final String Access_KEY_BUCKET_NAME= "rookieblog";
    //阿里云API的文件夹名称
    public static final String FOLDER = "WriteBlogImage/";
    //设置URL过期时间   1000天
    public static final Date expiration = new Date(new Date().getTime() + 3600 * 10000);
}
