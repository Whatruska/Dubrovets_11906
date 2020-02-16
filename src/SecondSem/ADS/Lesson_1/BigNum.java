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

    public boolean isPositive() {
        return isPositive;
    }

    public BigNum(int[] number, int length, boolean isPositive) {
        this.number = number;
        this.length = length;
        this.isPositive = isPositive;
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

    public void sumInt(BigNum num){
        int length2 = num.getLength();
        if (this.length < length2){
            num.sumInt(this);
            this.number = num.getNumber();
            this.length = num.getLength();
        }
        int[] ints1 = this.number;
        int[] ints2 = num.getNumber();
        int ost = 0;
        int[] res = new int[MAX_LENGTH];

        int d = this.length - length2;
        for (int i = 0; i < d; i++){
            shiftRight(ints2, 0);
        }
        for (int i = length - 1; i >= 0; i--){
            int digit1 = ints1[i];
            int digit2 = ints2[i];
            int sum = digit1 + digit2 + ost;
            int result = sum % 10;
            res[i] = result;
            if (i == length && result == 0){
                length++;
            }
            ost = sum / 10;
        }
        if (ost > 0){
            shiftRight(res, ost);
            length++;
        }
        number = res;
    }

    public void sumInt(String str){
        sumInt(new BigNum(str));
    }

    private void shiftLeft(int[] ints){
        for (int i = 1; i < ints.length; i++){
            ints[i - 1] = ints[i];
        }
        ints[ints.length - 1] = 0;
    }

    public void subInt(BigNum num){
        int[] result = new int[MAX_LENGTH];
        int firstIndex = 0;
        int[] ints2 = num.getNumber();
        if (number[0] >= ints2[0]){
            for (int i = number[0]; i >= 0; i--){
                int digit1 = number[i];
                int digit2 = ints2[i];
                if (digit1 < digit2){
                    digit1 += 10;
                    number[i - 1]--;
                }
                int sub = digit1 - digit2;
                if (sub != 0){
                    firstIndex = i;
                }
                result[i] = digit1 - digit2;
            }
            if (firstIndex > 0){
                for (int i = 0; i < firstIndex; i++){
                    shiftLeft(result);
                }
                length -= firstIndex;
            }
        } else {
            num.subInt(this);
            this.isPositive = !isPositive;
            number = num.getNumber();
        }
    }

    //Not finished
//    public static int[] multiplyInts(int[] ints1, int[] ints2){
//        if (ints1[0] < ints2[0]){
//            return multiplyInts(ints2, ints1);
//        }
//        int[] result = new int[101];
//        for (int i = ints2[0], count = 0; i > 0; i--, count++){
//            int elem = ints2[i];
//            int[] s = new int[101];
//            for (int j = 0; j < elem; j++){
//                s = sumInts(s, ints1);
//            }
//            s[0] += count;
//            result = sumInts(result, s);
//        }
//        return result;
//    }

    private void shiftRight(int[] ints, int ost){
        for (int i = ints.length - 1; i > 0; i--){
            ints[i] = ints[i - 1];
        }
        ints[1] = ost;
    }

    @Override
    public String toString() {
        String result = "";
        if (!isPositive){
            result += '-';
        }
        for (int i = 0; i < length; i++){
            result += number[i];
        }
        return result;
    }
}
