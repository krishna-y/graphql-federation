package com.example.demo;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.DgsTypeResolver;
import graphql.com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Map;

@DgsComponent
public class MastHeadDataFeatcher {

    @DgsQuery(field = "mastHeadItem")
    public List<MastHeadItem> show() {
        return ImmutableList.of(new MastHeadItem("c", "https://google.com"));
    }

    @DgsTypeResolver(name = "MastHeadItem")
    public String resolveMovie(MastHeadItem item) {
        return "AdvtItem";
    }
}
