package com.example.demo;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.DgsTypeResolver;
import graphql.com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Map;

@DgsComponent
public class MastHeadDataFeatcher {

    @DgsQuery(field = "mastHeadItem")
    public List<MastHeadItem> show(Map<String, Object> values) {
        return ImmutableList.of(new MastHeadItem("a", "b", "c"));
    }

    @DgsTypeResolver(name = "MastHeadItem")
    public String resolveMovie(MastHeadItem item) {
        return "ContentItem";
    }
}
