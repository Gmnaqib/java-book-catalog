package me.gumilarmn.catalog.web;

import lombok.RequiredArgsConstructor;
import me.gumilarmn.catalog.domain.Author;
import me.gumilarmn.catalog.dto.author.AuthorDetailRequestDTO;
import me.gumilarmn.catalog.dto.author.AuthorRequestDTO;
import me.gumilarmn.catalog.repository.AuthorRepository;
import me.gumilarmn.catalog.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/author")
public class AuthorResources {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Void> createNewAuthor(@RequestBody AuthorRequestDTO dto) {
        authorService.createAuthor(dto);
        return ResponseEntity.created(URI.create("/v1/author")).build();
    }

    @GetMapping("/search")
    public ResponseEntity<AuthorDetailRequestDTO> findAuthorByName(@RequestParam(name = "name") String name){
        AuthorDetailRequestDTO author = authorService.getAuthorByName(name);
        return ResponseEntity.ok(author);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDetailRequestDTO>> findAllAuthors(){
        List<AuthorDetailRequestDTO> author = authorService.findAllAuthor();
        return ResponseEntity.ok(author);
    }

    @GetMapping("{id}")
    public ResponseEntity<AuthorDetailRequestDTO> findAuthorById(@PathVariable Long id){
        AuthorDetailRequestDTO author = authorService.getAuthorById(id);
        return ResponseEntity.ok(author);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<AuthorDetailRequestDTO>updateAuthor(@PathVariable Long id, @RequestBody AuthorRequestDTO dto) {
        authorService.updateAuthor(id, dto);
        return ResponseEntity.ok().build();
    }

}
