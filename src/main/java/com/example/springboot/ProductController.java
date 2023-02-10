package com.example.springboot;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
class ProductController {

  private final ProductRepository repository;

  ProductController(ProductRepository repository) {
    this.repository = repository;
  }

  @QueryMapping
  Product product(@Argument String id) {
    return repository.findById(Long.parseLong(id)).orElseThrow(() -> new ProductNotFoundException(id));
  }
}