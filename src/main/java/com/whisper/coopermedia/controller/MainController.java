package com.whisper.coopermedia.controller;

import com.whisper.coopermedia.dto.MediaChannelDto;
import com.whisper.coopermedia.entity.MediaChannel;
import com.whisper.coopermedia.service.MediaChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cooper-media")
public class MainController {
    @Autowired
    private MediaChannelService mediaChannelService;

    // GET 모든 mediachannel 리스트
    @GetMapping("/mediachannels")
    public ResponseEntity<List<MediaChannel>> index() {
        List<MediaChannel> list = mediaChannelService.getChannelList();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    // GET workspace에 속한 mediachannel 리스트
    @GetMapping("/mediachannels/{workspaceId}")
    public ResponseEntity<List<MediaChannel>> show(@PathVariable Long workspaceId) {
        List<MediaChannel> list = mediaChannelService.getChannelList(workspaceId);

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    // POST
    @PostMapping("/mediachannels")
    public ResponseEntity<MediaChannel> create(@RequestBody MediaChannelDto dto) {
        log.info(dto.toString());
        MediaChannel created = mediaChannelService.create(dto);

        return created != null ?
                ResponseEntity.status(HttpStatus.CREATED).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // PATCH
    @PatchMapping("/mediachannels/{id}")
    public ResponseEntity<MediaChannel> update(@PathVariable Long id, @RequestBody MediaChannelDto dto) throws Exception {
        log.info(dto.toString());
        MediaChannel updated = mediaChannelService.update(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    // DELETE
    @DeleteMapping("/mediachannels/{id}")
    public ResponseEntity<MediaChannel> delete(@PathVariable Long id) throws Exception {
        MediaChannel delete = mediaChannelService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
