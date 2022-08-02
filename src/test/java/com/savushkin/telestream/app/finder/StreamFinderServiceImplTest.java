package com.savushkin.telestream.app.finder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreamFinderServiceImplTest {
    private final StreamFinderService streamFinderService;

    public StreamFinderServiceImplTest() {
        this.streamFinderService = new StreamFinderServiceImpl();
    }

    @Test
    void testLoveDeathAndRobots() {
        String showName = "Love, Death & Robots";
        Assertions.assertThat(streamFinderService.encode(showName)).isEqualTo("Love%2C+Death+%26+Robots");
    }
}