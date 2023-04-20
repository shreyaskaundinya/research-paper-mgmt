package com.researchpapermgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.researchpapermgmt.models.Paper;
import com.researchpapermgmt.services.PaperService;

@Controller
public class PaperController {

    private PaperService paperService;

    public PaperController(PaperService paperService) {
        super();
        this.paperService = paperService;
    }

    @GetMapping("/paper")
    public String home(Model model) {
        model.addAttribute("papers", paperService.getAllPapers());
        return "paper/papers.html";
    }

    @PostMapping("/paper/approve/{id}")
    public String approvePaperById(@PathVariable Long id,
            Model model) {
        // model.addAttribute("papers", paperService.getAllPapers());

        // System.out.println(id);
        Paper paper1 = paperService.getPaperById(id);
        paper1.setApproved(true);
        paperService.updatePaper(paper1);

        return "redirect:/";
    }

    @GetMapping("/paper/edit/{id}")
    public String editPaperById(@PathVariable Long id, Model model) {
        model.addAttribute("paper", paperService.getPaperById(id));
        return "paper/update_paper";
    }

    @PostMapping("/paper/edit/{id}")
    public String saveEditPaperById(@PathVariable Long id, @ModelAttribute("paper") Paper paper, Model model) {

        Paper p = paperService.getPaperById(id);
        p.setTitle(paper.getTitle());
        p.setKeywords(paper.getKeywords());
        p.setPaperText(paper.getPaperText());
        p.setAuthors(paper.getAuthors());

        paperService.updatePaper(p);
        return "redirect:/";
    }

    @PostMapping("/paper/delete/{id}")
    public String deletePaperById(@PathVariable Long id, Model model) {
        paperService.deletePaperById(id);
        return "redirect:/";
    }

    @PostMapping("/paper/create")
    public String createPaper(@ModelAttribute("paper") Paper paper) {
        // model.addAttribute("papers", paperService.getAllPapers());
        Paper p = new Paper();
        p.setId(paper.getId());
        p.setApproved(false);
        p.setTitle(paper.getTitle());
        p.setKeywords(paper.getKeywords());
        p.setPaperText(paper.getPaperText());
        // TODO : split the author names and find by name and add that
        // p.setAuthors(new Set<Author>());

        paperService.createPaper(p);
        return "redirect:/paper";
    }

    @GetMapping("/paper/create")
    public String createPaperView(Model model) {
        // model.addAttr ibute("papers", paperService.getAllPapers());
        return "paper/create_paper";
    }

}
