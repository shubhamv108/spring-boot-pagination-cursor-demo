package code.shubham.demo.pagination.dao.entities;

import code.shubham.demo.pagination.dao.entities.base.BaseAbstractAuditableEntity;
import code.shubham.demo.pagination.dao.entities.base.BaseAbstractIntegerIdEntity;
import code.shubham.demo.pagination.dao.entities.base.PageableEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@SuperBuilder
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "persons", indexes = {
        @Index(name = "index_persons_first_name", columnList = "firstName") ,
        @Index(name = "index_persons_last_name", columnList = "lastName")
})
public class Person extends BaseAbstractAuditableEntity implements PageableEntity {

    private String firstName;
    private String lastName;

    @JsonIgnore
    @Override
    public String getCursorValue() {
        Instant instant = this.getCreatedAt().toInstant();
        return instant.getEpochSecond() + "|" +  instant.getNano() + "|" + this.getId();

    }
}
