package com.practice.board.dto;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;

@Service
public class TheMovieApiService {

    private static final String API_KEY = "22e89f900423a0db8272e6128905d3bd";

    // 영화 - 장르 검색
    public TheMovieApiResponseDto getMoviesByGenre(int genreId) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String genreStringId = Integer.toString(genreId);

        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "https://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY +
                        "&language=ko-KR&sort_by=popularity.desc&include_adult=false&include_video=false&page=1" +
                        "&primary_release_date.gte=2000-01-01&primary_release_date.lte=2100-12-31&vote_average.gte=6" +
                        "&with_genres=" + genreStringId,
                HttpMethod.GET, httpEntity, String.class);

        Gson gson = new Gson();
        return gson.fromJson(responseEntity.getBody(), TheMovieApiResponseDto.class);
    }

    // 영화 - 제목 검색
    public TheMovieApiResponseDto getMoviesByTitle(String title) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "https://api.themoviedb.org/3/search/movie?api_key=" + API_KEY +
                        "&language=ko-KR&query=" + title + "&page=1&include_adult=false",
                HttpMethod.GET, httpEntity, String.class);

        Gson gson = new Gson();
        return gson.fromJson(responseEntity.getBody(), TheMovieApiResponseDto.class);
    }

    // TV 시리즈 - 제목 검색
    public TheMovieApiResponseDto getTVSeriesByTitle(String title) throws Exception {
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    "https://api.themoviedb.org/3/search/tv?api_key=" + API_KEY +
                            "&language=ko-KR&query=" + title + "&page=1&include_adult=false",
                    HttpMethod.GET, httpEntity, String.class);

            Gson gson = new Gson();
            return gson.fromJson(responseEntity.getBody(), TheMovieApiResponseDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // 예외 다시 던지기
        }
    }

    // TV 시리즈 - 장르 검색
    public TheMovieApiResponseDto getTVSeriesByGenre(int genreId) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String genreStringId = Integer.toString(genreId);

        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "https://api.themoviedb.org/3/discover/tv?api_key=" + API_KEY +
                        "&language=ko-KR&sort_by=popularity.desc&include_adult=false&include_video=false&page=1" +
                        "&with_genres=" + genreStringId,
                HttpMethod.GET, httpEntity, String.class);

        Gson gson = new Gson();
        return gson.fromJson(responseEntity.getBody(), TheMovieApiResponseDto.class);
    }
}
