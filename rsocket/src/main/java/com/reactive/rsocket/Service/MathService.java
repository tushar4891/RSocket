package com.reactive.rsocket.Service;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Mono;

//This is our implementation of RSocket.
public class MathService implements RSocket {

    // client is going to call this method
    @Override
    public Mono<Void> fireAndForget(Payload payload) {

        System.out.println("Receiving ...." + payload.getDataUtf8());
        return Mono.empty();
    }
}

