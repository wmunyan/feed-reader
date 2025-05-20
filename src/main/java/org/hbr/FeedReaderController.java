package org.hbr;


import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.hbr.client.FeedReaderClient;
import org.hbr.model.Feed;

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
    @ExecuteOn(TaskExecutors.IO)
    @Get(produces = MediaType.APPLICATION_JSON)
    Feed foo() {
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
    @ExecuteOn(TaskExecutors.IO)
    @Get(uri = "/xml", produces = MediaType.APPLICATION_XML)
    Feed bar() {
        return feedReaderClient.getFeed();
    }
}