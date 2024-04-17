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
    private String channelName;
    private int userCount;

    public MediaChannel toEntity() {
        return new MediaChannel(id, channelName, userCount);
    }
}
