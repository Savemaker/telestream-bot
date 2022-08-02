package com.savushkin.telestream.app.checker;

import com.savushkin.telestream.domain.Stream;
import com.savushkin.telestream.domain.StreamType;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreamCheckerServiceImpl implements StreamCheckerService {
    @Override
    public Optional<String> checkStream(Stream stream, StreamType streamType) {
        if (stream.getName() == null) {
            return Optional.of("Name is empty");
        }
        if (stream.getYear() == null) {
            return Optional.of("Year is empty");
        }
        if (streamType.equals(StreamType.SHOW)) {
            if (stream.getSeason() == null) {
                return Optional.of("Season is empty");
            }
            if (stream.getEpisode() == null) {
                return Optional.of("Episode is empty");
            }
        }
        return Optional.empty();
    }
}
