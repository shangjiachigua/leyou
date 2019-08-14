package com.leyou.upload;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author tianwenwen
 * @date 2019/8/8 21:11
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class FdfsTest {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    @Test
    public void testUpload() throws FileNotFoundException {
        File file = new File("D:\\one\\1.jpg");

        StorePath storePath = fastFileStorageClient.uploadFile(
                new FileInputStream(file),
                file.length(), "jpg",null);
        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getPath());
    }
    @Test
    public void testUploadThumbImage() throws FileNotFoundException {
        File file = new File("D:\\one\\3.jpg");

        StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(
                new FileInputStream(file),
                file.length(), "jpg",null);
        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getPath());

        String thumbImagePath = thumbImageConfig.getThumbImagePath(storePath.getPath());
        System.out.println(thumbImagePath);
    }
}
