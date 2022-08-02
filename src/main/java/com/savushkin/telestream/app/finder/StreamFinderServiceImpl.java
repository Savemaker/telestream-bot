package com.savushkin.telestream.app.finder;

import com.savushkin.telestream.domain.Stream;
import com.savushkin.telestream.domain.StreamType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.UriEncoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class StreamFinderServiceImpl implements StreamFinderService {

    @Value("${URL_PROVIDER}")
    private String url;

    @Override
    public String getStreamUrl(Stream stream, StreamType streamType) {
        if (streamType.equals(StreamType.MOVIE)) {
            return url + "movie" + getCommonParams(stream);
        } else {
            return url + "tv" + getCommonParams(stream) + "&s=" + encode(stream.getSeason()) + "&e=" + encode(stream.getEpisode());
        }
    }

    @Override
    public String encode(String string) {
        try {
            return URLEncoder.encode(string, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding string=" + string);
        }
    }

    private String getCommonParams(Stream stream) {
        return "?title=" + encode(stream.getName()) + "&year=" + encode(stream.getYear());
    }
}
