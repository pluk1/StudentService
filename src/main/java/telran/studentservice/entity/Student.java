package telran.studentservice.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private String password;
    private Map<String, Integer> scores;

    public Student() {
    }

    public Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.scores = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addScore(String examName, int score){
        return scores.put(examName,score) != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
