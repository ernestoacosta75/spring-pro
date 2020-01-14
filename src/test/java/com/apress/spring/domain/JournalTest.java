package com.apress.spring.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class JournalTest {

    public static void main(String[] args) {
        Journal journal = null;

        journal = Journal.builder()
                    .title("Washinton Post")
                    .created(new Date())
                    .summary("An american journal")
                    .build();

        Assertions.assertNotNull(journal);
        Assertions.assertNotNull(journal.toString());
        Assertions.assertNotNull(journal.hashCode());
    }
}
