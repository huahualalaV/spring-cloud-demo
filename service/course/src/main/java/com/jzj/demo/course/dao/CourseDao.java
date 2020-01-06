package com.jzj.demo.course.dao;

import com.jzj.demo.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
}
