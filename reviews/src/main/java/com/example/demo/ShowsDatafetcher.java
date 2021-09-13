package com.example.demo;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.context.DgsContext;
import graphql.com.google.common.collect.ImmutableList;
import com.netflix.graphql.dgs.*;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static com.example.demo.MyContextBuilder.*;

@DgsComponent
public class ShowsDatafetcher {

    private final List<Show> shows = ImmutableList.of(
            new Show("Stranger Things", "Bad"),
            new Show("Ozark", "Average"),
            new Show("The Crown", "Good"),
            new Show("Dead to Me", "Okay"),
            new Show("Orange is the New Black", "Not So Great")
    );

    @DgsEntityFetcher(name = "Show")
    public Show show(Map<String, Object> values) {
        DataLoaderRegistry
        return shows.stream().filter(s -> s.getTitle()
                .contains((String) values.get("title"))).findAny().orElse(null);
    }

    @DgsData(parentType = "Show", field = "review")
    public String review(DgsDataFetchingEnvironment dfe){
        Show source = dfe.getSource();
        return source.getReview() + "- Suffix Added";
    }
}
