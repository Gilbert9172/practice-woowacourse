package onBoarding.problem4;

public class Problem4 {

//    private final Map<Integer, Character> upperCase = processingAsciiArray(65, 90);
//    private final Map<Integer, Character> lowerCase = processingAsciiArray(97, 122);
//    private Map<Integer, Character> processingAsciiArray(int start, int end) {
//        Map<Integer, Character> asciiMap = new HashMap<>();
//        for (int i = start; i <= end; i++) {
//            asciiMap.put(i - start, ((char) i));
//        }
//        return asciiMap;
//    }

    public String solution(String input) {
        return convertSentence(input);
    }


    public String convertSentence (String sentence) {
        StringBuilder newSentence = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char letter = sentence.charAt(i);
            newSentence.append(convertLetter(letter));
        }
        return newSentence.toString();
    }

    private char convertLetter(char letter) {
        if (letter >= 'A' && letter <= 'Z') {
            return (char) ('A' + 'Z' - letter);
        } else if (letter >= 'a' && letter <= 'z') {
            return (char) ('a' + 'z' - letter);
        }
        return letter;
    }

//    private void appendLetter(char letter, StringBuilder newSentence) {
//        if (letter >= 65 && letter <= 90) {
//            Character newLetter = upperCase.get(Math.abs(letter - 90));
//            newSentence.append(newLetter);
//        } else if (letter >= 97 && letter <= 122) {
//            Character newLetter = lowerCase.get(Math.abs(letter - 122));
//            newSentence.append(newLetter);
//        } else {
//            newSentence.append(letter);
//        }
//    }
}
