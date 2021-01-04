package io.ashkan.izadpanah.springboot.courseapi.book;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

}
