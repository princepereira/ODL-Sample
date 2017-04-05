package org.opendaylight.hello.impl;

import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hello.rev150105.HelloService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hello.rev150105.HelloWorldInput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hello.rev150105.HelloWorldOutput;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hello.rev150105.HelloWorldOutputBuilder;
import org.opendaylight.yangtools.yang.common.RpcResult;
import org.opendaylight.yangtools.yang.common.RpcResultBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Future;

/**
 * Created by calsoft on 5/4/17.
 */
public class HelloWorldImpl implements HelloService{

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldImpl.class);
    @Override
    public Future<RpcResult<HelloWorldOutput>> helloWorld(HelloWorldInput input) {
        LOG.info("prince Received input : {}", input.getName());
        HelloWorldOutputBuilder helloOutput = new HelloWorldOutputBuilder();
        helloOutput.setGreeting("Hello "+input.getName());
        return RpcResultBuilder.success(helloOutput.build()).buildFuture();
    }
}
