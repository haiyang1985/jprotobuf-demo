package org.ghy.jprotobuf.rpc.api;

import com.baidu.jprotobuf.pbrpc.ProtobufRPC;

public interface EchoService {
    @ProtobufRPC(serviceName = "echoService", onceTalkTimeout = 200)
    EchoInfo echo(EchoInfo info);
}
