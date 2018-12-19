package com.cskaoyan.smzdm.utils;

import com.aliyun.oss.OSSClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class AliyunUploadutils {

    public static String upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。
        // 强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAI2paKmtWMixR4";
        String accessKeySecret = "Rz2O1SJHuAp8ZeleiELgNuqnbMSF7G";
        String bucketName = "half";
        String objectName = UUID.randomUUID().toString().replaceAll("-","") + originalFilename;

        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
        InputStream inputStream = file.getInputStream();
        ossClient.putObject(bucketName, objectName, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
        //https://half.oss-cn-shenzhen.aliyuncs.com/c844c59f727abbc3b1671464e6a3472f.jpeg
        return "https://" + bucketName + "." + endpoint.substring(7) + "/" + objectName;
    }
}
