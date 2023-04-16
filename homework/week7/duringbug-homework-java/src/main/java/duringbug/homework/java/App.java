/*
 * @Description: 
 * @Author: 唐健峰
 * @Date: 2023-04-14 10:57:24
 * @LastEditors: ${author}
 * @LastEditTime: 2023-04-14 15:05:05
 */
package duringbug.homework.java;

import java.io.IOException;

import duringbug.homework.java.socket.Start.StartClinet;
import duringbug.homework.java.socket.Start.StartServer;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        Thread threadClinet = new Thread(new StartClinet(9091, "127.0.0.1"));
        Thread threadServer = new Thread(new StartServer(9091));
        threadServer.run();
        threadClinet.run();
    }
}
