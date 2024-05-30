package com.whisper.coopermedia.dto;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SimpleUser {
    private String name;
    private long id;
    private Object candidate;
}
