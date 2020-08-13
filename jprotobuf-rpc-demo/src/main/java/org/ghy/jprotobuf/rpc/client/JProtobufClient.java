package org.ghy.jprotobuf.rpc.client;

import com.baidu.jprotobuf.pbrpc.client.ProtobufRpcProxy;
import com.baidu.jprotobuf.pbrpc.transport.RpcClient;
import org.ghy.jprotobuf.rpc.api.EchoInfo;
import org.ghy.jprotobuf.rpc.api.EchoService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JProtobufClient {
    public static void main(String[] args) throws Exception {
        RpcClient client = new RpcClient();
        ProtobufRpcProxy<EchoService> proxy = new ProtobufRpcProxy<EchoService>(client, EchoService.class);
        proxy.setPort(1031);

        EchoService echoService = proxy.proxy();
        while (true) {
            System.out.print("> ");
            String input = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)).readLine();
            if (input == null || input.length() == 0) {
                continue;
            }
            if (input.equals("quit")) {
                break;
            }
            try {
                EchoInfo request = new EchoInfo();
                request.setMessage(input);
                EchoInfo response = echoService.echo(request);
                System.out.println(response.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
