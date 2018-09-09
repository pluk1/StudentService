package telran.studentservice.dto;

import java.util.Map;

public class StudentResponseDto {

    String name;
    int id;
    Map<String, Integer> scores;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Map<String, Integer> getScores() {
        return scores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScores(Map<String, Integer> scores) {
        this.scores = scores;
    }
}
