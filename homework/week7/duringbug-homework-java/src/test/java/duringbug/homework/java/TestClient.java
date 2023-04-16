/*
 * @Description: 
 * @Author: 唐健峰
 * @Date: 2023-04-14 15:06:54
 * @LastEditors: ${author}
 * @LastEditTime: 2023-04-14 16:28:35
 */
package duringbug.homework.java;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import duringbug.homework.java.socket.Start.StartClinet;
import duringbug.homework.java.socket.Start.StartServer;

public class TestClient {
    @Test
    public void serverOpen() throws IOException, InterruptedException {
        Thread thread = new Thread(new StartServer(9091));
        thread.start();
        thread.join();
    }

    @Test
    public void clientOpen() throws InterruptedException, IOException {
        StartClinet startClinet = new StartClinet(9091, "127.0.0.1");
        Thread thread2 = new Thread(startClinet);
        thread2.start();
        thread2.join();
        startClinet.sendMsg("test");
        startClinet.sendMsg("xiaoxiezimu");
    }
}
