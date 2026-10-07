package me.gumilarmn.catalog.service.impl;

import lombok.RequiredArgsConstructor;
import me.gumilarmn.catalog.domain.Author;
import me.gumilarmn.catalog.dto.author.AuthorDetailRequestDTO;
import me.gumilarmn.catalog.dto.author.AuthorRequestDTO;
import me.gumilarmn.catalog.repository.AuthorRepository;
import me.gumilarmn.catalog.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

private final AuthorRepository authorRepository;
    @Override
    public void createAuthor(AuthorRequestDTO dto) {
        Author author = new Author();
        author.setName(dto.name());
        author.setBirthPlace(dto.birthPlace());
        author.setBirthDate(dto.birthDate());
        author.setDescription(dto.description());
        authorRepository.save(author);
    }

    @Override
    public List<AuthorDetailRequestDTO> findAllAuthor() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(author -> new AuthorDetailRequestDTO(
                        author.getId(),
                        author.getName(),
                        author.getBirthPlace(),
                        author.getBirthDate(),
                        author.getDescription()
                ) )
                .toList();
    }

    @Override
    public AuthorDetailRequestDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Author id not found"));
        return new AuthorDetailRequestDTO(
                author.getId(),
                author.getName(),
                author.getBirthPlace(),
                author.getBirthDate(),
                author.getDescription()
        );
    }

    public AuthorDetailRequestDTO findAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Author id not found"));
        return new AuthorDetailRequestDTO(
                author.getId(),
                author.getName(),
                author.getBirthPlace(),
                author.getBirthDate(),
                author.getDescription()
        );
    }

    @Override
    public AuthorDetailRequestDTO getAuthorByName(String name) {
        Author author = authorRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException("Author name not found"));
        return new AuthorDetailRequestDTO(
                author.getId(),
                author.getName(),
                author.getBirthPlace(),
                author.getBirthDate(),
                author.getDescription()
        );
    }

    @Override
    public void updateAuthor(Long id, AuthorRequestDTO dto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Author id not found"));
        author.setName(dto.name());
        author.setBirthPlace(dto.birthPlace());
        author.setBirthDate(dto.birthDate());
        author.setDescription(dto.description());
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
