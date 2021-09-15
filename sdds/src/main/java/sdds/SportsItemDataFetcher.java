package sdds;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import graphql.com.google.common.collect.ImmutableMap;

import java.util.Map;

@DgsComponent
public class SportsItemDataFetcher {
    private static final Map<Integer, SportsItem> map =
            ImmutableMap.of(
                    1, new SportsItem(1, "Ind : 100/2"),
                    2, new SportsItem(2, "Ban : 100/2"),
                    3, new SportsItem(3, "Pak : 100/2"),
                    4, new SportsItem(4, "Eng : 100/2")
            );

    @DgsEntityFetcher(name = "SportsItem")
    public SportsItem contentItem(Map<String, Object> values){
        return map.get(values.get("cid"));
    }
}
