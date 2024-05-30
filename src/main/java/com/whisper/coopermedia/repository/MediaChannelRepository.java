package com.whisper.coopermedia.repository;

import com.whisper.coopermedia.entity.MediaChannel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MediaChannelRepository extends JpaRepository<MediaChannel, Long> {
    Optional<List<MediaChannel>> findByWorkspaceId(long workspaceId);
}
