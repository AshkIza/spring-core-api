package io.ashkan.izadpanah.springboot.courseapi.book;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookResource {
	@Autowired
	BookService bookService;
	
	@GetMapping
	List<Book> getAll(){		
		return StreamSupport
		.stream(bookService.getAllBooks().spliterator(), false)
		.collect(Collectors.toList());
	}
	
	@RequestMapping("/{id}")
	Book getTopic(@PathVariable Long id){
		return bookService.getBook(id).get();
	}
	
	//@PostMapping("/topics")
	@RequestMapping(method= {RequestMethod.POST}, path= "/topics")
	void createTopic(@RequestBody Book book) {
		bookService.addBook(book);
	}
	
	@RequestMapping(method= RequestMethod.PUT, value= "/topics/{id}")
	void updateTopic(@PathVariable Long id, @RequestBody Book book){
		bookService.updateBook(id, book);
		
	}
	
	@DeleteMapping("/topics/{id}")
	void deleteTopic(@PathVariable Long id) {
		bookService.deleteBook(id);

	}

}
