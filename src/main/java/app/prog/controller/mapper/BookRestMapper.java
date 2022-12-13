package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookRestMapper {
    private final AuthorRepository authorRepository;
    public BookResponse toRest(BookEntity domain) {
        AuthorEntity author = author != null? author.getName(): null;
        return BookResponse.builder()
                .id(domain.getId())
                //.category(domain.getCategories().stream().map(categoryEntity -> {return categoryEntity.getName();}).toList())
                .title(domain.getTitle())
                .author(author.getName())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        return BookEntity.builder()
                .author(authorRepository.findByName(rest.getAuthor()))
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        return BookEntity.builder()
                .id(rest.getId())
                .author(authorRepository.findByName(rest.getAuthor()))
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }
}
