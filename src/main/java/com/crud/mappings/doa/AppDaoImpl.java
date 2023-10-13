package com.crud.mappings.doa;

import com.crud.mappings.entity.Course;
import com.crud.mappings.entity.Instructor;
import com.crud.mappings.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class AppDaoImpl implements AppDao {

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);

    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int Id) {
        return entityManager.find(InstructorDetail.class, Id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        //retrieve instructor detail
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        //remove the assosiated object reference

        //remove bi-directional link
        instructorDetail.getInstructor().setInstructorDetail(null);

        //delete the instructor detail
        entityManager.remove(instructorDetail);

    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;
    }
}
