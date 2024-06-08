package com.practice.api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TmdbTvRecommendationService {

    @Value("${tmdb.api.key}")
    private String tmdbApiKey;

    private final RestTemplate restTemplate;

    public TmdbTvRecommendationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String recommendTvSeriesByTag(String tag) {
        try {
            String apiUrl = "https://api.themoviedb.org/3/discover/tv?api_key=" + tmdbApiKey + "&with_genres=" + tag;
            return restTemplate.getForObject(apiUrl, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to fetch TV series recommendations.";
        }
    }
}
