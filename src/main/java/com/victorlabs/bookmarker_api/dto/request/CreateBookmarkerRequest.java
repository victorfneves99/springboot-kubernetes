package com.victorlabs.bookmarker_api.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

public record CreateBookmarkerRequest(@NotEmpty(message = "Title is required") String title,
        @NotEmpty(message = "Url is required") String url) {
}
