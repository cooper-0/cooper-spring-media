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
public class MainController {
    @Autowired
    private MediaChannelService mediaChannelService;

    // GET
    @GetMapping("/mediachannles")
    public ResponseEntity<List<MediaChannel>> index() {
        List<MediaChannel> list = mediaChannelService.getChannelList();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/mediachannles/{id}")
    public ResponseEntity<MediaChannel> show(@PathVariable Long id) throws Exception {
        MediaChannel mediaChannel = mediaChannelService.show(id);

        return ResponseEntity.status(HttpStatus.OK).body(mediaChannel);
    }

    // POST
    @PostMapping("/mediachannles")
    public ResponseEntity<MediaChannel> create(@RequestBody MediaChannelDto dto) {
        log.info(dto.toString());
        MediaChannel created = mediaChannelService.create(dto);

        return created != null ?
                ResponseEntity.status(HttpStatus.CREATED).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
