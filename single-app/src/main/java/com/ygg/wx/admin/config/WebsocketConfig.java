package com.ygg.wx.admin.config;

import com.ygg.wx.admin.common.util.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author akhan
 * @description websocket配置
 * @date 17:41 2018-12-21
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
    @Value("${server.origin-host}")
    private String host;


    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/sub")
                .setAllowedOrigins(host)
                .withSockJS()
                .setSessionCookieNeeded(false)
                .setWebSocketEnabled(false);
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/op_msg", "/accurate");
        //registry.setUserDestinationPrefix("/accurate/");
    }

//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.interceptors(new ChannelInterceptorAdapter(){
//            @Override
//            public Message<?> preSend(Message<?> message, MessageChannel channel) {
//                StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
//
//                if(StompCommand.CONNECT.equals(accessor.getCommand())) {
//                    List<String> list = accessor.getNativeHeader(CommonConstant.REQ_HEADER);
//
//                    if (list == null || list.isEmpty()) {
//                        throw new BusinessException("websocket 鉴权失败");
//                    }
//
//                    String token = list.get(0);
//                    if (StringUtils.isNotBlank(token)) {
//
//
//                        jwtTokenUtils.isTokenExpired(token);
//                    }
//
//                    throw new BusinessException("websocket 鉴权失败");
//                }
//
//                return message;
//            }
//        });
//    }
}
