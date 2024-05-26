package com.mertdev.comune.api.controllers;

import com.mertdev.comune.dataAccess.abstracts.WebPageRepository;
import com.mertdev.comune.entities.concretes.WebPage;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/no-auth/webpages")
@AllArgsConstructor
public class SearchUniversityController {
    private final WebPageRepository webPageRepository;
    @GetMapping("/search")
    public List<WebPage> searchWebPagesByName(@RequestParam String name) {
        return webPageRepository.findByNameContaining(name);
    }
}
