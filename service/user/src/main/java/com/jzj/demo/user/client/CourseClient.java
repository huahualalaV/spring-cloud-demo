package com.jzj.demo.user.client;

import com.jzj.demo.common.CourseInfo;
import com.jzj.demo.common.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "eureka-client-course", fallback = CourseClientHystrix.class)
public interface CourseClient {

    @GetMapping("/course/courses/{id}")
    CourseInfo getCourseInfo(@PathVariable Long id);

    @PostMapping("/course/courses")
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);
}
