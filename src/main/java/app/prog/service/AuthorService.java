package app.prog.service;

import app.prog.exception.NotFoundException;
import app.prog.model.AuthorEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;

    public List<AuthorEntity> getAuthors(){
        return repository.findAll();
    }

    public List<AuthorEntity> createAuthors(List<AuthorEntity> toCreate) {
        return repository.saveAll(toCreate);
    }

    public AuthorEntity findById(int id) {
        Optional<AuthorEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }else {
            throw new NotFoundException("AuthorEntity."+id+" "+"not found");
        }
    }

    public List<AuthorEntity> updateAuthors(List<AuthorEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public AuthorEntity deleteAuthor(int AuthorEntityId) {
        Optional<AuthorEntity> optional = repository.findById(AuthorEntityId);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        }else {
            throw new NotFoundException("AuthorEntity."+AuthorEntityId+" "+"not found");
        }
    }

    public List<AuthorEntity> getAuthor(Optional<Integer> page, Optional<Integer> pageSize) {
        Pageable pageable = PageRequest.of(page.orElse(0),pageSize.orElse(10) );
        return repository.findAll(pageable).stream().toList();
    }

}
