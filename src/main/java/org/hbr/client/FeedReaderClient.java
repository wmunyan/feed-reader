package org.hbr.client;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import org.hbr.model.Feed;
import reactor.core.publisher.Mono;

@Client(id = "hbr")
public interface FeedReaderClient extends IFeedReader {
    @Get("/resources/xml/atom/latest-hbr.xml")
    Feed getFeed();
}
