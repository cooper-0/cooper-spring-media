package com.whisper.coopermedia.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "media_channels")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MediaChannel extends BaseEntity implements AutoCloseable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // db가 id를 자동 생성하게
    private Long id;
    private String channelName;
    private int userCount;

    @Override
    public void close() throws Exception {

    }
    // private Long parentId; // 워크스페이스 키
}
