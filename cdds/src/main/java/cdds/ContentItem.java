package cdds;

public class ContentItem {
    private final Integer cid;
    private final String title;
    private final String description;

    public ContentItem(Integer cid, String title, String description) {
        this.cid = cid;
        this.title = title;
        this.description = description;
    }
}
