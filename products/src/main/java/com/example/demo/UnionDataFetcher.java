package com.example.demo;

import com.netflix.graphql.dgs.*;
import com.netflix.graphql.dgs.context.DgsContext;
import graphql.com.google.common.collect.ImmutableList;
import org.dataloader.DataLoader;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.example.demo.MyContextBuilder.MyContext;

@DgsComponent
public class UnionDataFetcher {

    @DgsQuery(field = "UnionObject")
    public UnionObject show(Map<String, Object> values) {
        return new UnionObject("pid");
    }

    @DgsData(parentType = "UnionObject", field = "dummy2")
    public List<Dummy2> dummy2(){
        return ImmutableList.of(new Dummy2("name 1", "value 1"),
                new Dummy2("name 2", "value 2"));
    }
}
