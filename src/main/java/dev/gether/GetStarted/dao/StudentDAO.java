package dev.gether.GetStarted.dao;

import dev.gether.GetStarted.entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);
}
