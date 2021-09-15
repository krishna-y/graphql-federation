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
            list.addAll(contentItems);
            list.addAll(advtItems);
        } else{
            List<ContentItem> contentItems = ImmutableList.of(new ContentItem(3), new ContentItem(4));
            List<AdvtItem> advtItems = ImmutableList.of(new AdvtItem(3), new AdvtItem(4));
            list.addAll(contentItems);
            list.addAll(advtItems);
        }
        return list;
    }

    @DgsTypeResolver(name = "Item")
    public String resolveMovie(Object object) {
        if(object instanceof ContentItem) {
            return "ContentItem";
        } else if(object instanceof AdvtItem) {
            return "AdvtItem";
        } else {
            throw new RuntimeException("Invalid type: " + object.getClass().getName());
        }
    }
}
