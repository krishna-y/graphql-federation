package mdds;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.DgsTypeResolver;
import com.netflix.graphql.dgs.InputArgument;
import graphql.com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

@DgsComponent
public class MastHeadListDataFetcher {

    @DgsQuery
    public List<Object> mastHeadList(@InputArgument String pid) {
        List<Object> list = new ArrayList<>();
        if("1".equals(pid)) {
            List<ContentItem> contentItems = ImmutableList.of(new ContentItem(1), new ContentItem(2));
            List<AdvtItem> advtItems = ImmutableList.of(new AdvtItem(1), new AdvtItem(2));
            List<SportsItem> sportsItems = ImmutableList.of(new SportsItem(1, 1), new SportsItem(2, 1));
            list.addAll(contentItems);
            list.addAll(advtItems);
            list.addAll(sportsItems);
        } else{
            List<ContentItem> contentItems = ImmutableList.of(new ContentItem(3), new ContentItem(4));
            List<AdvtItem> advtItems = ImmutableList.of(new AdvtItem(3), new AdvtItem(4));
            List<SportsItem> sportsItems = ImmutableList.of(new SportsItem(3, 1), new SportsItem(4, 1));
            list.addAll(contentItems);
            list.addAll(advtItems);
            list.addAll(sportsItems);
        }
        return list;
    }

    @DgsTypeResolver(name = "Item")
    public String resolveMovie(Object object) {
        if(object instanceof ContentItem) {
            return "ContentItem";
        } else if(object instanceof AdvtItem) {
            return "AdvtItem";
        } else if(object instanceof SportsItem) {
            return "SportsItem";
        } else {
            throw new RuntimeException("Invalid type: " + object.getClass().getName());
        }
    }
}
