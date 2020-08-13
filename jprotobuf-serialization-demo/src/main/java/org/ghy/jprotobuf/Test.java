package org.ghy.jprotobuf;

import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;

public class Test {
    public static void main(String[] args) {
        Codec<SimpleTest> codec = ProtobufProxy.create(SimpleTest.class);
        SimpleTest simpleTest = new SimpleTest();
        simpleTest.setName("abc");
        simpleTest.setAge(100);
        simpleTest.setMale(false);

        Codec<SimpleTest2> decode = ProtobufProxy.create(SimpleTest2.class);
        try {
            byte[] bb = codec.encode(simpleTest);
            SimpleTest2 newSimpleTest = decode.decode(bb);
            System.out.println(newSimpleTest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
