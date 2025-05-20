package org.hbr.client;

import io.micronaut.http.HttpResponse;
import org.hbr.model.Feed;
import reactor.core.publisher.Mono;

public interface IFeedReader {
    Feed getFeed();
}
