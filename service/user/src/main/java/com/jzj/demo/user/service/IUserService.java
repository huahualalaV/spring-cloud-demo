package com.jzj.demo.user.service;

import com.jzj.demo.common.UserInfo;
import com.jzj.demo.user.vo.CreateUserRequest;
import com.jzj.demo.user.vo.UserCourseInfo;

public interface IUserService {
    UserInfo createUser(CreateUserRequest request);
    UserInfo getUserInfo(Long id);
    UserCourseInfo getUserCourseInfo(Long id);
}
