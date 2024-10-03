package seasonFive.onBoarding.problem6;

import java.util.*;

public class Problem6 {

    public List<String> solution(List<List<String>> input) {
        Map<String, Set<String>> toekenMap = new HashMap<>();
        List<Student> students = convertToStudents(input);
        for (Student student : students) {
            tokenize(toekenMap, student);
        }
        return findDuplicatedStudents(toekenMap);
    }

    private List<Student> convertToStudents(List<List<String>> input) {
        List<Student> students = new ArrayList<>();
        for (List<String> strings : input) {
            students.add(new Student(strings.get(1), strings.get(0)));
        }
        return students;
    }

    private List<String> findDuplicatedStudents(Map<String, Set<String>> toekenMap) {
        Set<String> duplicatedNickname = new HashSet<>();
        for (Map.Entry<String, Set<String>> entry : toekenMap.entrySet()) {
            if (entry.getValue().size() > 1) duplicatedNickname.addAll(entry.getValue());
        }
        return duplicatedNickname.stream().sorted().toList();
    }

    public void tokenize(Map<String, Set<String>> toekenMap, Student student) {
        for (int maxLength = 2; maxLength <= student.getNickname().length(); maxLength++) {
            int charIdx = 0;
            createToken(toekenMap, maxLength, charIdx, student, new StringBuilder());
        }
    }

    public void createToken(Map<String, Set<String>> toekenMap, int maxLength, int charIdx, Student student, StringBuilder tokenBuilder) {
        String nickname = student.getNickname();
        String email = student.getEmail();
        while (charIdx < nickname.length()) {
            tokenBuilder.append(nickname.charAt(charIdx));
            String token = tokenBuilder.toString();
            if (token.length() == maxLength) {
                updateOrPut(toekenMap, token, email);
                tokenBuilder.deleteCharAt(0);
            }
            charIdx ++;
        }
    }

    private void updateOrPut(Map<String, Set<String>> toekenMap, String token, String email) {
        if (toekenMap.containsKey(token)) {
            toekenMap.get(token).add(email);
        } else {
            toekenMap.put(token, new HashSet<>());
            toekenMap.get(token).add(email);
        }
    }
}
