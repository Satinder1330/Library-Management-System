public class Books {
    int id;
    String title;
    String author;
    boolean available;

    public Books(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Books{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", available=").append(available);
        sb.append('}');
        return sb.toString();
    }


}
