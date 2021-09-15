package mdds;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import graphql.com.google.common.collect.ImmutableList;

@DgsComponent
public class MastHeadDataFetcher {

    @DgsQuery
    public MastHead mastHead(@InputArgument String pid) {
        return new MastHead(ImmutableList.of(new ContentItem(1),new ContentItem(2)));
    }
}
