package SecondSem.ADS.Lesson_1;

public class BigNum {
    private static final int MAX_LENGTH = 100;

    private int[] number;
    private int length;
    private boolean isPositive;

    public int[] getNumber() {
        return number;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public BigNum(int[] number, int length, boolean isPositive) {
        this.number = number;
        this.length = length;
        this.isPositive = isPositive;
    }

    public BigNum(){
        this(new int[101], 0, true);
    }

    public BigNum(String str){
        this(
                convertToInts(str),
                str.length(),
                str.charAt(0) != '-'
        );
    }

    private static int[] convertToInts(String str){
        int l = str.length();
        int[] ints = new int[MAX_LENGTH];
        for (int i = 0; i < l; i++){
            int ch = str.charAt(i) - '0';
            ints[l - i - 1] = ch;
        }
        return ints;
    }

    public void sum(BigNum bigNum){
        int[] ints2 = bigNum.getNumber();
        int maxInd = Math.max(length, bigNum.length);
        for (int i = 0; i < maxInd; i++){
            number[i] += ints2[i];
        }
        length = maxInd;
        for (int i = 0; i < length; i++){
            int elem = number[i];
            number[i] = elem % 10;
            number[i + 1] += elem / 10;
        }
        int el = number[length];
        int l = getLength(el);
        for (int i = 0; i < l; i++){
            int index = length + i;
            int elem = number[index];
            number[index] = elem % 10;
            number[index + 1] = elem / 10;
            length++;
        }
    }

    public void sum(String str){
        sum(new BigNum(str));
    }

    public void sub(BigNum bigNum) {
        int[] ints2 = bigNum.getNumber();
        if (toString().compareTo(bigNum.toString()) >= 0){
            for (int i = 0; i < length; i++) {
                number[i] -= ints2[i];
                if (number[i] < 0) {
                    number[i + 1]--;
                    number[i] += 10;
                }
            }
        } else {
            bigNum.sub(this);
            isPositive = false;
            number = bigNum.getNumber();
            length = bigNum.getLength();
            number[length - 1] = -number[length - 1];
        }
    }

    public void sub(String str){
        sub(new BigNum(str));
    }

    public void multiplyToScalar(int a){
        for (int i = 0; i < length; i++){
            number[i] *= a;
        }
        for (int i = 0; i < length; i++){
            int elem = number[i];
            number[i] = elem % 10;
            number[i + 1] += elem / 10;
        }
        int el = number[length];
        int l = getLength(el);
        for (int i = 0; i < l; i++){
            int index = length + i;
            int elem = number[index];
            number[index] = elem % 10;
            number[index + 1] = elem / 10;
            length++;
        }
    }

    private void multiplyToFactor(int a, int b){
        for (int i = length - 1; i > 0; i--){
            number[i + b] = number[i];
        }
        length += b;
        multiplyToScalar(a);
    }

    private void multiply(BigNum num){
        BigNum r = new BigNum();
        r.sum(this);
        for (int i = 0; i < length; i++){
            BigNum n = new BigNum();
            n.sum(r);
            n.multiplyToFactor(number[i],i);
            sum(n);
        }
    }

    private int getLength(int a){
        int count = 0;
        while (a > 0){
            a /= 10;
            count++;
        }
        return count;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < length; i++){
            result += number[length - i - 1];
        }
        return result;
    }
}
