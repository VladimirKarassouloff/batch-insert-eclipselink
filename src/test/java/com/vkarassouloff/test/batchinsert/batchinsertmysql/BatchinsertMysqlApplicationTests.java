package com.vkarassouloff.test.batchinsert.batchinsertmysql;

import org.apache.tomcat.jni.Local;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BatchinsertMysqlApplicationTests {

    @Autowired
    private BatchedEntityRepository batchedEntityRepository;

    private List<BatchedEntity> entities;

    @Before
    public void before() {
        entities = new ArrayList<>();

        IntStream.range(0, 1000).forEach(i -> {
            entities.add(new BatchedEntity());
        });
    }

    @Test
    public void batchInsert() {
        LocalDateTime ldt = LocalDateTime.now();
        batchedEntityRepository.saveAll(entities);

        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("Insert in : " + ((double)ChronoUnit.MILLIS.between(ldt, LocalDateTime.now())/1000.0) + "s");
        System.out.println();
        System.out.println();
        System.out.println();
    }

}
