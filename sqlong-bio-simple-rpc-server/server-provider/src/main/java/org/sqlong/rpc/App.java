package org.sqlong.rpc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "server start" );

        RpcProxyServer proxyServer = new RpcProxyServer(new SayHelloServiceImpl());
        proxyServer.publisher(9090);

        // socket accept() 会一直阻塞 导致之后不被打印， bio 的缺陷
        System.out.println( "server ok by 9090" );
    }
}
