package com.app.woofer.repository;

import com.app.woofer.model.Comment;
import com.app.woofer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findByPost_Id(int id);
    List<Comment> findByPost_User_Id(int id);
}
