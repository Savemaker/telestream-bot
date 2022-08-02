package com.savushkin.telestream.app.finder;

import com.savushkin.telestream.domain.Stream;
import com.savushkin.telestream.domain.StreamType;

public interface StreamFinderService {
    String getStreamUrl(Stream stream, StreamType streamType);
    String encode(String string);
}
