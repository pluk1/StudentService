package telran.studentservice.dao;

import telran.studentservice.entity.Student;

import java.util.List;
import java.util.Map;

public interface IStudentRepository {

    boolean addStudent(Student student);
    Student deleteStudent(int id);
    Student getStudentById(int id);
    Student editStudent(Student student);
    Map<Integer,Student> getAllStudents();
}
