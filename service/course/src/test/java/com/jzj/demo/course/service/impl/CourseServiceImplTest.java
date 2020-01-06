package com.jzj.demo.course.service.impl;

import com.alibaba.fastjson.JSON;
import com.jzj.demo.common.CourseInfo;
import com.jzj.demo.common.CourseInfosRequest;
import com.jzj.demo.course.service.ICourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CourseServiceImplTest {

    @Autowired
    private ICourseService courseService;

    @Test
    public void getCourseInfo() {
        CourseInfo courseInfo = courseService.getCourseInfo(1L);
        System.out.println(courseInfo);
    }

    @Test
    public void getCourseInfos() {
        CourseInfosRequest request = new CourseInfosRequest(Arrays.asList(1L, 2L));
        List<CourseInfo> courseInfos = courseService.getCourseInfos(request);
        String jsonString = JSON.toJSONString(courseInfos);
        System.out.println(jsonString);
    }
}
