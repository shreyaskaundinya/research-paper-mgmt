package com.researchpapermgmt.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.researchpapermgmt.enums.UserTypes;
import com.researchpapermgmt.models.Paper;
import com.researchpapermgmt.models.User;
import com.researchpapermgmt.repositories.UserRepository;
import com.researchpapermgmt.security.SessionUser;
import com.researchpapermgmt.services.PaperService;
import com.researchpapermgmt.services.UserService;

@Controller
public class PaperController {

    private PaperService paperService;

    @Autowired
    private UserRepository userRepository;

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
        User currentUser = SessionUser.getUser();

        if (currentUser == null) {
            return "auth/login";
        }

        else if (currentUser.getUserType() != UserTypes.PANEL_MEMBER) {
            return "auth/unauthorized";
        }
        // model.addAttribute("papers", paperService.getAllPapers());

        // System.out.println(id);
        Paper paper1 = paperService.getPaperById(id);
        paper1.setApproved(true);
        paperService.updatePaper(paper1);

        return "redirect:/";
    }

    @GetMapping("/paper/edit/{id}")
    public String editPaperById(@PathVariable Long id, Model model) {
        User currentUser = SessionUser.getUser();

        if (currentUser == null) {
            return "login";
        }

        else if (currentUser.getUserType() != UserTypes.AUTHOR) {
            return "unauthorized";
        }
        model.addAttribute("paper", paperService.getPaperById(id));
        return "paper/update_paper";
    }

    @PostMapping("/paper/edit/{id}")
    public String saveEditPaperById(@PathVariable Long id, @ModelAttribute("paper") Paper paper, Model model, @RequestParam("authors") String authorsInput) {
        User currentUser = SessionUser.getUser();

        if (currentUser == null) {
            return "auth/login";
        }

        else if (currentUser.getUserType() != UserTypes.AUTHOR) {
            return "auth/unauthorized";
        }
        Paper p = paperService.getPaperById(id);
        p.setTitle(paper.getTitle());
        p.setKeywords(paper.getKeywords());
        p.setPaperText(paper.getPaperText());
        

        String[] authorEmails = authorsInput.split(",");
        Collection<String>emails = new ArrayList<>(Arrays.asList(authorEmails));;
        p.setAuthors(userRepository.findByEmailIn(emails));

        paperService.updatePaper(p);
        return "redirect:/";
    }

    @PostMapping("/paper/delete/{id}")
    public String deletePaperById(@PathVariable Long id, Model model) {
        User currentUser = SessionUser.getUser();

        if (currentUser == null) {
            return "auth/login";
        }

        else if (currentUser.getUserType() != UserTypes.AUTHOR) {
            return "auth/unauthorized";
        }
        paperService.deletePaperById(id);
        return "redirect:/";
    }

    @PostMapping("/paper/create")
    public String createPaper(@RequestParam String title, @RequestParam String keywords, @RequestParam String authors, @RequestParam String paperText) {
        
        User currentUser = SessionUser.getUser();

        if (currentUser == null) {
            return "auth/login";
        }

        else if (currentUser.getUserType() != UserTypes.AUTHOR) {
            return "auth/unauthorized";
        }
        
        // model.addAttribute("papers", paperService.getAllPapers());
        Paper p = new Paper();
        //p.setId(paper.getId());
        p.setApproved(false);
        p.setTitle(title);
        p.setKeywords(keywords);
        p.setPaperText(paperText);
        // TODO : split the author names and find by name and add that
        // p.setAuthors(new Set<Author>());
        String[] authorEmails = authors.split(",");
        Collection<String>emails = new ArrayList<>(Arrays.asList(authorEmails));;
        p.setAuthors(userRepository.findByEmailIn(emails));

        paperService.createPaper(p);
        return "redirect:/paper";
    }

    @GetMapping("/paper/create")
    public String createPaperView(Model model) {
        
        User currentUser = SessionUser.getUser();

        if (currentUser == null) {
            return "auth/login";
        }

        else if (currentUser.getUserType() != UserTypes.AUTHOR) {
            return "auth/unauthorized";
        }
        
        // model.addAttr ibute("papers", paperService.getAllPapers());
        return "paper/create_paper";
    }

    // TODO : Assign panels to papers randomly
    

}
