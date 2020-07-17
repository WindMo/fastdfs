package com.mo.fastdfsdemo.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author WindShadow
 * @verion 2020/3/6.
 */

public class FastDFSWebUtil {
    /**
     * StorageClient的上传方法upload_file(...)返回的是字符串数组String[]，
     * 如[group1,M00/00/00/wKgAb1dBK2iANrayAA1rIuRd3Es112.jpg]
     *
     * StorageClient1的上传方法upload_file(...)返回的是字符串String，
     * 如group1/M00/00/00/wKgAb1dBK2iANrayAA1rIuRd3Es112.jpg，也就是已经帮我们拼接好了
     *
     */
    private static final Logger logger = LoggerFactory.getLogger(FastDFSHelper.class);
    private static TrackerClient trackerClient;
    static {
        try {
            ClientGlobal.init("fastdfs_client.conf");
            trackerClient = new TrackerClient();
        } catch (IOException | MyException e) {
            logger.error("error",e);
        }
    }
    // 上传文件

    /**
     *
     * @param multipartFile
     * @return
     */
    public static String uploadFile(MultipartFile multipartFile){

        byte[] fileBuff = null;
        TrackerServer trackerServer = null;
        String fileName = null;
        try {
            trackerServer = trackerClient.getConnection();
            fileBuff = multipartFile.getBytes();
            StorageClient1 storageClient = new StorageClient1(trackerServer, null);
            fileName = storageClient.upload_file1(fileBuff,null,null);
        } catch (IOException e) {
            logger.error("error", e);
        } catch (MyException e) {
            logger.error("error", e);
        }finally {
            closeTrackerServer(trackerServer);
        }
        return fileName;
    }

    private static void closeTrackerServer(TrackerServer trackerServer) {
        try {
            if (trackerServer != null) {
                logger.info("关闭trackerServer连接");
                trackerServer.close();
            }
        } catch (IOException e) {
            logger.error("error", e);
        }
    }
}
