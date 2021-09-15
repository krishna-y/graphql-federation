package cdds;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import graphql.com.google.common.collect.ImmutableMap;

import java.util.Map;
@DgsComponent
public class ContentDataFetcher {
    private static final Map<Integer, ContentItem> map =
            ImmutableMap.of(
                    1, new ContentItem(1, "Title 1", "Description 1"),
                    2, new ContentItem(2, "Title 2", "Description 2")
            );

    @DgsEntityFetcher(name = "ContentItem")
    public ContentItem contentItem(Map<String, Object> values){
        return map.get(values.get("cid"));
    }
}
