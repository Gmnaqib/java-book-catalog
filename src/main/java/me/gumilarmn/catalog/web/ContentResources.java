package me.gumilarmn.catalog.web;

import me.gumilarmn.catalog.service.ContentService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ContentResources {
    private final ContentService contentService;

    public ContentResources(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/content")
    public String GetContent() {
        return contentService.getContent();
    }
}
