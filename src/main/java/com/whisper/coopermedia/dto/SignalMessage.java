package com.whisper.coopermedia.dto;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SignalMessage {
//    private String from; // 보내는 유저 UUID
//    private String type; // 메시지 타입
//    private Object candidate; // 상태
//    private Object sdp; // sdp 정보

    private String key;
    private Object body;
}