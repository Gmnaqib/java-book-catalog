package me.gumilarmn.catalog.dto.author;

import java.time.LocalDate;

public record AuthorRequestDTO(
        String name,
        String birthPlace,
        LocalDate birthDate,
        String description
) {
}
