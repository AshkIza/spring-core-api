package io.ashkan.izadpanah.springboot.courseapi.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	Iterable<Book> getAllBooks(){
		return bookRepository.findAll();
		//TODO :also use pageable and Sortable
	}
	
	//TODO
	Iterable<Book> getAllBooksSortedBy(){
		Sort sort = null;
		return bookRepository.findAll(sort);//also pageable
	}
	
	Optional<Book> getBook(Long id){
		return bookRepository.findById(id);
	}
	
	Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	void updateBook(Long id, Book book) {
		book.id = id;
		bookRepository.save(book);
	}
	
	void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}
