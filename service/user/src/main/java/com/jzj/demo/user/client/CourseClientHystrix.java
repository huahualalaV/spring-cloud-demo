package com.jzj.demo.user.client;

import com.jzj.demo.common.CourseInfo;
import com.jzj.demo.common.CourseInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CourseClientHystrix implements CourseClient {

    @Override
    public CourseInfo getCourseInfo(Long id) {
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
