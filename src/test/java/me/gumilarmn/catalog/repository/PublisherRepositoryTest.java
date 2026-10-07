package me.gumilarmn.catalog.repository;

import me.gumilarmn.catalog.domain.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PublisherRepositoryTest {

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    void findAllByName_Success() {
        Publisher publisher = new Publisher();
        publisher.setName("Gramedia");
        publisher.setDescription("Buku Tentang Rumah");
        publisherRepository.save(publisher);

        List<Publisher> publishers = publisherRepository.findAllByName("Gramedia");
        assertEquals("Gramedia", publishers.getFirst().getName());
    }

    @Test
    void findAllByName_Incomplete() {
        Publisher publisher = new Publisher();
        publisher.setName("Gramedia");
        publisher.setDescription("Buku Tentang Rumah");
        publisherRepository.save(publisher);

        List<Publisher> publishers = publisherRepository.findAllByName("Gr");
        assertEquals("Gramedia", publishers.getFirst().getName());
    }

    @Test
    void findAllByNameLikeIgnoreCase_Incomplete() {
        Publisher publisher = new Publisher();
        publisher.setName("Gramedia");
        publisher.setDescription("Buku Tentang Rumah");
        publisherRepository.save(publisher);

        List<Publisher> publishers = publisherRepository.findAllByNameLikeIgnoreCase("Gr");
        assertEquals("Gramedia", publishers.getFirst().getName());
    }

    void findAllByNameUsingJPQL_Incomplete() {
        Publisher publisher = new Publisher();
        publisher.setName("Gramedia");
        publisher.setDescription("Buku Tentang Rumah");
        publisherRepository.save(publisher);

        List<Publisher> publishers = publisherRepository.findAllByPublisherNameUsingJPQL("Gr");
        assertEquals("Gramedia", publishers.getFirst().getName());
    }
}