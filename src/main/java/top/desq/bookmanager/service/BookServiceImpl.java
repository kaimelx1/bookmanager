package top.desq.bookmanager.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.desq.bookmanager.dao.BookDao;
import top.desq.bookmanager.model.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void add(Book book) {
        this.bookDao.add(book);
    }

    @Override
    @Transactional
    public void update(Book book) {
        this.bookDao.update(book);
    }

    @Override
    @Transactional
    public void remove(int id) {
        this.bookDao.remove(id);
    }

    @Override
    @Transactional
    public Book getById(int id) {
        return this.bookDao.getById(id);
    }

    @Override
    @Transactional
    public List<Book> list() {
        return this.bookDao.list();
    }
}
