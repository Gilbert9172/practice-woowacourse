package problem1;

import java.util.Arrays;

public class Problem1 {
    public static int solution(int[] pobi, int[] crong) {
        BookPages pobisBookPages = new BookPages(pobi[0], pobi[1]);
        BookPages crongsBookPages = new BookPages(crong[0], crong[1]);

        // 예외 처리
        if (!pobisBookPages.isContinuousPages() || !crongsBookPages.isContinuousPages())
            return Problem1Exception.NotContinuouslyException();
        if (!pobisBookPages.isFindablePages() || !crongsBookPages.isFindablePages())
            return Problem1Exception.PageNotFoundException();

        Problem1 solution = new Problem1();
        return solution.matchResult(pobisBookPages.getMaxScore(), crongsBookPages.getMaxScore());
    }

    public int matchResult(int pobisScore, int corngsScore) {
        if (pobisScore > corngsScore) {
            return MatchResult.POBI_WIN.val;
        }
        if (pobisScore < corngsScore) {
            return MatchResult.CRONG_WIN.val;
        }
        return MatchResult.DRAW.val;
    }

    public enum MatchResult {
        POBI_WIN(1),
        CRONG_WIN(2),
        DRAW(0),
        NO_RESULT(-1);
        final int val;

        MatchResult(int val) {
            this.val = val;
        }
    }

    public static class BookPages {
        int leftPage;
        int rightPage;

        public BookPages() {}

        public BookPages(int leftPage, int rightPage) {
            this.leftPage = leftPage;
            this.rightPage = rightPage;
        }

        public boolean isContinuousPages() {
            return rightPage - leftPage == 1;
        }

        public boolean isFindablePages() {
            return leftPage > -1 && leftPage < 401 && rightPage > -1 && rightPage < 401;
        }

        public int calculateLength() {
            int leftPageLength = String.valueOf(leftPage).length();
            int rightPageLength = String.valueOf(rightPage).length();
            return leftPageLength + rightPageLength;
        }

        public int[] preprocessPages() {
            String pagesToString = toString(leftPage) + toString(rightPage);
            int calculateLength = calculateLength();
            int[] pageArr = new int[calculateLength];
            for (int i = 0; i < calculateLength; i++) {
                pageArr[i] = pagesToString.charAt(i) - '0';
            }
            return pageArr;
        }

        public String toString(int page) {
            return String.valueOf(page);
        }

        public int addAllElements(int[] nums) {
            return Arrays.stream(nums).sum();
        }

        public int multiplyAllElements(int[] nums) {
            return Arrays.stream(nums).reduce((x, y) -> x * y).orElse(0);
        }


        public int getMaxScore() {
            int[] preprocessedPages = preprocessPages();
            return Math.max(addAllElements(preprocessedPages), multiplyAllElements(preprocessedPages));
        }
    }

    public static class Problem1Exception {
        public static int NotContinuouslyException() {
            return MatchResult.NO_RESULT.val;
        }

        public static int PageNotFoundException() {
            return MatchResult.NO_RESULT.val;
        }
    }
}
