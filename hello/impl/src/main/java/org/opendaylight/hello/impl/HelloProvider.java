/*
 * Copyright © 2016 Copyright(c) Yoyodyne, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.hello.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareBroker;
import org.opendaylight.controller.sal.binding.api.BindingAwareProvider;
import org.opendaylight.controller.sal.binding.api.RpcConsumerRegistry;
import org.opendaylight.controller.sal.binding.api.RpcProviderRegistry;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.hello.rev150105.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.opendaylight.controller.sal.binding.api.BindingAwareBroker.RpcRegistration;

public class HelloProvider {

    private static final Logger LOG = LoggerFactory.getLogger(HelloProvider.class);
    RpcRegistration<HelloService>  helloService;

    private final DataBroker dataBroker;
    private final RpcProviderRegistry rpcRegistry;

    public HelloProvider(final DataBroker dataBroker, final RpcProviderRegistry rpcRegistry) {
        this.dataBroker = dataBroker;
        this.rpcRegistry = rpcRegistry;
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        LOG.info("HelloProvider Session Initiated");
        helloService = rpcRegistry.addRpcImplementation(HelloService.class, new HelloWorldImpl());
        if (rpcRegistry == null) {
            LOG.info("prince rpcRegistry null");
        } else {
            LOG.info("prince rpcRegistry not null");
        }
        if (helloService == null) {
            LOG.info("prince helloService null");
        } else {
            LOG.info("prince helloService not null");
        }
    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    public void close() {
        if (helloService != null) {
            helloService.close();
        }
        LOG.info("HelloProvider Closed");
    }

}