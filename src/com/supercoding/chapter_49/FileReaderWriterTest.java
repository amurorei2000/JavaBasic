package com.supercoding.chapter_49;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.Charset;

public class FileReaderWriterTest {
    public static void main(String[] args) {
        String writePath = "src/com/supercoding/chapter_49/write_test.txt";
        String saveText = "안녕하세요.\n박원석입니다.";

        // 텍스트 -> 파일 저장하기
        SaveTextToFile(writePath, saveText);
        ReadTextToFile(writePath);

        String writePath2 = "src/com/supercoding/chapter_49/write_test2.txt";
        String saveText2 = "Hello, I'm Won Seok Park.\nNice to meet you!";

        // 파일 -> 텍스트 읽기
        SaveTextToFile(writePath2, saveText2);
        ReadTextToFile(writePath2);
    }

    private static void SaveTextToFile(String writePath, String saveText) {
        try (FileWriter fw = new FileWriter(writePath, Charset.forName("UTF-8"))) {
            fw.write(saveText);
            System.out.println("파일을 저장하였습니다.");
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

    private static void ReadTextToFile(String readPath) {
        try (FileReader fr = new FileReader(readPath, Charset.forName("UTF-8"))) {
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
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
