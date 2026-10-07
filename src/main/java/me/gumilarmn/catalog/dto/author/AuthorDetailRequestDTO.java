package me.gumilarmn.catalog.dto.author;

import java.time.LocalDate;

public record AuthorDetailRequestDTO(
        Long id,
        String name,
        String birthPlace,
        LocalDate birthDate,
        String description
) {
}
