package cdds;

public class SportsItem {
    private final Integer cid;
    private final String title;
    private final Integer test;
    private final String description;

    public SportsItem(Integer cid, String title, Integer test, String description) {
        this.cid = cid;
        this.title = title;
        this.test = test;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCid() {
        return cid;
    }

    public Integer getTest() {
        return test;
    }
}
