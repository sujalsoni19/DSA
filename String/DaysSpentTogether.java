package leetcode.String;

// LC 2409. Count Days Spent Together
// POTD - 24, october 2026

public class DaysSpentTogether {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int aStart = convert(arriveAlice);
        int aEnd = convert(leaveAlice);
        int bStart = convert(arriveBob);
        int bEnd = convert(leaveBob);

        int start = Math.max(aStart, bStart);
        int end = Math.min(aEnd, bEnd);

        if (start > end) {
            return 0;
        }

        return end - start + 1;
    }

    private int convert(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int total = day;

        for (int m = 1; m < month; m++) {
            total += daysInMonth(m);
        }

        return total;
    }

    private int daysInMonth(int month) {
        if (month == 2) {
            return 28;
        }

        if (month == 4 || month == 6 ||
                month == 9 || month == 11) {
            return 30;
        }

        return 31;
    }
}