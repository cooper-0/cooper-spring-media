package com.whisper.coopermedia.service;

import com.whisper.coopermedia.dto.MediaChannelDto;
import com.whisper.coopermedia.entity.MediaChannel;
import com.whisper.coopermedia.repository.MediaChannelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MediaChannelService {
    @Autowired
    private MediaChannelRepository mediaChannelRepository;

    public List<MediaChannel> getChannelList() {
        // 나중에 워크스페이스에 속한 음성채널만 가져오게
        return mediaChannelRepository.findAll();
    }

    public MediaChannel show(Long id) {
        return mediaChannelRepository.findById(id).orElse(null);
    }

    public MediaChannel create(MediaChannelDto dto) {
        MediaChannel mediaChannel = dto.toEntity();

        if (mediaChannel.getId() != null) {
            return null;
        }

        return mediaChannelRepository.save(mediaChannel);
    }
}
