package com.caito.blogbe.repository;

import com.caito.blogbe.entity.Comment;
import com.caito.blogbe.entity.Post;
import com.caito.blogbe.models.dto.CommentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
