package com.victorlabs.bookmarker_api.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.victorlabs.bookmarker_api.domain.Bookmark;
import com.victorlabs.bookmarker_api.dto.BookmarkDTO;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query("select new com.victorlabs.bookmarker_api.dto.BookmarkDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b")
    Page<BookmarkDTO> findBookmarks(Pageable pageable);

}
