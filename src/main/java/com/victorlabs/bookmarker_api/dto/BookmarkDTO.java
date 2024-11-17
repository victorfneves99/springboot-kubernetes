package com.victorlabs.bookmarker_api.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class BookmarkDTO {
    private Long id;
    private String title;
    private String url;
    private Instant createdAt;

}