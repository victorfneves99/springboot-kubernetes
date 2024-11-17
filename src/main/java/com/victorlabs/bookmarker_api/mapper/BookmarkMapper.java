package com.victorlabs.bookmarker_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import com.victorlabs.bookmarker_api.domain.Bookmark;
import com.victorlabs.bookmarker_api.dto.BookmarkDTO;
import com.victorlabs.bookmarker_api.dto.BookmarksDTO;
import com.victorlabs.bookmarker_api.dto.projections.BookmarkerProjection;


@Mapper(componentModel = "spring")
public interface BookmarkMapper {

    @Mapping(target = "data", source = "content")
    @Mapping(target = "totalElements", source = "totalElements")
    @Mapping(target = "totalPages", source = "totalPages")
    @Mapping(target = "currentPage", expression = "java(bookmark.getNumber() + 1)")
    @Mapping(target = "isFirst", source = "first")
    @Mapping(target = "isLast",source = "last")
    @Mapping(target = "hasNext",  expression = "java(bookmark.hasNext())")
    @Mapping(target = "hasPrevious", expression = "java(bookmark.hasPrevious())")
    BookmarksDTO toDto(Page<BookmarkDTO> bookmark);


    @Mapping(target = "data", source = "content")
    @Mapping(target = "totalElements", source = "totalElements")
    @Mapping(target = "totalPages", source = "totalPages")
    @Mapping(target = "currentPage", expression = "java(bookmark.getNumber() + 1)")
    @Mapping(target = "isFirst", source = "first")
    @Mapping(target = "isLast",source = "last")
    @Mapping(target = "hasNext",  expression = "java(bookmark.hasNext())")
    @Mapping(target = "hasPrevious", expression = "java(bookmark.hasPrevious())")
    BookmarksDTO toBookmarkProjectionFromBookmarksDTO(Page<BookmarkerProjection> bookmark);
    
    Bookmark toEntity(BookmarkDTO bookmarkDTO);
}