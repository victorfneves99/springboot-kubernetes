package com.victorlabs.bookmarker_api.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victorlabs.bookmarker_api.domain.Bookmark;
import com.victorlabs.bookmarker_api.dto.BookmarkDTO;
import com.victorlabs.bookmarker_api.dto.BookmarksDTO;
import com.victorlabs.bookmarker_api.dto.request.CreateBookmarkerRequest;
import com.victorlabs.bookmarker_api.mapper.BookmarkMapper;
import com.victorlabs.bookmarker_api.repository.BookmarkRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

  private final BookmarkRepository bookmarkRepository;

  @Autowired
  private final BookmarkMapper bookmarkMapper;

  @Transactional(readOnly = true)
  public BookmarksDTO getBookmarks(Integer page) {

    int pageNo = page < 1 ? 0 : page - 1;

    Pageable pageable = PageRequest.of(pageNo, 10, Sort.by("createdAt").descending());

    BookmarksDTO result = bookmarkMapper.toDto(bookmarkRepository.findBookmarks(pageable));

    return result;
  }

  @Transactional(readOnly = true)
  public BookmarksDTO searchBookmarks(String query, Integer page) {

    int pageNo = page < 1 ? 0 : page - 1;

    Pageable pageable = PageRequest.of(pageNo, 10, Sort.by("createdAt").descending());

    BookmarksDTO result = bookmarkMapper.toDto(bookmarkRepository.searchBookmarks(query, pageable));

    BookmarksDTO resulBookmarksProjection = bookmarkMapper
        .toBookmarkProjectionFromBookmarksDTO(bookmarkRepository.findByTitleContainsIgnoreCase(query, pageable));

    return result;
  }

  public BookmarkDTO createBookmarker(CreateBookmarkerRequest request) {

    Bookmark bookmark = new Bookmark(null, request.title(), request.url(), Instant.now());

    Bookmark savedBookmark = bookmarkRepository.save(bookmark);

    return bookmarkMapper.toDtoCreated(savedBookmark);

  }
}
