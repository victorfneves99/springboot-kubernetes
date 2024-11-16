package com.victorlabs.bookmarker_api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookmarksDTO {

    private List<BookmarkDTO> data;
    private long totalElements;
    private int totalPages;
    private int currentPage;
    @JsonProperty("first")
    private boolean isFirst;
    @JsonProperty("last")
    private boolean isLast;
    private boolean hasNext;
    private boolean hasPrevious;

}
