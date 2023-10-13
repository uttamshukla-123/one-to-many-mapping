package com.crud.mappings.doa;

import com.crud.mappings.entity.Course;
import com.crud.mappings.entity.Instructor;
import com.crud.mappings.entity.InstructorDetail;

import java.util.List;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int Id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int theId);

    void update(Instructor instructor);

    void updateCourse(Course course);

    Course findCourseById(int theId);

    void deleteCourseById(int id);
     void save(Course course);

     Course findCourseAndReviewByCourseId(int courseId);


}
