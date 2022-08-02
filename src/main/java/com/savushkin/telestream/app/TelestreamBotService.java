package com.savushkin.telestream.app;

import com.savushkin.telestream.domain.telegram.Update;

public interface TelestreamBotService {
    void processUpdate(Update update);
}
