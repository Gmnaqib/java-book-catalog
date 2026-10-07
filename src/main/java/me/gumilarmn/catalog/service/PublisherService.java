package me.gumilarmn.catalog.service;

import me.gumilarmn.catalog.dto.publisher.PublisherCreateRequestDTO;
import me.gumilarmn.catalog.dto.publisher.PublisherDetailResponseDTO;
import me.gumilarmn.catalog.dto.publisher.PublisherListRecordDTO;
import me.gumilarmn.catalog.dto.publisher.PublisherUpdateRequestDTO;

import java.util.List;

public interface PublisherService {

    public void createPublisher(PublisherCreateRequestDTO dto);
    public List<PublisherListRecordDTO> findPublisher();
    public PublisherDetailResponseDTO findPublisherDetail(Long id);
    public void deletePublisher(Long id);
    void updatePublisher(Long id, PublisherUpdateRequestDTO dto);
}
