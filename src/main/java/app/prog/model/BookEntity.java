package app.prog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int author_id;
    @ManyToOne
    @JoinColumn(name = "id_author", insertable = false, updatable = false)
    private AuthorEntity author;
    private Integer pageNumber;
    private LocalDate releaseDate;
    @ManyToMany(mappedBy = "books")
    private List<CategoryEntity> categories = new ArrayList<>();

    public boolean hasAuthor() {
        return author != null;
    }

}
