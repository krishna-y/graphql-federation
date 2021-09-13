package com.example.demo;

import com.netflix.graphql.dgs.context.DgsCustomContextBuilder;
import graphql.com.google.common.collect.ImmutableList;
import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderOptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static com.example.demo.MyContextBuilder.*;
import static java.util.concurrent.CompletableFuture.completedFuture;

@Component
public class MyContextBuilder implements DgsCustomContextBuilder<MyContext> {
    private DataLoader<String, String> actorsDataLoader;
    public MyContextBuilder(){
        BatchLoader<String, String> batchLoader = new BatchLoader<String, String>() {
            @Override
            public CompletionStage<List<String>> load(List<String> keys) {
                System.out.println(keys);
                return CompletableFuture.supplyAsync(() -> keys);
            }
        };

        BatchData

        this.actorsDataLoader = DataLoader
                .newDataLoader(batchLoader, DataLoaderOptions.newOptions().setMaxBatchSize(10).setBatchingEnabled(true));
        completedFuture(null).
                supplyAsync(()->{
                    while (true){
                        try {
                            Thread.sleep(10000);
                            actorsDataLoader.dispatch();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public MyContext build() {
        return new MyContext(actorsDataLoader);
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
