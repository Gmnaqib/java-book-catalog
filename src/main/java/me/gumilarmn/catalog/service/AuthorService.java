package me.gumilarmn.catalog.service;

import me.gumilarmn.catalog.domain.Author;
import me.gumilarmn.catalog.dto.author.AuthorDetailRequestDTO;
import me.gumilarmn.catalog.dto.author.AuthorRequestDTO;

import java.util.List;

public interface AuthorService {
    public void createAuthor(AuthorRequestDTO dto);
    public List<AuthorDetailRequestDTO> findAllAuthor();
    public AuthorDetailRequestDTO getAuthorById(Long id);
    public AuthorDetailRequestDTO getAuthorByName(String name);
    void updateAuthor(Long id, AuthorRequestDTO dto);
    public void deleteAuthor(Long id);
}
