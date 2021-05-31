package com.app.woofer.repository;

import com.app.woofer.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Integer> {
    List<Likes> findByUserId(int userId);
    List<Likes> findByPostId(int userId);
}
