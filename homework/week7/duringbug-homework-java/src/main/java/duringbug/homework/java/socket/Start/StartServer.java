/*
 * @Description: 
 * @Author: 唐健峰
 * @Date: 2023-04-14 14:22:58
 * @LastEditors: ${author}
 * @LastEditTime: 2023-04-14 16:11:10
 */
package duringbug.homework.java.socket.Start;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import duringbug.homework.java.socket.Server.TCPServer;

public class StartServer implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(StartServer.class);

    TCPServer tcpServer;
    int port;

    public StartServer(int port) throws IOException {
        this.tcpServer = new TCPServer();
        this.port = port;
    }

    public TCPServer getTCPServer() {
        return this.tcpServer;
    }

    public void run() {
        try {
            LOGGER.info("服务器端口尝试开放");
            this.tcpServer.start(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
