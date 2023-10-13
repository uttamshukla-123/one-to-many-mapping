package com.crud.mappings;

import com.crud.mappings.doa.AppDao;
import com.crud.mappings.entity.Course;
import com.crud.mappings.entity.Instructor;
import com.crud.mappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

            createInstructorWithCourses(appDao);


        };
    }

    private void createInstructorWithCourses(AppDao appDao) {
        //create the instructor
        Instructor instructor = new Instructor("Susan", "Paul", "susan@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/gsdgfds", "volleyboll");
        instructor.setInstructorDetail(instructorDetail);

        //create some courses
        Course tempCourse=new Course("Beginner for DSA");
        Course tempCourse1=new Course("Beginner for Java");

        instructor.add(tempCourse);
        instructor.add(tempCourse1);

        //save the instructor
        System.out.println("Saving Instructor"+instructor);
        System.out.println("Saving Courses "+instructor.getCourses());
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

        int id = 1;

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
