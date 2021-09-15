package adds;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import graphql.com.google.common.collect.ImmutableMap;

import java.util.Map;

@DgsComponent
public class AdvtItemDataFetcher {
    private static final Map<Integer, AdvtItem> map =
            ImmutableMap.of(
                    1, new AdvtItem(1, "Add 1"),
                    2, new AdvtItem(2, "Add 2"),
                    3, new AdvtItem(2, "Add 3"),
                    4, new AdvtItem(2, "Add 4")
            );

    @DgsEntityFetcher(name = "ContentItem")
    public AdvtItem contentItem(Map<String, Object> values){
        return map.get(values.get("aid"));
    }
}
