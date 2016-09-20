package com.example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by samchu on 2016/9/13.
 */

@FeignClient(name = "book-service")
public interface BookReader {

    @RequestMapping(method = RequestMethod.POST, value = "/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Book create(Book book);

    @RequestMapping(method = RequestMethod.GET, value = "/book/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Resource<Book> get(@PathVariable("id") Integer id);
}
