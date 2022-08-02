package com.savushkin.telestream.app.repository;

import com.savushkin.telestream.domain.Stream;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class InMemoryStreamRepositoryImpl implements StreamRepository {
    private final ConcurrentMap<Long, Stream> repo = new ConcurrentHashMap<>();

    @Override
    public Stream getStream(long id) {
        Stream stream = repo.get(id);
        if (stream == null) {
            Stream createdStream = new Stream();
            repo.put(id, createdStream);
            return createdStream;
        }
        return stream;
    }
}
