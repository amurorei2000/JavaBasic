package com.supercoding.chapter_49;

import java.io.*;

public class BufferedStreamTest {
    public static void main(String[] args) {
        String savePath = "src/com/supercoding/chapter_49/buffer_test.txt";
        String saveText = "헤이 요 맨~\n너는 누구냡?";
        SaveTextBuffer(saveText, savePath);

        String readPath = "src/com/supercoding/chapter_49/buffer_test.txt";
        ReadTextBuffer(readPath);
    }

    public static void SaveTextBuffer(String saveText, String savePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(savePath))){
            bw.write(saveText);
            System.out.println("버퍼를 파일로 저장했습니다.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadTextBuffer(String readPath) {
        try (BufferedReader br = new BufferedReader(new FileReader(readPath))) {
            String data;
            while((data = br.readLine()) != null) {
                System.out.println(data);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
