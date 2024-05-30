package com.whisper.coopermedia.dto;

import com.whisper.coopermedia.entity.MediaChannel;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MediaChannelDto {
    private Long id;
    private Long workspaceId;
    private String channelName;
    private int userCount;

    public MediaChannel toEntity() {
        return MediaChannel.builder()
                .id(id)
                .workspaceId(workspaceId)
                .channelName(channelName)
                .userCount(userCount)
                .build();
    }
}
