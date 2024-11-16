package com.victorlabs.bookmarker_api.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victorlabs.bookmarker_api.dto.BookmarkDTO;
import com.victorlabs.bookmarker_api.dto.BookmarksDTO;
import com.victorlabs.bookmarker_api.service.BookmarkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

  private final BookmarkService bookmarkService;

  @GetMapping
  public ResponseEntity<BookmarksDTO> getBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page,
      @RequestParam(name = "itens", defaultValue = "1") Integer itens) {
    return ResponseEntity.ok().body(bookmarkService.getBookmarks(page, itens));
  }

}
