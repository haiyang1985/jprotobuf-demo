package org.ghy.jprotobuf.rpc.service;

import com.baidu.jprotobuf.pbrpc.transport.RpcServer;
import org.ghy.jprotobuf.rpc.api.EchoServiceImpl;

public class JProtobufService {
    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        EchoServiceImpl echoService = new EchoServiceImpl();
        server.registerService(echoService);
        server.start(1031);
    }
}
