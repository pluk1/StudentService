package telran.studentservice.dao;

import org.springframework.stereotype.Repository;
import telran.studentservice.entity.Student;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class StudentRepositoryImpl implements IStudentRepository {
    private Map<Integer, Student> students = new ConcurrentHashMap<>();

    @Override
    public boolean addStudent(Student student) {
        return students.putIfAbsent(student.getId(), student) == null;
    }

    @Override
    public Student deleteStudent(int id) {
        return students.remove(id);
    }

    @Override
    public Student getStudentById(int id) {
        return students.get(id);
    }

    @Override
    public Student editStudent(Student student) {
        return students.replace(student.getId(), student);
    }

    @Override
    public Map<Integer,Student> getAllStudents() {
        return students;
    }
}
