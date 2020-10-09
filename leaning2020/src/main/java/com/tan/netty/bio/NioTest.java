package com.tan.netty.bio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: tanlin
 * @Date: 2020/09/29/14:56
 * @Description:
 */
public class NioTest {
    public static void main(String[] args) throws Exception {
        LinkedList<SocketChannel> clients = new LinkedList<>();
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress(8888));
        ss.configureBlocking(false); //设置阻塞 false 非阻塞
        while (true){
            Thread.sleep(1000);
            SocketChannel client = ss.accept();
            if (client != null){
                client.configureBlocking(false);
                int prot = client.socket().getPort();
                System.out.println("client...port:"+prot);
                clients.add(client);
            }else {
                System.out.println("null........");
            }
            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            for (SocketChannel c : clients){
                int num = c.read(buffer);
                if (num>0){
                    buffer.flip();
                    byte[] aaa = new byte[buffer.limit()];
                    buffer.get(aaa);
                }
            }
        }
    }
}
