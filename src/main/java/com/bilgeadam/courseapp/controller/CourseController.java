package com.bilgeadam.courseapp.controller;

import com.bilgeadam.courseapp.entity.Course;
import com.bilgeadam.courseapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;


    @GetMapping
    public String welcome()
    {
        return "CourseApp ye hoşgeldiniz";
    }


    //@RequestMapping(value = "/courses", method = RequestMethod.GET)
    @GetMapping("/courses")
    public List<Course> getCourses()
    {
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable("id") String courseId)
    {
        Optional<Course> courseOpt = courseRepository.findById(courseId);
        Course course = null;

        if(courseOpt.isPresent())
        {
            course = courseOpt.get();
        }

        return course;
    }


}
