package com.supercoding.chapter_49;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        // 이미지 파일 읽기
        String readPath = "src/com/supercoding/chapter_49/picture.jpg";
        BufferedImage readImage = ReadImageFile(readPath);

        String savePath = "src/com/supercoding/chapter_49/picture2.jpg";
        WriteImageFile(readImage, savePath);
    }

    private static BufferedImage ReadImageFile(String filePath) {
        try {
            File fileStream = new File(filePath);
            BufferedImage image = ImageIO.read(fileStream);
            return image;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private static void WriteImageFile(BufferedImage imageBuffer, String savePath) {
        try {
            File fileStream = new File(savePath);
            ImageIO.write(imageBuffer, "jpg", fileStream);
            System.out.println("이미지 파일이 저장되었습니다. - " + savePath);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
