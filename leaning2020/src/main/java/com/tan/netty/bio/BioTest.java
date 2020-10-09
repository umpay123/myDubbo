package com.tan.netty.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/09/28/20:25
 * @Description:
 */
public class BioTest {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(8888);
            System.out.println("step1: new socket(8888)");
            Socket client = socket.accept(); //阻塞1
            System.out.println("step2:client:"+client.getPort());
            InputStream in = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            System.out.println(bufferedReader.readLine());  //阻塞2
            while (true){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
