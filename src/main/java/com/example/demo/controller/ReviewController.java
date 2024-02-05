package com.example.demo.controller;


import com.example.demo.Services.ReviewService;
import com.example.demo.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/reviews")

public class ReviewController {

    private final ReviewService reviewService;


    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/create")
    public String showCreateReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "createReview";
    }

    @PostMapping("/create")
    public String createReview(@ModelAttribute Review review) {
        reviewService.saveReview(review);
        return "redirect:/reviews";
    }

    @GetMapping("/{id}")
    public String showReviewDetails(@PathVariable UUID id, Model model) {
        Review review = reviewService.getReviewById(id);
        if (review != null) {
            model.addAttribute("review", review);
            return "reviewDetails";
        } else {
            return "notFound";
        }
    }

    @GetMapping
    public String showAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "allReviews";
    }

    @GetMapping("/{id}/delete")
    public String deleteReview(@PathVariable UUID id) {
        reviewService.deleteReview(id);
        return "redirect:/reviews";
    }


    @PostMapping("/{idReview}/{idModerator}/claim")
    public String claimReview(@PathVariable UUID idReview,@PathVariable Long idModerator) {
        reviewService.claimReview(idReview,idModerator);
        return "redirect:/reviews";
    }

}

