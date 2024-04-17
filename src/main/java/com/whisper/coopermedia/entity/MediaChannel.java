package com.whisper.coopermedia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MediaChannel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // db가 id를 자동 생성하게
    private Long id;
    private String channelName;
    private int userCount;
    // private Long parentId; // 워크스페이스 키
}
