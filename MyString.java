/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        System.out.println(subsetOf("sap","space"));
        System.out.println(subsetOf("spa","space"));
        System.out.println(subsetOf("pass","space"));
        System.out.println(subsetOf("c","space"));
        System.out.println(randomStringOfLetters(3) );
        System.out.println(remove("meet","committee"));
        System.out.println(insertRandomly('s',"cat"));
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int counter = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ch)
            counter++;
        }
        return counter;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        for(int i=0; i<str1.length(); i++){ // ("pass"
            for(int j=0; j<str2.length(); j++){ // ,"space")
                if (str1.charAt(i) == str2.charAt(j)) {
                    int cheackStr1 = countChar(str1, str1.charAt(i));
                    int cheackStr2 = countChar(str2, str2.charAt(j));
                    if (cheackStr1 != cheackStr2) {
                        return false;
                   }
                    break;
                }
            }
        }
        return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
       String NewStr = "";
       for(int i=0; i<str.length(); i++){
        NewStr += str.charAt(i);
        if (i == str.length()-1) {
            return NewStr;
        }
        NewStr += " ";
       }
        return NewStr;
    }

    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
       String str = "";
       char c;
        for(int i =0; i<n; i++){
        double random = (Math.random()) * 26;
        c = (char)('a' + random);
        str += c;
        }
        return str;
    }

    public static int index(String str1, String str2) {
        for(int i=0; i< str1.length(); i++){
            for(int j=0; j<str2.length(); j++)
                if (str2.charAt(j) == str1.charAt(i)){
                   return j;
            }    
        }
        return -1;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * "meet","comimttee"
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove1(String str1, String str2) {
        if (str1 == "") {
            return str2;
        }
        if (str2 == "") {
            return str2;
        }
        char[] charArray = new char[str1.length()];
        String Newstring = "";
        for(int i=0; i<str1.length(); i++){
            charArray[i] = str1.charAt(i);
        }
        for(int i=0; i<str2.length(); i++){
            for(int j=0; j<charArray.length; j++){
                if (str2.charAt(i) == charArray[j]) {
                    charArray[j] = 0;
                    break;
                }
                if (str2.charAt(i) != charArray[j] && j == charArray.length-1)
                Newstring += str2.charAt(i);
            }
        }
    return Newstring;
}
public static String remove(String str2, String str1) {
    if (str1 == "") {
        return str2;
    }
    if (str2 == "") {
        return str2;
    }
    char[] charArray = new char[str1.length()];
    String Newstring = "";
    for(int i=0; i<str1.length(); i++){
        charArray[i] = str1.charAt(i);
    }
    for(int i=0; i<str2.length(); i++){
        for(int j=0; j<charArray.length; j++){
            if (str2.charAt(i) == charArray[j]) {
                charArray[j] = 0;
                break;
            }
            if (str2.charAt(i) != charArray[j] && j == charArray.length-1)
            Newstring += str2.charAt(i);
        }
    }
return Newstring;
}
    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
