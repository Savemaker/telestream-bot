package com.savushkin.telestream.app.checker;

import com.savushkin.telestream.domain.Stream;
import com.savushkin.telestream.domain.StreamType;

import java.util.Optional;

public interface StreamCheckerService {
    Optional<String> checkStream(Stream stream, StreamType streamType);
}
