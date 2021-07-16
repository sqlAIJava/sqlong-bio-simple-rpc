package org.sqlong.rpc;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("client start");

        RpcProxyClient rpcProxyClient = new RpcProxyClient();

        ISayHelloService iSayHelloService = rpcProxyClient.clientProxy(ISayHelloService.class, "localhost", 9090);
        // 验证远程调用 say();
        String sayRet = iSayHelloService.say("[client] hello server");
        System.out.println("client receive response by say : " + sayRet);
        // 验证远程调用 saveUser();
        String saveUser = iSayHelloService.saveUser(UserDTO.builder().userName("hello server two").build());
        System.out.println("client receive response by save user : " + saveUser);

    }
}
