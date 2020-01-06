package com.jzj.demo.course.service;

import com.jzj.demo.common.CourseInfo;
import com.jzj.demo.common.CourseInfosRequest;

import java.util.List;

public interface ICourseService {
    CourseInfo getCourseInfo(Long id);
    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}
