package com.whisper.coopermedia.controller;

import com.whisper.coopermedia.dto.MediaChannelDto;
import com.whisper.coopermedia.entity.MediaChannel;
import com.whisper.coopermedia.service.MediaChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalTime;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cooper-media")
public class TestController {
    @Autowired
    private MediaChannelService mediaChannelService;

    // GET
    @GetMapping("/test")
    public String index(Model model) {
        List<MediaChannel> list = mediaChannelService.getChannelList();

        model.addAttribute("channelList", list);

        return "content/index";
    }

    @GetMapping("/test/create")
    public String create() {
        MediaChannelDto dto = new MediaChannelDto();
        dto.setChannelName("음성채널 " + LocalTime.now());

        mediaChannelService.create(dto);

        return "redirect:/";
    }
}
