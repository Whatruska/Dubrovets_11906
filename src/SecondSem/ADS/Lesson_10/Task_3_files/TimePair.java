package SecondSem.ADS.Lesson_10.Task_3_files;

import SecondSem.ADS.Lesson_10.TimeStamp;

public class TimePair implements Comparable{
    private TimeStamp stamp1;
    private TimeStamp stamp2;

    public TimePair(TimeStamp stamp1, TimeStamp stamp2) {
        this.stamp1 = stamp1;
        this.stamp2 = stamp2;
    }

    public TimeStamp getStamp1() {
        return stamp1;
    }

    public TimeStamp getStamp2() {
        return stamp2;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof TimePair){
            TimePair pair = (TimePair) o;
            return stamp2.compareTo(pair.stamp2);
        }
        return 1;
    }
}
