package com.researchpapermgmt.services;

import java.util.List;

import com.researchpapermgmt.models.Paper;

public interface PaperService {
    List<Paper> getAllPapers();

    Paper createPaper(Paper paper);

    Paper getPaperById(Long id);

    List<Paper> getPaperByKeyword(String keyword);

    Paper updatePaper(Paper Paper);

    void deletePaperById(Long id);
}