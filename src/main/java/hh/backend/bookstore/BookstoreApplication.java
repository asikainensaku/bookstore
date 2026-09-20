package hh.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.backend.bookstore.domain.Category;
import hh.backend.bookstore.domain.CategoryRepository;

import hh.backend.bookstore.domain.Book;
import hh.backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {

			repository.save(
					new Book("Hei me koodataan!", "Kalle Koodaaja", 2010, "1111111-12", 23.10));

			repository.save(
					new Book("Javaa javattomille", "Jaakko Javailija", 2015, "2222222-23", 19.90));

			repository.save(
					new Book("Bugit kuriin", "Pekka Ohjelmoija", 2020, "3333333-34", 25.50));

			repository.save(
					new Book("Koodarin käsikirja", "Tiina Tietokanta", 2023, "4444444-45", 29.90));

			repository.save(
					new Book("Suuri nörttien vitsikirja", "Veikko Vitsi", 2025, "5555555-56", 32.70));

			categoryRepository.save(
					new Category("Programming"));

			categoryRepository.save(
					new Category("Technology"));

			categoryRepository.save(
					new Category("Comedy"));
		};
	}
}
