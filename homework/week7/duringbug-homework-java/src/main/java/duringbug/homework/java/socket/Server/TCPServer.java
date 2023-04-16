/*
 * @Description: 
 * @Author: 唐健峰
 * @Date: 2023-04-14 11:05:53
 * @LastEditors: ${author}
 * @LastEditTime: 2023-04-14 16:17:33
 */
package duringbug.homework.java.socket.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import duringbug.homework.java.utils.UpperUtil;

public class TCPServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(TCPServer.class);
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        LOGGER.info("Server listening on port " + port);
        // 1. 创建一个服务器端Socket，即ServerSocket，监听指定端口
        serverSocket = new ServerSocket(port);
        // 2. 调用accept()方法开始监听，阻塞等待客户端的连接
        LOGGER.info("Waiting for client connection...");
        clientSocket = serverSocket.accept();
        LOGGER.info("Client connected");
        // 3. 获取Socket的字节输出流
        out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(),
                StandardCharsets.UTF_8), true);
        // 4. 获取Socket的字节输入流，并准备读取客户端发送的信息
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),
                StandardCharsets.UTF_8));
        // 5. 阻塞读取客户端发送的信息
        String str;
        while ((str = in.readLine()) != null) {
            LOGGER.info("我是服务端，客户端说: " + str);
            // 消息回写
            if (str.equals("stop")) {
                break;
            }
            out.println("服务端已收到消息" + UpperUtil.upperWords(str));
        }
        this.stop();
    }

    public void stop() throws IOException {
        LOGGER.info("Closing server and client sockets");
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}