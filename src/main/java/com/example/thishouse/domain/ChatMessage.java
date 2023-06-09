package com.example.thishouse.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ChatMessage {
    private String sender; // 송신자
    private String content; // 메시지 내용
    private LocalDateTime timestamp; // 타임스탬프
}
