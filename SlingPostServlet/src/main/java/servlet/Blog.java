package servlet;

public class Blog {
    private String title;
    private String created;

    public Blog(String title, String created) {
        this.title = title;
        this.created = created;
    }

    @Override
    public String toString() {
        return "Blogs{" +
                "title='" + title + '\'' +
                ", created='" + created + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
