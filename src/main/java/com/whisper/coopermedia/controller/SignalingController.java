package com.whisper.coopermedia.controller;

import com.whisper.coopermedia.dto.SignalMessage;
import com.whisper.coopermedia.dto.SimpleUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SignalingController {
    /**
     * offer 정보를 주고 받기 위한 websocket
     * @param roomId 룸 아이디
     * @param key 각 요청하는 캠의 key
     */
    @MessageMapping("/peer/offer/{key}/{roomId}")
    @SendTo("/topic/peer/offer/{key}/{roomId}")
    public String PeerHandleOffer(@Payload String offer, @DestinationVariable(value = "roomId") String roomId,
                                  @DestinationVariable(value = "key") String key) {
        log.info("[OFFER] {} : {}", key, offer);
        return offer;
    }

    /**
     * iceCandidate 정보를 주고 받기 위한 webSocket
     * @param roomId 룸 아이디
     * @param key 각 요청하는 캠의 key
     */
    @MessageMapping("/peer/iceCandidate/{key}/{roomId}")
    @SendTo("/topic/peer/iceCandidate/{key}/{roomId}")
    public String PeerHandleIceCandidate(@Payload String candidate, @DestinationVariable(value = "roomId") String roomId,
                                         @DestinationVariable(value = "key") String key) {
        log.info("[ICECANDIDATE] {} : {}", key, candidate);
        return candidate;
    }

    /**
     *
     */
    @MessageMapping("/peer/answer/{key}/{roomId}")
    @SendTo("/topic/peer/answer/{key}/{roomId}")
    public String PeerHandleAnswer(@Payload String answer, @DestinationVariable(value = "roomId") String roomId,
                                   @DestinationVariable(value = "key") String key) {
        log.info("[ANSWER] {} : {}", key, answer);
        return answer;
    }

    /**
     * camKey 를 받기위해 신호를 보내는 webSocket
     */
    @MessageMapping("/call/key/{roomId}")
    @SendTo("/topic/call/key/{roomId}")
    public String callKey(@Payload String message, @DestinationVariable(value = "roomId") String roomId) {
        log.info("[Key] : {}", message);
        return message;
    }

    /**
     * 자신의 camKey 를 모든 연결된 세션에 보내는 webSocket
     */
    @MessageMapping("/send/key/{roomId}")
    @SendTo("/topic/send/key/{roomId}")
    public String sendKey(@Payload String message, @DestinationVariable(value = "roomId") String roomId) {
        return message;
    }

    /**
     * 연결 종료
     */
    @MessageMapping("/delete/key/{roomId}")
    @SendTo("/topic/delete/key/{roomId}")
    public String deleteKey(@Payload String message, @DestinationVariable(value = "roomId") String roomId) {
        return message;
    }
}
