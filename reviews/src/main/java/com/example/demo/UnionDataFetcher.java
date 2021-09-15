package com.example.demo;

import com.netflix.graphql.dgs.*;
import graphql.com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Map;

@DgsComponent
public class UnionDataFetcher {

    @DgsEntityFetcher(name = "UnionObject")
    public UnionObject show(Map<String, Object> values) {
        return new UnionObject("pid");
    }

    @DgsData(parentType = "UnionObject", field = "dummy")
    public List<Dummy> dummy2(){
        return ImmutableList.of(new Dummy("name 1", 1),
                new Dummy("name 2", 2));
    }
}
