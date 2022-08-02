package com.savushkin.telestream.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Update {
    @JsonProperty("update_id")
    private long updateId;
    private Message message;
}