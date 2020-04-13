package SecondSem.ADS.Lesson_10;

import java.util.StringTokenizer;

public class TimeStamp implements Comparable {
    int hour;
    int minute;
    int second;

    public TimeStamp(String date) {
        StringTokenizer tokenizer = new StringTokenizer(date);
        hour = Integer.parseInt(tokenizer.nextToken(":"));
        minute = Integer.parseInt(tokenizer.nextToken(":"));
        second = Integer.parseInt(tokenizer.nextToken(":"));
    }

    public TimeStamp() {
        hour = 23;
        minute = 59;
        second = 59;
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof TimeStamp){
            TimeStamp stamp = (TimeStamp) o;
            if (hour > stamp.hour){
                return 1;
            } else if (hour == stamp.hour){
                if (minute > stamp.minute){
                    return 1;
                } else if (minute == stamp.minute){
                    if (second > stamp.second){
                        return 1;
                    } else if (second == stamp.second){
                        return 0;
                    }
                }
            }

            return -1;
        }
        return 1;
    }
}
