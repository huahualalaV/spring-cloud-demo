package com.jzj.demo.user.dao;

import com.jzj.demo.user.entity.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCourseDao extends JpaRepository<UserCourse, Long> {
    List<UserCourse> findAllByUserId(Long userId);
}
