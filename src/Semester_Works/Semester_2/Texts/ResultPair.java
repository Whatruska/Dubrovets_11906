package Semester_Works.Semester_2.Texts;

public class ResultPair {
    private int size;
    private long iters;
    private long time;

    public ResultPair(int size, long iters, long time) {
        this.size = size;
        this.iters = iters;
        this.time = time;
    }

    public int getSize() {
        return size;
    }

    public long getIters() {
        return iters;
    }

    public long getTime() {
        return time;
    }
}
