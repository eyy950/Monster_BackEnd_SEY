package com.practice.board.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class MovieController {

    @GetMapping("/top-rated-movies")
    public String getTopRatedMovies(Model model) {
        OkHttpClient client = new OkHttpClient();

        // API 요청 설정
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMmU4OWY5MDA0MjNhMGRiODI3MmU2MTI4OTA1ZDNiZCIsInN1YiI6IjY1YjEwOWViOGMzMTU5MDE1MjMyMGQ4ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.hOI2LuKHRVwCjfl93ecWTd2tBGzBAoaG3M6m48zDnA8")
                .build();

        try {
            // API 호출 및 응답 가져오기
            Response response = client.newCall(request).execute();

            // 응답 데이터를 List<Map>으로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseData = objectMapper.readValue(response.body().string(), Map.class);
            List<Map<String, Object>> movies = (List<Map<String, Object>>) responseData.get("results");

            // 응답 데이터를 모델에 추가
            model.addAttribute("movies", movies);

            // Thymeleaf 템플릿의 경로 반환
            return "top-rated-movies";
        } catch (IOException e) {
            e.printStackTrace();
            return "error"; // 에러가 발생한 경우 에러 페이지로 이동
        }
    }
    @GetMapping("/populartvseries")
    public String getPopularTvSeries(Model model) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/tv/latest")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyMmU4OWY5MDA0MjNhMGRiODI3MmU2MTI4OTA1ZDNiZCIsInN1YiI6IjY1YjEwOWViOGMzMTU5MDE1MjMyMGQ4ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.hOI2LuKHRVwCjfl93ecWTd2tBGzBAoaG3M6m48zDnA8")
                .build();

        try {
            Response response = client.newCall(request).execute();
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseData = objectMapper.readValue(response.body().string(), Map.class);
            List<Map<String, Object>> tvSeries = (List<Map<String, Object>>) responseData.get("results");

            model.addAttribute("populartvseries", tvSeries);

            return "populartvseries";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        }
    }

