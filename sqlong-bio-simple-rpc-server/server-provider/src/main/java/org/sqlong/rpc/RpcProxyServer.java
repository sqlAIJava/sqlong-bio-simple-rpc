package org.sqlong.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务端 代理层
 */
public class RpcProxyServer {

  private final SayHelloServiceImpl service;

  private final ExecutorService executorService = Executors.newCachedThreadPool();

  public RpcProxyServer(SayHelloServiceImpl service) {
    this.service = service;
  }

  public void publisher(int port) {
    ServerSocket serverSocket = null;

    try {
      serverSocket = new ServerSocket(port);
      while (true) {
        Socket socket = serverSocket.accept();
        executorService.execute(new ProcessorHandler(socket, service));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}