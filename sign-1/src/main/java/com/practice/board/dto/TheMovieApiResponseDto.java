package com.practice.board.dto;

import java.util.List;

public class TheMovieApiResponseDto {

    private List<MovieResult> results;

    public List<MovieResult> getResults() {
        return results;
    }

    public void setResults(List<MovieResult> results) {
        this.results = results;
    }

    // TV 시리즈 검색 결과를 받아오는 메서드 추가
    private List<TVSeriesResult> tvSeriesResults;

    public List<TVSeriesResult> getTvSeriesResults() {
        return tvSeriesResults;
    }

    public void setTvSeriesResults(List<TVSeriesResult> tvSeriesResults) {
        this.tvSeriesResults = tvSeriesResults;
    }
}
