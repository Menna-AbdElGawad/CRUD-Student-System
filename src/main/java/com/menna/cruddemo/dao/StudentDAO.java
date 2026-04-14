package com.menna.cruddemo.dao;

import com.menna.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student student);
    public void update(Student student);
    public void updateById(Student student, String name, int id);
    public void delete(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String name);


}
