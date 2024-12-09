import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

class Student {
    String lastName;
    String firstName;
    int school;
    int score;

    public Student(String lastName, String firstName, int school, int score) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.school = school;
        this.score = score;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }

    public static List<Student> findTopStudents(Map<Integer, List<Student>> schoolData, int schoolId) {
        List<Student> schoolStudents = schoolData.get(schoolId);
        if (schoolStudents == null || schoolStudents.size() < 5) {
            return null;
        }

        Collections.sort(schoolStudents, Comparator.comparingInt(s -> -s.score));

        int topScore = schoolStudents.get(0).score;
        int countTopScore = 0;
        for (Student student : schoolStudents) {
            if (student.score == topScore) {
                countTopScore++;
            } else {
                break;
            }
        }

        if (countTopScore == 1) {
            if(schoolStudents.size() > 1 && schoolStudents.get(1).score != topScore){
                return List.of(schoolStudents.get(0));
            } else {
                return List.of(schoolStudents.get(0));
            }
        } else if (countTopScore == 2) {
            return schoolStudents.subList(0, 2);
        } else {
            return null;
        }
    }
}