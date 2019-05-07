package com.lhj.fxwiz.io.v1;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description:
 * @Author: lhj
 * @Time: 2019/5/6 19:16
 * @Version: 1.0
 */
public class BIOTest {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("bio started");
            while (true){
                Socket clientScoket = serverSocket.accept();
                System.out.println("bio connection from"+clientScoket.getLocalSocketAddress());

                try(Scanner input = new Scanner(clientScoket.getInputStream())) {
                    while (true){
                        String request = input.nextLine();
                        if("quit".equals(request)){
                            break;
                        }
                        System.out.println(String.format("from %s %s:",clientScoket.getRemoteSocketAddress(),request));
                        String str = "From Bio say"+request +".\n";
                        clientScoket.getOutputStream().write(str.getBytes());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
