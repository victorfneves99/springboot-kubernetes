package com.victorlabs.bookmarker_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victorlabs.bookmarker_api.domain.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

}
