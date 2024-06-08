package com.practice.board.controller;

import com.practice.api.service.TmdbTvRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TmdbTvRecommendationController {
	@GetMapping("/index")
    public String index() {
        return "index";
    }

    private final TmdbTvRecommendationService tmdbTvRecommendationService;

    @Autowired
    public TmdbTvRecommendationController(TmdbTvRecommendationService tmdbTvRecommendationService) {
        this.tmdbTvRecommendationService = tmdbTvRecommendationService;
    }

    @GetMapping("/recommend")
    public String recommendTvSeries(@RequestParam String tag, Model model) {
        String tvSeriesRecommendation = tmdbTvRecommendationService.recommendTvSeriesByTag(tag);
        model.addAttribute("tvSeriesRecommendation", tvSeriesRecommendation);
        return "tvSeriesRecommendation"; // tvSeriesRecommendation.html을 템플릿으로 사용하도록 가정
    }
}
