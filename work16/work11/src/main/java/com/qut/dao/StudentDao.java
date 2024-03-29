package com.qut.dao;

import com.qut.domain.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectStudents();

    int insertStudent(Student student);

    int updateStudent(Student student);
    int deleteStudent(int id);
}
