package app.prog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "author")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthDate;
    private String particularity;
    public boolean hasParticularity() {return particularity != null;}
    @OneToMany(mappedBy = "author")
    private List<BookEntity> books;
}
