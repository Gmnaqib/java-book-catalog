package me.gumilarmn.catalog.service.impl;

import me.gumilarmn.catalog.service.ContentService;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {

    @Override
    public String getContent() {
        return "Get Content Berhasil";
    }
}
