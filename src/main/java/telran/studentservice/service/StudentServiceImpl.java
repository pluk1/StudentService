package telran.studentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import telran.studentservice.dao.IStudentRepository;
import telran.studentservice.dto.ScoreDto;
import telran.studentservice.dto.StudentDto;
import telran.studentservice.dto.StudentEditDto;
import telran.studentservice.dto.StudentResponseDto;
import telran.studentservice.entity.Student;

import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public boolean addStudent(StudentDto student) {
        Student studentEntity = new Student(student.getId(), student.getName(), student.getPassword());
        return studentRepository.addStudent(studentEntity);
    }

    @Override
    public StudentResponseDto deleteStudent(int id) {

        Student student = studentRepository.deleteStudent(id);

        StudentResponseDto responseDto = new StudentResponseDto();
        responseDto.setName(student.getName());
        responseDto.setScores(student.getScores());
        responseDto.setId(student.getId());

        return responseDto;
    }

    @Override
    public StudentDto editStudent(int id, StudentEditDto student) {

        Student studentEntity = studentRepository.getStudentById(id);

        if (student.getName() != null) {
            studentEntity.setName(student.getName());
        }

        if (student.getPassword()!= null){
            studentEntity.setPassword(student.getPassword());

        }
        studentRepository.editStudent(studentEntity);

        StudentDto studentDto = new StudentDto();
        studentDto.setName(studentEntity.getName());
        studentDto.setPassword(studentEntity.getPassword());

        return studentDto;
    }

    @Override
    public StudentResponseDto getStudent(int id) {
        Student studentEntity = studentRepository.getStudentById(id);
        StudentResponseDto studentResponse = new StudentResponseDto();
        studentResponse.setId(studentEntity.getId());
        studentResponse.setName(studentEntity.getName());
        studentResponse.setScores(studentEntity.getScores());

        return studentResponse;
    }

    @Override
    public boolean addScore(int id, ScoreDto score) {
        Student student = studentRepository.getStudentById(id);

        return student.addScore(score.getExamName(),score.getScore());
    }

    @Override
    public Map<Integer, Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
