package com.example.demo;

import com.netflix.graphql.dgs.context.DgsCustomContextBuilder;
import com.netflix.graphql.dgs.reactive.DgsReactiveCustomContextBuilderWithRequest;
import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static com.example.demo.MyContextBuilder.*;
import static java.util.concurrent.CompletableFuture.completedFuture;

@Component
public class MyContextBuilder implements DgsReactiveCustomContextBuilderWithRequest<MyContext> {
    private DataLoader<String, String> actorsDataLoader;
    public MyContextBuilder(){
        BatchLoader<String, String> batchLoader = new BatchLoader<String, String>() {
            @Override
            public CompletionStage<List<String>> load(List<String> keys) {
                System.out.println(keys);
                return CompletableFuture.supplyAsync(() -> keys);
            }
        };

        this.actorsDataLoader = DataLoader
                .newDataLoader(batchLoader, DataLoaderOptions.newOptions().setMaxBatchSize(10).setBatchingEnabled(true));
        completedFuture(null).
                supplyAsync(()->{
                    while (true){
                        try {
                            Thread.sleep(1);
                            actorsDataLoader.dispatch();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }


    @NotNull
    @Override
    public Mono<MyContext> build(@Nullable Map<String, ?> map,
                                 @Nullable HttpHeaders httpHeaders,
                                 @Nullable ServerRequest serverRequest) {
        return Mono.just(new MyContext(actorsDataLoader));

    }

    public static class MyContext {
        private final String customState = "Custom state!";
        private DataLoader<String, String> actorsDataLoader;
        public MyContext(DataLoader dataLoader){
            this.actorsDataLoader = dataLoader;
        }

        public String getCustomState() {
            return customState;
        }

        public DataLoader<String, String> getActorsDataLoader() {
            return actorsDataLoader;
        }
    }
}
