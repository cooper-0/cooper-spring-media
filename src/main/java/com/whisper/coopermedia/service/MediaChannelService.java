package com.whisper.coopermedia.service;

import com.whisper.coopermedia.dto.MediaChannelDto;
import com.whisper.coopermedia.entity.MediaChannel;
import com.whisper.coopermedia.repository.MediaChannelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class MediaChannelService {
    @Autowired
    private MediaChannelRepository mediaChannelRepository;

    public MediaChannel loadChannelById(Long id) throws IllegalArgumentException{
        return mediaChannelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 채널"));
    }

    // 모든 채널 리스트
    public List<MediaChannel> getChannelList() {
        return mediaChannelRepository.findAll();
    }

    // 워크스페이스에 속한 음성채널 리스트
    public List<MediaChannel> getChannelList(long workspaceId) {
        return mediaChannelRepository.findByWorkspaceId(workspaceId).orElse(null);
    }

    public MediaChannel show(Long id) throws Exception {
        try {
            MediaChannel mediaChannel = loadChannelById(id);
            log.info(mediaChannel.toString());
            return mediaChannel;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        }
    }

//    @Transactional
    public MediaChannel create(MediaChannelDto dto) {
        MediaChannel mediaChannel = dto.toEntity();

        if (mediaChannel.getId() != null) {
            return null;
        }

        return mediaChannelRepository.save(mediaChannel);
    }

    public MediaChannel update(Long id, MediaChannelDto dto) throws Exception {
        try {
            MediaChannel mediaChannel = loadChannelById(id);
            log.info(mediaChannel.toString());
            mediaChannelRepository.save(mediaChannel);

            return mediaChannel;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        }
    }

    public MediaChannel delete(Long id) throws Exception {
        try {
            MediaChannel mediaChannel = loadChannelById(id);
            log.info(mediaChannel.toString());
            mediaChannelRepository.delete(mediaChannel);

            return mediaChannel;
        } catch (Exception e) {
            log.error(e.toString());
            throw e;
        }
    }
}
