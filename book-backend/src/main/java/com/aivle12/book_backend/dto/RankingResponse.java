package com.aivle12.book_backend.dto;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class RankingResponse {
    private List<BookResponse> viewCount;
    private List<BookResponse> pubDate;
    private List<BookResponse> rating;
}
