package com.tom.thrift.hello;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by jinfeng
 * Created at 15/3/27
 */
public class HelloWorldSimpleClient {
    public static final String SERVER_IP = "localhost";

    public static final int SERVER_PORT = 8090;//Thrift server listening port      
    public static final int TIMEOUT = 30000;

    public void startClient(String userName) {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(transport);
            // TProtocol protocol = new TCompactProtocol(transport);
            // TProtocol protocol = new TJSONProtocol(transport);
            IHelloWorldService.Client client = new IHelloWorldService.Client(protocol);
            transport.open();
            String result = client.sayHello(userName);
            System.out.println("Thrift client result =: " + result);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }


    public static void main(String[] args) {
        HelloWorldSimpleClient client = new HelloWorldSimpleClient();
        client.startClient("Tom");
    }

}
