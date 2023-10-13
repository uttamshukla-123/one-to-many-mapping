package com.crud.mappings.doa;

import com.crud.mappings.entity.Instructor;
import com.crud.mappings.entity.InstructorDetail;

public interface AppDao {

    void save(Instructor instructor);

    Instructor  findInstructorById(int id);

    void  deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int Id);

    void  deleteInstructorDetailById(int id);
}
