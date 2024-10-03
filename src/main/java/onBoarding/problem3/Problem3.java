package onBoarding.problem3;

public class Problem3 {

    public int solution(int num) {
        int clapCount = 0;
        for (int i = 1; i <= num; i++) clapCount += countTargets(i);
        return clapCount;
    }

    private int countTargets(int num) {
        int targetCount = 0;
        String numToSting = String.valueOf(num);
        for (int i = 0; i < numToSting.length(); i++) {
            int digit = numToSting.charAt(i) - '0';
            if (digit == 3 || digit == 6 || digit == 9) targetCount++;
        }
        return targetCount;
    }

    private int countTargetsV2(int num) {
        int targetCount = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 3 || digit == 6 || digit == 9) targetCount++;
            num /= 10;
        }
        return targetCount;
    }
}
