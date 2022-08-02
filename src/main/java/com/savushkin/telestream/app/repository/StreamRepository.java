package com.savushkin.telestream.app.repository;

import com.savushkin.telestream.domain.Stream;

public interface StreamRepository {
    Stream getStream(long id);
}
