package com.victorlabs.bookmarker_api.dto.projections;

import java.time.Instant;

public interface BookmarkerProjection {
    Long getId();
    String getTitle();
    String getUrl();
    Instant getCreatedAt();

}
