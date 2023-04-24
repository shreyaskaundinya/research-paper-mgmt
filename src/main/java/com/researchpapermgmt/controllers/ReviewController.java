package com.researchpapermgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.researchpapermgmt.models.Review;
import com.researchpapermgmt.services.PaperService;
import com.researchpapermgmt.services.ReviewService;

@Controller
public class ReviewController {
    private ReviewService reviewService;
    private PaperService paperService;

    @GetMapping("/review/add/{paper_id}")
    public String ReviewPaperGet(Model model, @PathVariable long paper_id) {

        model.addAttribute("paper_id", paper_id);
        model.addAttribute("paper", paperService.getPaperById(paper_id));
        return "review/create-review.html";
    }

    @PostMapping("/review/add/{paper_id}")
    public String ReviewPaperPost(@PathVariable long paper_id, @ModelAttribute("review") Review review) {
        // TODO : paper service and panel service
        // Check if review for paper is by assigned panel
        review.setPaper(paperService.getPaperById(paper_id));
        // review.setPanel(null);
        reviewService.createReview(review);
        return "redirect:/";
    }

    @GetMapping("/review/get/{paper_id}")
    public String GetPaperReviews() {
        // TODO
        return "";
    }
}
