package com.sjf.open;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.Objects;

/**
 * Thrift的客户端
 *
 * @author gaozhirong
 * @create 2018-01-17 下午9:18
 **/
public class CalculatorClient {

    private static int port = 9090;
    private static String ip = "localhost";
    private static CalculatorService.Client client;
    private static TTransport transport;
    /**
     * 创建 TTransport
     * @return
     */
    public static TTransport createTTransport(){
        TTransport transport = new TSocket(ip, port);
        return transport;
    }
    /**
     * 开启 TTransport
     * @param transport
     * @throws TTransportException
     */
    public static void openTTransport(TTransport transport) throws TTransportException {
        if(Objects.equals(transport, null)){
            return;
        }
        transport.open();
    }
    /**
     * 关闭 TTransport
     * @param transport
     */
    public static void closeTTransport(TTransport transport){
        if(Objects.equals(transport, null)){
            return;
        }
        transport.close();
    }
    /**
     * 创建客户端
     * @return
     */
    public static CalculatorService.Client createClient(TTransport transport){
        if(Objects.equals(transport, null)){
            return null;
        }
        TProtocol protocol = new TBinaryProtocol(transport);
        if(Objects.equals(protocol, null)){
            return null;
        }
        CalculatorService.Client client = new CalculatorService.Client(protocol);
        return client;
    }
    public static void main(String[] args) {
        try {
            // 创建 TTransport
            transport = createTTransport();
            // 开启 TTransport
            openTTransport(transport);
            // 创建客户端
            client = createClient(transport);
            // 调用服务
            if(Objects.equals(client, null)){
                System.out.println("创建客户端失败...");
                return;
            }
            System.out.println(client.add(100, 200));
        } catch (TException e) {
            e.printStackTrace();
        }
        finally {
            // 关闭 TTransport
            closeTTransport(transport);
        }
    }

}
