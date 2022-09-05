package com.savushkin.telestream.app.sender;

import com.savushkin.telestream.domain.telegram.SendMessageDTO;

public interface ResponseSenderService {
    void respondToCustomer(SendMessageDTO message);
}
