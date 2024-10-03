package onBoarding.problem2;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean hasDuplicates = true;
        while (hasDuplicates) {
            StringBuilder newCryptogram = new StringBuilder();
            hasDuplicates = false;

            for (int i = 0; i < cryptogram.length(); i++) {
                if (i < cryptogram.length() - 1 && cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    hasDuplicates = true;
                    while (i < cryptogram.length() - 1 && cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                        i++;
                    }
                } else {
                    newCryptogram.append(cryptogram.charAt(i));
                }
            }
            cryptogram = newCryptogram.toString();
        }
        return cryptogram;
    }
}
