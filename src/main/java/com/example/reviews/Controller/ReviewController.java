package com.example.reviews.Controller;


import com.example.reviews.Models.Entites.Review;
import com.example.reviews.Services.IReview;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final IReview ireview;

    public ReviewController(IReview ireview) {
        this.ireview = ireview;
    }

    @GetMapping("/create")
    public String showCreateReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "createReview";
    }

    @PostMapping("/create")
    public String createReview(@ModelAttribute Review review) {
        ireview.save(review);
        return "redirect:/reviews";
    }

    @GetMapping("/{id}")
    public String showReviewDetails(@PathVariable UUID id, Model model) {
        Review review = ireview.findById(id);
        if (review != null) {
            model.addAttribute("review", review);
            return "reviewDetails";
        } else {
            return "notFound";
        }
    }

    @GetMapping
    public String showAllReviews(Model model) {
        List<Review> reviews = ireview.getAll();
        model.addAttribute("reviews", reviews);
        return "allReviews";
    }

    @GetMapping("/{id}/delete")
    public String deleteReview(@PathVariable UUID id) {
        ireview.delete(id);
        return "redirect:/reviews";
    }

}
