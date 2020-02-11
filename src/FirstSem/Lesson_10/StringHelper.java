package FirstSem.Lesson_10;

public class StringHelper {
    public static void main(String[] args) {
        System.out.println(compareTo("abc", "ab"));
        System.out.println(trim("     Hello     "));
        System.out.println(insert("Heo", "ll", 2));
    }

    public static String insert(String s1, String s2, int offset){
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < offset; i++){
            builder.append(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++){
            builder.append(s2.charAt(i));
        }

        for (int i = offset; i < s1.length(); i++){
            builder.append(s1.charAt(i));
        }

        return builder.toString();
    }

    public static int compareTo(String s1, String s2){
        if (s1.equals(s2)){
            return 0;
        } else {
            int result = -1;
            int l = s1.length();
            for (int i = 0; i < l; i++){
                if (i >= s2.length()){
                    return 1;
                }
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(i);
                if (ch1 > ch2){
                    return 1;
                } else if (ch2 > ch1){
                    return -1;
                }
            }
            return result;
        }
    }

    public static String trim(String str){
        StringBuilder builder = new StringBuilder(str);
        while (builder.charAt(0) == ' '){
            builder.deleteCharAt(0);
        }
        builder.reverse();
        while (builder.charAt(0) == ' '){
            builder.deleteCharAt(0);
        }
        return builder.reverse().toString();
    }
}
