package gdss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

public abstract class AbstractEntityController<E extends AbstractEntity, D extends AbstractEntityDto, M extends AbstractEntityMapper<E, D>, S extends AbstractEntityService<E, ?>> {

    @Autowired
    protected S service;

    @Autowired
    protected M mapper;

    @GetMapping
    public ResponseEntity<Page<D>> findAll(@PageableDefault Pageable pageable) {
        Page<D> dtoPage = service.findAll(pageable).map(mapper::toDto);
        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<D> create(@RequestBody D entityDto) {
        E entity = mapper.toEntity(entityDto);
        entity = service.create(entity);
        entityDto = mapper.toDto(entity);
        return new ResponseEntity<>(entityDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> retrieve(@PathVariable(value = "id") UUID id) {
        E entity = service.retrieve(id);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        D entityDto = mapper.toDto(entity);
        return new ResponseEntity<>(entityDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable(value = "id") UUID id, @RequestBody D entityDto) {
        E entity = service.retrieve(id);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        mapper.updateEntityFromDto(entityDto, entity);
        entity = service.update(entity);
        entityDto = mapper.toDto(entity);
        return new ResponseEntity<>(entityDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") UUID id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
