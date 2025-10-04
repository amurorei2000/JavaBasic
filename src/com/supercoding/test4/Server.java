package com.supercoding.test4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// 서버 클래스 정의
class Server {
    public static void main(String[] args) {

        // 유저 대기리스트
        List<User> userList = new ArrayList<>();

        // 1. 서버 소켓 생성
        try(ServerSocket serverSocket = new ServerSocket(1234)){
            System.out.println("서버가 시작되었습니다.");

            while(true) {
                // 유저 Server 연결 필요합니다.
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("클라이언트가 연결되었습니다.");

                    // 클라이언트로부터 전송된 UserDTO 수신
                    InputStream inputStream = clientSocket.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                    UserDTO userDTO = (UserDTO) objectInputStream.readObject();

                    // UserDTO를 User 객체로 변환
                    User user = userDTO.getRole().equals("admin") ?
                            new AdminUser(userDTO.getUsername(), userDTO.getRole()) :
                            new User(userDTO.getUsername(), userDTO.getRole());
                    userList.add(user);

                    // 유저 등록
                    System.out.println("새로운 유저가 등록되었습니다. " + userList);

                    // Client로 출력한 PrintWriter를 이용한 ServerOutputStream 출력
                    OutputStream outputStream = clientSocket.getOutputStream();
                    PrintWriter printWriter = new PrintWriter(outputStream, true);

                    // Client 에 응답 출력
                    printWriter.println("서버에 등록된 유저 리스트: " + userList);


                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
