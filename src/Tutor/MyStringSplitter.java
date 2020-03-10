package Tutor;

public class MyStringSplitter {
    private String str;

    public MyStringSplitter(String str) {
        this.str = str;
    }

    public String[] getTokens(char delimiter){
        int size = 0;
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch == delimiter){
                size++;
            }
        }
        String[] tokens = new String[size + 1];
        String s = "";
        int k = 0;
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch == delimiter){
                if (!s.equals("")){
                    tokens[k] = s;
                    k++;
                }
                s = "";
            } else {
                s += ch;
            }
        }
        tokens[k] = s;
        return trimToSize(tokens);
    }

    private String[] trimToSize(String[] arr){
        int s = 0;
        for (int i = 0; i < arr.length; i++){
            if (!(arr[i] == null || arr[i].equals(""))){
                s++;
            }
        }
        String[] result = new String[s];
        for (int i = 0; i < s; i++){
            result[i] = arr[i];
        }
        return result;
    }
}
