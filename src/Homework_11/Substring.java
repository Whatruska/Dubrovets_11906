package Homework_11;

public class Substring {
    public static void main(String[] args) {
        System.out.println(replaceAll("Helloooooel", "el", "Виталий"));
    }

    public static int indexOf(String string, String sub){
        int result = -1;
        int length = string.length();
        for (int i = 0; i < length; i++){
            if (length - i < sub.length()){
                return result;
            }
            int res = sub(string, i, sub);
            if (res != -1){
                return res;
            }
        }
        return result;
    }

    private static int sub(String string, int start, String sub){
        int result = -1;
        String s = "";
        int length = sub.length();
        for (int i = start; i < start + length; i++){
            s += string.charAt(i);
        }
        if (sub.equals(s)){
            result = start;
        }
        return result;
    }

    public static String replace(String s, String t, String u){
        int index = indexOf(s, t);
        int length = t.length();
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < length; i++){
            builder.deleteCharAt(index);
        }
        int uLength = u.length();
        for (int i = index; i < index + uLength; i++){
            builder.insert(i,u.charAt(i - index));
        }
        return builder.toString();
    }

    public static String replaceAll(String s, String t, String u){
        String str = s;
        int index = indexOf(str, t);
        while (index != -1){
            str = replace(str, t, u);
            index = indexOf(str,t);
        }
        return str;
    }
}
