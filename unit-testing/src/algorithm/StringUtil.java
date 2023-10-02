package algorithm;

public class StringUtil {

    public static int toIntFromString(String str) {
        char[] strArr = str.toCharArray();
        int base = 0;

        for (char c : strArr) {
            base *= 10;
            base += c - '0';
        }
        return base;
    }

    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while( left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left ++;
            right --;
        }
        return new String(charArray);
    }

    public static boolean uniqueCharacterInString(String str) {
        char[] charArray = str.toCharArray();
        for( int i = 0; i < charArray.length - 1; i++) {
            for( int j = i + 1; j < charArray.length; j++) {
                if( charArray[i] == charArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
