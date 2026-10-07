package me.gumilarmn.catalog.web;

import lombok.RequiredArgsConstructor;
import me.gumilarmn.catalog.dto.publisher.PublisherCreateRequestDTO;
import me.gumilarmn.catalog.dto.publisher.PublisherDetailResponseDTO;
import me.gumilarmn.catalog.dto.publisher.PublisherListRecordDTO;
import me.gumilarmn.catalog.dto.publisher.PublisherUpdateRequestDTO;
import me.gumilarmn.catalog.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/publishers")
public class PublisherResource {
    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<Void> createNewPublisher(@RequestBody PublisherCreateRequestDTO dto) {
        publisherService.createPublisher(dto);
        return ResponseEntity.created(URI.create("/v1/publisers")).build();
    }

    @GetMapping
    public ResponseEntity<List<PublisherListRecordDTO>> findAllPublisher() {
        List<PublisherListRecordDTO> dto = publisherService.findPublisher();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<PublisherDetailResponseDTO> findPublisherDetail(@PathVariable Long id) {
        PublisherDetailResponseDTO dto = publisherService.findPublisherDetail(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updatePublisher(@PathVariable Long id, @RequestBody PublisherUpdateRequestDTO dto) {
        publisherService.updatePublisher(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }
}
