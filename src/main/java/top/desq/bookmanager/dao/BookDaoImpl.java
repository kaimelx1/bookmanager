package top.desq.bookmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import top.desq.bookmanager.model.Book;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book successfully save. Book details: " + book);
    }

    @Override
    public void update(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book successfully updated. Book details: " + book);
    }

    @Override
    public void remove(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, id);

        if (book != null) {
            session.delete(book);
        }

        logger.info("Book successfully deleted. Book details: " + book);
    }

    @Override
    public Book getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, id);
        logger.info("Book successfully loaded. Book details: " + book);
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> list() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();

        bookList.forEach((book) -> logger.info("Book list: " + book));

        /*for (Book book : bookList) {
            logger.info("Book list: " + book);
        }*/

        return bookList;
    }
}
