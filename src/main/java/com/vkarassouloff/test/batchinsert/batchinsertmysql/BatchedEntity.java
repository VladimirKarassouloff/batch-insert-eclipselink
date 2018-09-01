package com.vkarassouloff.test.batchinsert.batchinsertmysql;


import javax.persistence.*;

@Entity
@Table(name = "batchedentity")
public class BatchedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="batched_entity_generator")
    @TableGenerator(name="batched_entity_generator", table="sequence_table", allocationSize = 100)
    @Column(name = "ID")
    private Long id;

    public BatchedEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BatchedEntity{" +
                "id=" + id +
                '}';
    }
}
