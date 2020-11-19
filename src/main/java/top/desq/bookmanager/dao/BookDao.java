package top.desq.bookmanager.dao;

import top.desq.bookmanager.model.Book;

import java.util.List;

public interface BookDao {

    public void add(Book book);

    public void update(Book book);

    public void remove(int id);

    public Book getById(int id);

    public List<Book> list();

}
