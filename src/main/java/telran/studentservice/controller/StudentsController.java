package telran.studentservice.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import telran.studentservice.dto.ScoreDto;
import telran.studentservice.dto.StudentDto;
import telran.studentservice.dto.StudentEditDto;
import telran.studentservice.dto.StudentResponseDto;
import telran.studentservice.entity.Student;
import telran.studentservice.service.IStudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentsController {

    @Autowired
    private IStudentService studentService;

    private final static String URI = "/student";


    @GetMapping(URI)
    public Map<Integer, Student> getAllStudents(HttpServletRequest request, HttpServletResponse response) {

        Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        String authValue = getBasicAuth("userUser", "Password123");
        System.out.println(authValue);
        System.out.println(map);
        if (map.get("authorization").equals(authValue)) {
            return studentService.getAllStudents();
        } else return null;


    }


    @PostMapping(URI)
    public boolean addStudent(@RequestBody StudentDto student) {


        return studentService.addStudent(student);
    }

    @DeleteMapping(URI + "/{id}")
    public StudentResponseDto deleteStudent(@PathVariable("id") int id) {
        return studentService.deleteStudent(id);
    }

    @PutMapping(URI + "/{id}")
    public StudentDto editStudent(@PathVariable("id") int id, @RequestBody StudentEditDto student) {
        return studentService.editStudent(id, student);
    }

    @GetMapping(URI + "/{id}")
    public StudentResponseDto getStudent(@PathVariable("id") int id) {
        return studentService.getStudent(id);
    }

    @PutMapping("teacher/{id}")
    public boolean addScore(@PathVariable("id") int id, @RequestBody ScoreDto score) {
        return studentService.addScore(id, score);
    }

    public String getBasicAuth(String username, String password) {
        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));

        return "Basic " + new String(encodedAuth);
    }

}
