package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Course;

import in.ac.charusat.studentmgmtsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/getCourseList")
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    @GetMapping("/getCourse/{id}")
    public Course getStudent(@PathVariable Integer id) {
        return courseRepository.findById(id).get();
    }

    // Delete the student
    @DeleteMapping("/course/{id}")
    public List<Course> deleteStudent(@PathVariable Integer id) {
        courseRepository.delete(courseRepository.findById(id).get());
        return courseRepository.findAll();
    }

    // Add new student
    @PostMapping("/course")
    public List<Course> addStudent(@RequestBody Course course) {
        courseRepository.save(course);
        return courseRepository.findAll();
    }

    // Update the student information
    @PutMapping("/course/{id}")
    public List<Course> updateStudent(@RequestBody Course course, @PathVariable Integer id) {
        Course courseObj = courseRepository.findById(id).get();
        courseObj.setTitle(course.getTitle());
        courseObj.setDescription(course.getDescription());
        courseRepository.save(courseObj);
        return courseRepository.findAll();
    }



}