package com.reactive.rsocket.Service;

import io.rsocket.ConnectionSetupPayload;
import io.rsocket.RSocket;
import io.rsocket.SocketAcceptor;
import reactor.core.publisher.Mono;

public class SocketAcceptoImple implements SocketAcceptor {

    // This interface is for the method fireAndForget() to be get called
    @Override
    public Mono<RSocket> accept(ConnectionSetupPayload connectionSetupPayload, RSocket rSocket) {

        System.out.println("SocketAcceptorImpl-accept method");
        // we are just calling our implementation of RSocket i.e.calling MathService
        return  Mono.fromCallable(MathService ::new);
    }
}
