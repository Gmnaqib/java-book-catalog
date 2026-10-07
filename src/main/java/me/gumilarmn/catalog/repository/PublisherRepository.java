package me.gumilarmn.catalog.repository;

import me.gumilarmn.catalog.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    public List<Publisher> findAllByName(String publisherName);

    public List<Publisher> findAllByNameLikeIgnoreCase(String publisherName);
    @Query("SELECT p FROM Publisher p WHERE UPPER(p.name) LIKE UPPER(:publisherName)")
    public List<Publisher> findAllByPublisherNameUsingJPQL( String publisherName);

}
