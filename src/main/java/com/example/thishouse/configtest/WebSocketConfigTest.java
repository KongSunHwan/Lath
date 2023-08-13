package com.example.thishouse.configtest;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfigTest implements WebSocketMessageBrokerConfigurer {




    //SocketJs Fallback 이용해 노출할 STOMP endPoint
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        /*
        *      http://localhost:8080/endpoint/~~~
        * */
        stompEndpointRegistry.addEndpoint("/stomp/chat").setAllowedOriginPatterns("*").withSockJS();
    }



    //메시지 브로커에 관련된 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        //ApplicationDestinationPrefixes 를 지정하면 대상 헤더가 시작되는 STOMP 메시지는 해당 클래스의 메서드로 라우팅
        /*
         *   클라이언트에서 데이터를 보낼때 요청헤더에 ex) /pub/message
         *   컨트롤러에서는 /pub 제외 한 경로 @MessageMapping("/message/)
         * */
        registry.setApplicationDestinationPrefixes("/pub");

        registry.enableSimpleBroker("/sub");

    }
}
