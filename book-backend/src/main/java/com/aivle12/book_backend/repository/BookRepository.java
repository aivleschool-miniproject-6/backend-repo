package com.aivle12.book_backend.repository;

import com.aivle12.book_backend.domain.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(Long authorId);

    List<Book> findAllByOrderByViewCountDesc(Pageable pageable);

    List<Book> findByPubDateNotNullOrderByPubDateDesc(Pageable pageable);

    @Query(value = "SELECT b.* FROM book b LEFT JOIN comment c ON c.book_id = b.id GROUP BY b.id ORDER BY COALESCE(AVG(c.rating), 0) DESC LIMIT :limit", nativeQuery = true)
    List<Book> findTopByAverageRating(@Param("limit") int limit);
}
