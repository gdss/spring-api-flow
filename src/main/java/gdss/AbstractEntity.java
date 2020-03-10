package gdss;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
// Need @EnableJpaAuditing on Application
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    protected UUID id;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    protected LocalDateTime createdDate;

    @Column(nullable = false)
    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;

    @Version
    protected Integer version;

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public Integer getVersion() {
        return version;
    }

}
