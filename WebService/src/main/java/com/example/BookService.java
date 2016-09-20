package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

/**
 * Created by samchu on 2016/9/19.
 */
@Service
public class BookService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private BookReader bookReader;

    /**
     * 使用原本的 RestTemplate 操作
     *
     * @param book
     * @return Book
     */
    public Book createByRestTemplate(Book book) {
        ParameterizedTypeReference<Book> ptr =
                new ParameterizedTypeReference<Book>() {
                };
        HttpEntity<Book> request = new HttpEntity<>(book);
        ResponseEntity<Book> responseEntity =
                new RestTemplate().exchange("http://localhost:8000/book",
                        HttpMethod.POST, request, ptr);
        return responseEntity.getBody();
    }

    /**
     * 使用原本的 RestTemplate 操作
     *
     * @param bookid
     * @return Resource<Book>
     */
    public Resource<Book> getByRestTemplate(Integer bookid) {
        ParameterizedTypeReference<Resource<Book>> ptr =
                new ParameterizedTypeReference<Resource<Book>>() {
                };
        ResponseEntity<Resource<Book>> responseEntity =
                new RestTemplate().exchange("http://localhost:8000/book/" + bookid,
                        HttpMethod.GET, null, ptr);
        return responseEntity.getBody();
    }

    /**
     * 使用自動附載平衡機制
     *
     * @param book
     * @return ResponseEntity<Resources<Book>>
     */
    public Book createByLoadBalancedRestTemplate(Book book) {
        ParameterizedTypeReference<Book> ptr =
                new ParameterizedTypeReference<Book>() {
                };
        HttpEntity<Book> request = new HttpEntity<>(book);
        ResponseEntity<Book> responseEntity =
                this.restTemplate.exchange("http://book-service/book",
                        HttpMethod.POST, request, ptr);
        return responseEntity.getBody();
    }

    /**
     * 使用自動附載平衡機制
     *
     * @param bookid
     * @return Resource<Book>
     */
    public Resource<Book> getByLoadBalancedRestTemplate(Integer bookid) {
        ParameterizedTypeReference<Resource<Book>> ptr =
                new ParameterizedTypeReference<Resource<Book>>() {
                };
        ResponseEntity<Resource<Book>> responseEntity =
                this.restTemplate.exchange("http://book-service/book/" + bookid,
                        HttpMethod.GET, null, ptr);
        return responseEntity.getBody();
    }

    /**
     * 使用聲明式 FeignClient
     *
     * @param book
     * @return Resources<Book>
     */
    public Book createByFeignClient(Book book) {
        return bookReader.create(book);
    }

    /**
     * 使用聲明式 FeignClient
     *
     * @param bookid
     * @return
     */
    public Resource<Book> getByFeignClient(Integer bookid) {
        return bookReader.get(bookid);
    }
}
