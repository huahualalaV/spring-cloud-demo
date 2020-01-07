package com.jzj.demo.user.controller;

import com.alibaba.fastjson.JSON;
import com.jzj.demo.common.UserInfo;
import com.jzj.demo.user.service.IUserService;
import com.jzj.demo.user.vo.CreateUserRequest;
import com.jzj.demo.user.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public UserInfo createUser(@RequestBody CreateUserRequest request) {
        log.info("<user>: create user -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }

    @GetMapping("/users/{id}")
    public UserInfo getUserInfo(@PathVariable("id") Long id) {
        log.info("<user>: get user -> {}", id);
        return userService.getUserInfo(id);
    }

    @GetMapping("/userCourses/{id}")
    public UserCourseInfo getUserCourseInfo(@PathVariable("id") Long id) {
        log.info("<user>: get user course info -> {}", id);
        return userService.getUserCourseInfo(id);
    }
}
