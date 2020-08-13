package org.ghy.jprotobuf.rpc.api;

import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

public class EchoInfo {
    @Protobuf
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
