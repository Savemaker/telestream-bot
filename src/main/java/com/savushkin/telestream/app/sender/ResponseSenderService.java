package com.savushkin.telestream.app.sender;

import com.savushkin.telestream.domain.telegram.SendMessageDTO;
import com.savushkin.telestream.domain.telegram.Update;

public interface ResponseSenderService {
    void respondToCustomer(SendMessageDTO message);
}
