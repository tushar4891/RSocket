package com.reactive.rsocket;

import com.reactive.rsocket.Service.SocketAcceptoImple;
import io.rsocket.ConnectionSetupPayload;
import io.rsocket.RSocket;
import io.rsocket.SocketAcceptor;
import io.rsocket.core.RSocketServer;
import io.rsocket.transport.netty.server.CloseableChannel;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.publisher.Mono;

public class Server {
    public static void main(String[] args) {
        RSocketServer rSocketServer = RSocketServer.create(new SocketAcceptoImple());
        CloseableChannel closeableChannel = rSocketServer.bindNow(TcpServerTransport.create(6565));

        //keep listening
        closeableChannel.onClose().block();
    }
}
