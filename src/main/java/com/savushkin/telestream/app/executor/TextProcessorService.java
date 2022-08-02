package com.savushkin.telestream.app.executor;

import com.savushkin.telestream.domain.telegram.Update;

public interface TextProcessorService {
    void processText(Update update);
}
