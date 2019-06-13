package gdss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(rollbackFor = {Throwable.class})
public abstract class AbstractEntityService<E extends AbstractEntity, R extends AbstractEntityRepository<E>> {

    @Autowired
    protected R repository;

    public E create(E entity) {
        return repository.save(entity);
    }

    public E retrieve(UUID id) {
        return repository.getOne(id);
    }

    public E update(E entity) {
        return repository.save(entity);
    }

    public void delete(E entity) {
        repository.delete(entity);
    }

    public Page<E> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

}
