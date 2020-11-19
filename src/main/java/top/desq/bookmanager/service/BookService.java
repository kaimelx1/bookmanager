package top.desq.bookmanager.service;

import top.desq.bookmanager.model.Book;

import java.util.List;

public interface BookService {

    public void add(Book book);

    public void update(Book book);

    public void remove(int id);

    public Book getById(int id);

    public List<Book> list();
}
