package com.jzj.demo.course.service.impl;

import com.jzj.demo.common.CourseInfo;
import com.jzj.demo.common.CourseInfosRequest;
import com.jzj.demo.course.dao.CourseDao;
import com.jzj.demo.course.entity.Course;
import com.jzj.demo.course.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
public class CourseServiceImpl implements ICourseService {

    private final CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public CourseInfo getCourseInfo(Long id) {
        Optional<Course> course = courseDao.findById(id);
        return buildCourseInfo(course.orElse(Course.invalid()));
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        if (CollectionUtils.isEmpty(request.getIds())) {
            return Collections.emptyList();
        }

        List<Course> courses = courseDao.findAllById(request.getIds());
        return courses.stream()
                .map(this::buildCourseInfo)
                .collect(toList());
    }

    private CourseInfo buildCourseInfo(Course course) {
        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseType(course.getCourseType() == 0 ? "免费课程" : "实战课程")
                .courseIcon(course.getCourseIcon())
                .courseIntro(course.getCourseIntro())
                .build();
    }
}
