package mdds;

import java.util.List;

public class MastHead {
    private final List<ContentItem> contentItems;
    private final List<AdvtItem> advtItems;
    private final List<SportsItem> sportsItems;

    public MastHead(List<ContentItem> contentItems,
                    List<AdvtItem> advtItems,
                    List<SportsItem> sportsItems) {
        this.contentItems = contentItems;
        this.advtItems = advtItems;
        this.sportsItems = sportsItems;
    }
}
