package com.crud_operations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud_operations.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
  List<Book> findByPublished(boolean published);

  List<Book> findByTitleContaining(String title);
}