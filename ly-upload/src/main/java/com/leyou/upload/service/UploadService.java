package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.common.enums.ExceptionEnums;
import com.leyou.common.myexception.LyException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author tianwenwen
 * @date 2019/8/7 23:37
 **/
@Service
public class UploadService {
    //此坑
    //图片后缀是jpeg而不是jpg
    private static final List<String> ALLOW_TYPES = Arrays.asList("image/jpeg", "image/png");

    @Autowired
    private FastFileStorageClient storageClient;

    /**
     * 功能描述:图片上传
     *
     * @return java.lang.String
     * @Author wenwen
     * @Description //TODO
     * @Date 2019/8/9 10:44
     * @Param [file]
     **/
    public String uploadImage(MultipartFile file) throws IOException {
        //校验文件
        String contentType = file.getContentType();
        System.out.println(contentType);
        if (!ALLOW_TYPES.contains(contentType)) {
            throw new LyException(ExceptionEnums.FILE_TYPE_ERROR);
        }
        //校验文件内容
        BufferedImage read = ImageIO.read(file.getInputStream());
        if (null == read) {
            throw new LyException(ExceptionEnums.FILE_TYPE_ERROR);
        }

            /*//准备目标路径
            File dest = new File("C:/TestUpload", file.getOriginalFilename());
            //保存文件到本地
            file.transferTo(dest);
            //返回路径
            return "http://image.leyou.com" + file.getOriginalFilename();*/
        //上传到linux服务器 FastDFS单机版
        String houzhuiming = StringUtils.substringAfterLast(
                file.getOriginalFilename(), ".");
        StorePath storePath = storageClient.uploadFile(
                file.getInputStream(), file.getSize(), houzhuiming, null);
        return "http://image.leyou.com/" + storePath.getFullPath();

    }
}
