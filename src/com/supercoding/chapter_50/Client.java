package com.supercoding.chapter_50;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        // 서버에 연결
        try (Socket socket = new Socket("localHost", 1234)) {
            // 서버로 데이터를 보내기 위한 OutputStream 생성
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter clientPrintWriter = new PrintWriter(outputStream, true);

            // 서버로부터 데이터를 받기 위한 InputStream 생성
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // 서버에 메시지 전송
            clientPrintWriter.println("이건 제가 정의한 Client 요청입니다.");
            String response = bufferedReader.readLine();

            // 서버로부터 받은 응답 출력s
            System.out.println("서버로부터 받은 메시지: " + response);

            System.out.println("Client가 종료되었습니다");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
