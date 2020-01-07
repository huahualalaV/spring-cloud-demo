package com.jzj.demo.user.service.impl;

import com.jzj.demo.common.CourseInfo;
import com.jzj.demo.common.CourseInfosRequest;
import com.jzj.demo.common.UserInfo;
import com.jzj.demo.user.client.CourseClient;
import com.jzj.demo.user.dao.UserCourseDao;
import com.jzj.demo.user.dao.UserDao;
import com.jzj.demo.user.entity.User;
import com.jzj.demo.user.entity.UserCourse;
import com.jzj.demo.user.service.IUserService;
import com.jzj.demo.user.vo.CreateUserRequest;
import com.jzj.demo.user.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final UserDao userDao;
    private final UserCourseDao userCourseDao;
    private final CourseClient courseClient;

    @Autowired
    public UserServiceImpl(UserDao userDao,
                           UserCourseDao userCourseDao,
                           CourseClient courseClient) {
        this.userDao = userDao;
        this.userCourseDao = userCourseDao;
        this.courseClient = courseClient;
    }

    @Override
    public UserInfo createUser(CreateUserRequest request) {
        if (!request.validate()) {
            return UserInfo.invalid();
        }
        Optional<User> foundUser = userDao.findByUsername(request.getUsername());
        if (foundUser.isPresent()) {
            return UserInfo.invalid();
        }
        User savedUser = userDao.save(new User(request.getUsername(), request.getEmail()));
        return new UserInfo(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    @Override
    public UserInfo getUserInfo(Long id) {
        Optional<User> foundUser = userDao.findById(id);
        if (!foundUser.isPresent()) {
            return UserInfo.invalid();
        }
        User currentUser = foundUser.get();
        return new UserInfo(currentUser.getId(), currentUser.getUsername(), currentUser.getEmail());
    }

    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {
        Optional<User> foundUser = userDao.findById(id);
        if (!foundUser.isPresent()) {
            return UserCourseInfo.invalid();
        }
        User currentUser = foundUser.get();
        UserInfo userInfo = new UserInfo(currentUser.getId(), currentUser.getUsername(), currentUser.getEmail());

        List<UserCourse> userCourses = userCourseDao.findAllByUserId(id);
        if (CollectionUtils.isEmpty(userCourses)) {
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }
        CourseInfosRequest request = new CourseInfosRequest(userCourses.stream()
                .map(UserCourse::getCourseId)
                .collect(Collectors.toList()));
        List<CourseInfo> courseInfos = courseClient.getCourseInfos(request);
        return new UserCourseInfo(userInfo, courseInfos);
    }
}
