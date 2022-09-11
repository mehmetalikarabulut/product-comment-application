package com.works.commentapplication.repositories;

import com.works.commentapplication.entities.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Integer> {
    List<ProductComment> findByProduct_Id(Integer id);

    List<ProductComment> findByCreatedTimeBetween(Date createdDate, Date endedDate);

    List<ProductComment> findByUser_Id(Integer id);
}