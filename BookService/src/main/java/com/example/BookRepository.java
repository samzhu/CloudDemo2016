package com.example;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by samchu on 2016/9/12.
 */
//@Repository
@RepositoryRestResource(path = "book", collectionResourceRel = "book")
public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {

    Book findByBookid(@Param("bookid") Integer bookid);

}
