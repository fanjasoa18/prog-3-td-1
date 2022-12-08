package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.model.Book;
import app.prog.model.CreateBook;
import org.springframework.stereotype.Component;

@Component
public class BookRestMapper {
    public BookResponse toRest(Book domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .hasAuthor(domain.hasAuthor())
                .build();
    }
    public Book toDomain(CreateBook createBook) {
        return Book.builder()
                .title(createBook.getTitle())
                .author(createBook.getAuthor())
                .pageNumber(0)
                .build();
    }

    public Book toDomain(BookResponse createBook) {
        return Book.builder()
                .id(createBook.getId())
                .title(createBook.getTitle())
                .author(createBook.getAuthor())
                .pageNumber(0)
                .build();
    }
}
