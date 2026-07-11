package com.skillfyme.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void shouldReturnExpectedMessage() {
        assertEquals(
            "Jenkins Pipeline as Code is working!",
            App.getMessage()
        );
    }
}
