package org.hbr;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.hbr.client.FeedReaderClient;
import org.hbr.model.Feed;
import reactor.core.publisher.Mono;

@Controller("/feed-reader")
public class FeedReaderController {

    @Inject
    FeedReaderClient feedReaderClient;

    @Operation(
        summary = "Retrieve the Feed as JSON",
        description = "Retrieve the Feed as JSON"
    )
    @ApiResponse(
        responseCode = "200",
        description = "HBR.org Latest Feed successfully retrieved",
        content = {
            @Content(
                schema = @Schema(implementation = Feed.class),
                mediaType = "application/json")
        }
    )
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @Tag(name = "Feed")
    @Get(uri = "/", produces = MediaType.APPLICATION_JSON)
    Mono<HttpResponse<Feed>> get() {
        return feedReaderClient.getFeed();
    }

    @Operation(
        summary = "Retrieve the Feed as XML",
        description = "Retrieve the Feed as XML"
    )
    @ApiResponse(
        responseCode = "200",
        description = "HBR.org Latest Feed successfully retrieved",
        content = {
            @Content(
                schema = @Schema(implementation = Feed.class),
                mediaType = "application/xml")
        }
    )
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @Tag(name = "Feed")
    @Get(uri = "/xml", produces = MediaType.APPLICATION_XML)
    Mono<HttpResponse<Feed>> getXml() {
        return feedReaderClient.getFeed();
    }
}