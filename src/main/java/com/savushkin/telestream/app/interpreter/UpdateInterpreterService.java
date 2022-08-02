package com.savushkin.telestream.app.interpreter;

import com.savushkin.telestream.domain.EventType;
import com.savushkin.telestream.domain.telegram.Update;

public interface UpdateInterpreterService {
    EventType interpretUpdate(Update update);
}
