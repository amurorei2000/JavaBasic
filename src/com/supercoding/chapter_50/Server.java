package com.supercoding.chapter_50;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        // 서버 소켓 생성
        // 클라이언트 접속 대기
        try (ServerSocket serverSocket = new ServerSocket(1234);
             Socket clientSocket = serverSocket.accept();
        ) {
            System.out.println("서버가 시작되었습니다.");
            System.out.println("클라이언트가 시작되었습니다.");

            // 클라이언트로부터 데이터를 받기 위한 InputStream 생성
            InputStream clientInputStream = clientSocket.getInputStream();
            BufferedReader clientBufferedReader = new BufferedReader(new InputStreamReader(clientInputStream));

            // 클라이언트로 데이터를 보내기 위한 OutputStream 생성
            OutputStream serverOutputStream = clientSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(serverOutputStream, true);

            String inputLine;

            // 클라이언트로부터 데이터를 읽고 화면에 출력
            while ((inputLine = clientBufferedReader.readLine()) != null) {
                System.out.println("클라이언트로부터 온 요청은: " + inputLine);

                // 클라이언트에게 응답을 보냄
                printWriter.println("서버로부터 응답이 왔습니다.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
