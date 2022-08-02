package com.savushkin.telestream.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Stream {
    private String name;
    private String year;
    private String season;
    private String episode;
    private StreamField setNext;
}
