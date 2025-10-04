package com.supercoding.chapter_50;

import com.supercoding.chapter_50.Customer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<>();

        // 서버 소켓 생성
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("서버가 시작되었습니다.");

            while (true) {
                // 클라이언트 접속 대기
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("클라이언트가 접속되었습니다.");

                    // 클라이언트로부터 데이터를 받기 위한 InputStream 생성
                    InputStream clientInputStream = clientSocket.getInputStream();
                    ObjectInputStream objectInputStream = new ObjectInputStream(clientInputStream);

                    // 클라이언트로 데이터를 보내기 위한 OutputStream 생성
                    OutputStream serverOutputStream = clientSocket.getOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(serverOutputStream);

                    // 클라이언트로부터 데이터를 읽고 화면에 출력
                    Customer customer = (Customer) objectInputStream.readObject();
                    System.out.println("클라이어트로부터 받은 메시지: " + customer);
                    customerList.add(customer);

                    // 클라이언트에게 응답을 보냄
                    objectOutputStream.writeObject(customerList);
                    objectOutputStream.flush();

                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
