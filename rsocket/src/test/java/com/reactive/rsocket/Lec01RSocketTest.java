package com.reactive.rsocket;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.core.RSocketConnector;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Lec01RSocketTest {

    private RSocket rSocket;

    @BeforeAll
    public void setup(){
        this.rSocket = RSocketConnector.create()
                .connect(TcpClientTransport.create("localhost", 6565))
                .block();
    }

    @Test
    public void fireAndForget(){

        Payload payload = DefaultPayload.create("Hello RSocket !");
        Mono<Void> mono = this.rSocket.fireAndForget(payload);

        StepVerifier.create(mono)
                .verifyComplete();
    }
}

