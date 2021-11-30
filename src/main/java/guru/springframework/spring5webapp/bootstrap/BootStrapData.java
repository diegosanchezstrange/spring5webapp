package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner
{
	private final AuthorRepository		authorRepository;
	private final BookRepository		bookRepository;
	private final PublisherRepository	publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
	{
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception
	{
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123123123");
		Publisher publisher = new Publisher("SFG Publishing", "St Petersburg", "St Petersburg", "FL", 777777);

		publisherRepository.save(publisher);

		publisher.getBooks().add(ddd);
		eric.getBooks().add(ddd);
		ddd.setPublisher(publisher);
		ddd.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);

		Book noEJB = new Book("Domain Driven Design", "123123123");
		publisher.getBooks().add(noEJB);
		noEJB.setPublisher(publisher);

		bookRepository.save(noEJB);

		System.out.println("Started Bootstrap");
		System.out.println("Number of Books : " + bookRepository.count());
		System.out.println("Number of Authors : " + authorRepository.count());
		System.out.println("Publisher number of Books : " + publisher.getBooks().size());
	}
}
