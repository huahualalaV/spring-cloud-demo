package com.jzj.demo.course.controller;

import com.alibaba.fastjson.JSON;
import com.jzj.demo.common.CourseInfo;
import com.jzj.demo.common.CourseInfosRequest;
import com.jzj.demo.course.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CourseController {
    private final ICourseService courseService;

    @Autowired
    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses/{id}")
    public CourseInfo getCourseInfo(@PathVariable("id") Long id) {
        log.info("<course>: get course -> {}", id);
        return courseService.getCourseInfo(id);
    }

    @PostMapping("/courses")
    public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request) {
        log.info("<course>: get courses -> {}", JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }
}
