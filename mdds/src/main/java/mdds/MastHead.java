package mdds;

import java.util.List;

public class MastHead {
    private final List<ContentItem> contentItems;
    private final List<AdvtItem> advtItems;

    public MastHead(List<ContentItem> contentItems,
                    List<AdvtItem> advtItems) {
        this.contentItems = contentItems;
        this.advtItems = advtItems;
    }
}
