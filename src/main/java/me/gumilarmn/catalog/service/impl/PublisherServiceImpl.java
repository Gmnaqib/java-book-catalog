package me.gumilarmn.catalog.service.impl;

import lombok.RequiredArgsConstructor;
import me.gumilarmn.catalog.domain.Publisher;
import me.gumilarmn.catalog.dto.publisher.PublisherCreateRequestDTO;
import me.gumilarmn.catalog.dto.publisher.PublisherDetailResponseDTO;
import me.gumilarmn.catalog.dto.publisher.PublisherListRecordDTO;
import me.gumilarmn.catalog.dto.publisher.PublisherUpdateRequestDTO;
import me.gumilarmn.catalog.repository.PublisherRepository;
import me.gumilarmn.catalog.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    @Override
    public void createPublisher(PublisherCreateRequestDTO dto) {
        Publisher publiser = new Publisher();
        publiser.setName(dto.name());
        publiser.setDescription(dto.description());

    publisherRepository.save(publiser);
    }

    @Override
    public List<PublisherListRecordDTO> findPublisher() {
        List<Publisher> publishers = publisherRepository.findAll();
        return publishers.stream()
                .map(publisher -> new PublisherListRecordDTO(
                        publisher.getId(),
                        publisher.getName(),
                        publisher.getDescription()
                ))
                .toList();
    }

    @Override
    public PublisherDetailResponseDTO findPublisherDetail(Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Publisher id not found"));
        return new PublisherDetailResponseDTO(publisher.getId(), publisher.getName(), publisher.getDescription());
    }

    @Override
    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public void updatePublisher(Long id, PublisherUpdateRequestDTO dto) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Publisher id not found"));
        publisher.setName(dto.name());
        publisher.setDescription(dto.description());

        publisherRepository.save(publisher);
    }


}
