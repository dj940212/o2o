package com.ding.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class ImageUtil {
    private String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    public static void main(String[] args) throws IOException{
        Thumbnails.of(new File("/Users/ding/Desktop/car.jpg"))
                .size(200, 200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("/Users/ding/projects/o2o/src/main/resources/star.png")), 0.25f)
                .outputQuality(0.8f).toFile("/Users/ding/Desktop/car_new.jpg");
    }

    /**
     * 生成缩略图
     * @param thumbnail
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(File thumbnail, String targetAddr) {
        String realFileName = FileUtil.getRandomFileName();
        String extension = getFileExtension(thumbnail);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(FileUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail).size(200,200).outputQuality(0.25f).toFile(dest);
        }catch (IOException e) {
            throw new RuntimeException("创建缩略图失败:" + e.toString());
        }

        return relativeAddr;
    }


    /**
     * 获取输入文件流的扩展名
     * @param file
     * @return
     */
    private static String getFileExtension(File file) {
        String originalFileName = file.getPath();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = FileUtil.getImgBasePath()+targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }
}
