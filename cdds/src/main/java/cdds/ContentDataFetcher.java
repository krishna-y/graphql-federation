package cdds;

import com.netflix.graphql.dgs.*;
import graphql.com.google.common.collect.ImmutableMap;

import java.util.Map;
@DgsComponent
public class ContentDataFetcher {
    private static final Map<Integer, ContentItem> map =
            ImmutableMap.of(
                    1, new ContentItem(1, "Content 1", "Description 1"),
                    2, new ContentItem(2, "Content 2", "Description 2"),
                    3, new ContentItem(3, "Content 3", "Description 3"),
                    4, new ContentItem(4, "Content 4", "Description 4")
            );

    @DgsEntityFetcher(name = "ContentItem")
    public ContentItem contentItem(Map<String, Object> values){
        return map.get(values.get("cid"));
    }

    @DgsEntityFetcher(name = "SportsItem")
    public SportsItem sportsItem(Map<String, Object> values){
        Integer cid = (Integer) values.get("cid");
        ContentItem contentItem = map.get(cid);
        return new SportsItem(cid, contentItem.getTitle(), contentItem.getDescription());
    }


}
