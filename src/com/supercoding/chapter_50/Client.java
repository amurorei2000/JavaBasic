package com.supercoding.chapter_50;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        // 서버에 연결
        try (Socket socket = new Socket("localHost", 1234)) {
            // 서버로 데이터를 보내기 위한 OutputStream 생성
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            // 서버로부터 데이터를 받기 위한 InputStream 생성
            InputStream inputStream = socket.getInputStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            // 서버에 메시지 전송
            Customer customer = new Customer("1", "박원석");
            objectOutputStream.writeObject(customer);
            objectOutputStream.flush();

            // 서버로부터 받은 응답 출력
//            String res = bufferedReader.readLine();
//            System.out.println("서버 응답(고객 명단 스트링): " + res);

            List<Customer> response = (List<Customer>)objectInputStream.readObject();
            System.out.println("서버 응답(고객 명단 리스트): " + response);

            System.out.println("Client가 종료되었습니다");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
