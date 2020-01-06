package com.jzj.demo.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.usertype.CompositeUserType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Basic
    @Column(name = "course_type", nullable = false)
    private Integer courseType;// 0免费课 1实战课

    @Basic
    @Column(name = "course_icon", nullable = false)
    private String courseIcon;

    @Basic
    @Column(name = "course_intro", nullable = false)
    private String courseIntro;

    @Basic
    @Column(name = "createTime", nullable = false)
    @CreatedDate
    private Date createTime;

    @Basic
    @Column(name = "updateTime", nullable = false)
    @LastModifiedDate
    private Date updateTime;

    public Course(String courseName, Integer courseType, String courseIcon, String courseIntro) {
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseIcon = courseIcon;
        this.courseIntro = courseIntro;
    }

    public static Course invalid() {
        Course course = new Course("", 0, "", "");
        course.setId(-1L);
        return course;
    }
}
