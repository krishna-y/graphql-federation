package com.example.demo;

import com.example.demo.Actor;

import com.netflix.graphql.dgs.*;
import com.netflix.graphql.dgs.context.DgsContext;
import graphql.com.google.common.collect.ImmutableList;
import org.dataloader.DataLoader;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static com.example.demo.MyContextBuilder.*;

@DgsComponent
public class ShowsDatafetcher {

    private final List<Show> shows = ImmutableList.of(
            new Show("Stranger Things", 2016),
            new Show("Ozark", 2017),
            new Show("The Crown", 2016),
            new Show("Dead to Me", 2019),
            new Show("Orange is the New Black", 2013)
    );

    @DgsQuery
    public Flux<Show> shows(@InputArgument String titleFilter) {
        if(titleFilter == null) {

            Show[] showsList = shows.toArray(new Show[0]);
            return Flux.just(showsList);
        }

        return Flux.just(shows.stream().filter(s -> s.getTitle()
                .contains(titleFilter)).toArray(Show[]::new)).delayElements(Duration.ofSeconds(1))
                .log();
    }

    @DgsData(parentType = "Show", field = "actors")
    public Flux<Actor> actors(DgsDataFetchingEnvironment dfe){
        MyContext customContext = DgsContext.getCustomContext(dfe);
        Show source = dfe.getSource();
        DataLoader<String, String> actorsDataLoader = customContext.getActorsDataLoader();
        CompletableFuture<List<Actor>> immutableListCompletableFuture = actorsDataLoader.load(source.getTitle())
                .thenApply(s -> ImmutableList.of(new Actor(s, 1)));
        List<Actor> join = immutableListCompletableFuture.join();

//        actorsDataLoader.dispatch();
        return Flux.just(join.toArray(new Actor[0])).delayElements(Duration.ofSeconds(1)).log();
    }
}
