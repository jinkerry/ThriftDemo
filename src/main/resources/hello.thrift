namespace java com.tom.thrift.hello
service  IHelloWorldService {
  string sayHello(1:string username)
}