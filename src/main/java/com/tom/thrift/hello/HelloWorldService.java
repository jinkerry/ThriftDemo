package com.tom.thrift.hello;

import org.apache.thrift.TException;

/**
 * Created by jinfeng
 * Created at 15/3/27
 */
public class HelloWorldService implements IHelloWorldService.Iface{

    public String sayHello(String username) throws TException {
        return "Hi, " + username + ", Welcome to the Thrift world, enjoy it!";
    }
}
