package mdds;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import graphql.com.google.common.collect.ImmutableList;

import java.util.List;

@DgsComponent
public class MastHeadDataFetcher {

    @DgsQuery
    public MastHead mastHead(@InputArgument String pid) {
        if("1".equals(pid)) {
            List<ContentItem> contentItems = ImmutableList.of(new ContentItem(1), new ContentItem(2));
            List<AdvtItem> advtItems = ImmutableList.of(new AdvtItem(1), new AdvtItem(2));
            List<SportsItem> sportsItems = ImmutableList.of(new SportsItem(1), new SportsItem(2));

            return new MastHead(contentItems, advtItems, sportsItems);
        } else{
            List<ContentItem> contentItems = ImmutableList.of(new ContentItem(3), new ContentItem(4));
            List<AdvtItem> advtItems = ImmutableList.of(new AdvtItem(3), new AdvtItem(4));
            List<SportsItem> sportsItems = ImmutableList.of(new SportsItem(3), new SportsItem(4));

            return new MastHead(contentItems, advtItems, sportsItems);
        }
    }
}
