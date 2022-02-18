package netology.domain;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int count, String author) {
        super(id, name, count);
        this.author = author;
    }

}
