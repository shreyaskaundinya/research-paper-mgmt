package com.researchpapermgmt.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.researchpapermgmt.models.Paper;
import com.researchpapermgmt.repositories.PaperRepository;
import com.researchpapermgmt.services.PaperService;

@Service
public class PaperServiceImpl implements PaperService {

    private PaperRepository paperRepository;

    public PaperServiceImpl(PaperRepository paperRepository) {
        super();
        this.paperRepository = paperRepository;
    }

    public List<Paper> getAllPapers() {
        // System.out.println("get all papers " + paperRepository.findAll());
        return paperRepository.findAll();
    }

    public Paper createPaper(Paper paper) {
        return paperRepository.save(paper);
    }

    public List<Paper> getPaperByKeyword(String keywords) {
        return paperRepository.findByKeywordsContaining(keywords);
    }

    public Paper getPaperById(Long id) {
        Optional<Paper> p = paperRepository.findById(id);

        if (p.isPresent()) {
            return p.get();
        } else {
            return null;
        }
    }

    public Paper updatePaper(Paper paper) {
        // System.out.println("Updating ..." + paper.getId());
        return paperRepository.save(paper);
    }

    public void deletePaperById(Long id) {
        paperRepository.deleteById(id);
    }
}