package com.crud.mappings;

import com.crud.mappings.doa.AppDao;
import com.crud.mappings.entity.Course;
import com.crud.mappings.entity.Instructor;
import com.crud.mappings.entity.InstructorDetail;
import com.crud.mappings.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudMappingsApplication {

    public static void main(String[] args) {

        SpringApplication.run(CrudMappingsApplication.class, args);

    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {

            // createInsturctor(appDao);

            // findInstructor(appDao);

            // deleteInstructorById(appDao);

            // findInstructorDetailById(appDao);

            // deleteInstructorDetailById(appDao);

            // createInstructorWithCourses(appDao);

            // findInstructorWithCourses(appDao);

            // findCoursesForInstructor(appDao);

            //  updateInstructor(appDao);

            // updateCourse(appDao);

            // deleteCourseById(appDao);

            // createCourseAndReviews(appDao);

            // retrieveCourseAndReviews(appDao);

            deleteCourseAndReviews(appDao);


        };
    }

    private void deleteCourseAndReviews(AppDao appDao) {

        int courseId = 12;
        System.out.println("Deleting Course id :" + courseId);
        appDao.deleteCourseById(courseId);
        System.out.println("Done !!");
    }

    private void retrieveCourseAndReviews(AppDao appDao) {

        // get the course and reviews
        int id = 12;
        Course tempCourse = appDao.findCourseAndReviewByCourseId(id);

        // print the course
        System.out.println(tempCourse);

        //print the reviews
        System.out.println(tempCourse.getReviews());
        System.out.println("Done !!");
    }

    private void createCourseAndReviews(AppDao appDao) {

        //create a course
        Course tempCourse = new Course("Java 11th Edition Course");

        // add some reviews
        tempCourse.add(new Review("Loved this course"));
        tempCourse.add(new Review("Not too much content"));
        tempCourse.add(new Review("good in-depth knowledge"));

        //save the course and leverage reviews
        System.out.println("Saving the Course");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        appDao.save(tempCourse);
    }

    private void deleteCourseById(AppDao appDao) {

        int courseId = 10;
        System.out.println("Deleting Course id :" + courseId);
        appDao.deleteCourseById(courseId);
        System.out.println("Done !!");
    }

    private void updateCourse(AppDao appDao) {


        //find a Course
        int theId = 10;
        System.out.println("finding the  Course  id" + theId);
        Course theCourse = appDao.findCourseById(theId);

        //update the course
        System.out.println("Updating the Instructor" + theCourse);
        theCourse.setCourse("Beginner to Stock Market");
        appDao.updateCourse(theCourse);

        System.out.println("Done !!");
    }

    private void updateInstructor(AppDao appDao) {

        //find a instructor
        int theId = 2;
        System.out.println("finding the  instructor id" + theId);
        Instructor thInstructor = appDao.findInstructorById(theId);

        //update the instructor
        System.out.println("Updating the Instructor" + thInstructor);
        thInstructor.setLastName("Shukla");
        appDao.update(thInstructor);


    }

    private void findCoursesForInstructor(AppDao appDao) {
        int theId = 2;
        System.out.println("Finding Instructor Id" + theId);

        Instructor tempInstructor = appDao.findInstructorById(theId);
        System.out.println("tempInstructor " + tempInstructor);

        //find course for instructor
        System.out.println("Find Courses for Instructor " + theId);
        List<Course> theCourseList = appDao.findCoursesByInstructorId(theId);

        tempInstructor.setCourses(theCourseList);
        System.out.println("assosiated courses for instructor id" + tempInstructor.getCourses());
    }

    private void findInstructorWithCourses(AppDao appDao) {

        int theId = 2;
        System.out.println("Finding Instructor Id" + theId);

        Instructor tempInstructor = appDao.findInstructorById(theId);
        System.out.println("tempInstructor " + tempInstructor);
        System.out.println("assosiated coureses" + tempInstructor.getCourses());

        System.out.println("Done !!");
    }

    private void createInstructorWithCourses(AppDao appDao) {
        //create the instructor
        Instructor instructor = new Instructor("Susan", "Paul", "susan@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/gsdgfds", "volleyboll");
        instructor.setInstructorDetail(instructorDetail);

        //create some courses
        Course tempCourse = new Course("Beginner for DSA");
        Course tempCourse1 = new Course("Beginner for Java");

        instructor.add(tempCourse);
        instructor.add(tempCourse1);

        //save the instructor
        System.out.println("Saving Instructor" + instructor);
        System.out.println("Saving Courses " + instructor.getCourses());
        appDao.save(instructor);


    }

    private void deleteInstructorDetailById(AppDao appDao) {

        int id = 3;

        System.out.println("Deleting Instructor Detail By Id" + id);

        appDao.deleteInstructorDetailById(id);

        System.out.println("Done");
    }

    private void findInstructorDetailById(AppDao appDao) {

        //get the instructor detail object
        int theId = 2;
        InstructorDetail tempInstructorDetail = appDao.findInstructorDetailById(theId);

        //print the instructor detail
        System.out.println("tempInstructorDetail" + tempInstructorDetail);

        //print the associated instructor
        System.out.println("the assosiated instructor" + tempInstructorDetail.getInstructor());
    }

    private void deleteInstructorById(AppDao appDao) {

        int id = 2;

        appDao.deleteInstructorById(id);

        System.out.println("Done");
    }

    private void findInstructor(AppDao appDao) {

        int id = 1;

        Instructor teInstructor = appDao.findInstructorById(id);

        System.out.println("Instructor Data --------" + teInstructor);
    }

    private void createInsturctor(AppDao appDao) {

        //create the instructor
        Instructor instructor = new Instructor("Ravi", "Sharma", "ravi@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/gsdgfds", "football");
        instructor.setInstructorDetail(instructorDetail);
        appDao.save(instructor);
    }

}
