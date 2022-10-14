package com.valtech.library.books.assignment.client;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import com.valtech.library.books.assignment.orm.Article;
import com.valtech.library.books.assignment.orm.Author;
import com.valtech.library.books.assignment.orm.AuthorAddress;
import com.valtech.library.books.assignment.orm.Blog;
import com.valtech.library.books.assignment.orm.Book;
import com.valtech.library.books.assignment.orm.HardBind;
import com.valtech.library.books.assignment.orm.Publisher;

public class HibernateClient {
	public static void main(String[] args) {
		SessionFactory sf = new AnnotationConfiguration().configure().addAnnotatedClass(Book.class)
				.addAnnotatedClass(AuthorAddress.class).addAnnotatedClass(Article.class).addAnnotatedClass(Author.class)
				.addAnnotatedClass(Blog.class).addAnnotatedClass(HardBind.class).addAnnotatedClass(Publisher.class)
				.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.beginTransaction();

		@SuppressWarnings("deprecation")
		Book b = new Book("ASOIAF", "2A", 100, new Date(69, 8, 14));
		Publisher p = new Publisher(101, "Anuj", "bangalore", 5614422656L);

		ses.save(p);
		b.setPublisher(p);
		ses.save(b);

		Article a1 = new Article("abc.exam.com", "anujsm");
		ses.save(a1);
		Author a = new Author("jordy", 69420L);
		ses.save(a);
		AuthorAddress a11 = new AuthorAddress(23, "bengaluru", "karnataka", 159467L);
		ses.save(a11);
		a.setAuthoraddress(a11);
		a11.setAuthor(a);
		Blog b1 = new Blog("viral", "example.hello.com", 3L);
		ses.save(b1);
		HardBind hb1 = new HardBind(1, 200, "2022", 1);
		ses.save(hb1);

		tx.commit();
		ses.close();
		sf.close();
	}

}
