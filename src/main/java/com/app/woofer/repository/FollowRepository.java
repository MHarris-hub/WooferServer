package com.app.woofer.repository;

import com.app.woofer.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
    int countByUser_Id(int id);
    List<Follow> findByFollower_Id(int id);
    List<Follow> findByUser_Id(int id);
}
