package com.vkarassouloff.test.batchinsert.batchinsertmysql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchedEntityRepository extends JpaRepository<BatchedEntity, Long> {
}
