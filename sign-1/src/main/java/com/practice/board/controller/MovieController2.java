package com.practice.board.controller;

import com.practice.board.dto.TheMovieApiService;
import com.practice.board.dto.TheMovieApiResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController2 {

    private final TheMovieApiService movieApiService;

    @Autowired
    public MovieController2(TheMovieApiService movieApiService) {
        this.movieApiService = movieApiService;
    }

    @GetMapping("/byGenre")
    public TheMovieApiResponseDto getMoviesByGenre(@RequestParam int genreId) {
        try {
            return movieApiService.getMoviesByGenre(genreId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/byTitle")
    public TheMovieApiResponseDto getMoviesByTitle(@RequestParam String title) {
        try {
            return movieApiService.getMoviesByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 새로운 엔드포인트 추가 (TV 시리즈 검색 - 제목)
    @GetMapping("/tvSeries/byTitle")
    public TheMovieApiResponseDto getTVSeriesByTitle(@RequestParam String title) {
        try {
            return movieApiService.getTVSeriesByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 새로운 엔드포인트 추가 (TV 시리즈 검색 - 장르)
    @GetMapping("/tvSeries/byGenre")
    public TheMovieApiResponseDto getTVSeriesByGenre(@RequestParam int genreId) {
        try {
            return movieApiService.getTVSeriesByGenre(genreId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}