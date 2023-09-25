public class StringCompression {
    public static int compress(char[] chars) {
        int counter = 0;
        char repeatedChar = chars[0];
        StringBuilder s = new StringBuilder("");

        for(char ch : chars) {
            if(ch == repeatedChar) counter++;
            else {
                if(counter > 1) s.append(repeatedChar + "" + counter);
                else s.append(repeatedChar);
                counter = 1;
                repeatedChar = ch;
            }
        }
        
        if(counter > 1) s.append(repeatedChar + "" + counter);
        else s.append(repeatedChar);

        for(int i = 0; i < chars.length; i++) {
            if(i < s.length()) chars[i] = s.charAt(i);
            else chars[i] = ' ';
        }

        System.out.println(chars);
        return s.length();
    
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','c','c','c','c','c','c','d','e'};
        System.out.println(compress(chars));
    }
}
