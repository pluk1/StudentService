package telran.studentservice.service;

import telran.studentservice.dto.ScoreDto;
import telran.studentservice.dto.StudentDto;
import telran.studentservice.dto.StudentEditDto;
import telran.studentservice.dto.StudentResponseDto;
import telran.studentservice.entity.Student;

import java.util.Map;


public interface IStudentService {

    boolean addStudent(StudentDto student);
    StudentResponseDto deleteStudent(int id);
    StudentDto editStudent(int id, StudentEditDto student);
    StudentResponseDto getStudent(int id);
    boolean addScore(int id, ScoreDto score);

    Map<Integer,Student> getAllStudents();


}
