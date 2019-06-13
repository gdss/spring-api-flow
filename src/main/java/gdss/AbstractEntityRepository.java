package gdss;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface AbstractEntityRepository<E extends AbstractEntity> extends JpaRepository<E, UUID>, JpaSpecificationExecutor {
}
