package leetcode;

public class Solution205 {
    public static void main(String[] args) {
        String s = "bbbaaaba";
        String t = "aaabbbba";

        System.out.println(isIsomorphic(s, t)); // true
    }

    public static boolean isIsomorphic(String s, String t) {

        int[] mapS = new int[256]; // ASCII values
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {

            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapS[charS] != mapT[charT]) {
                return false;
            }

            mapS[charS] = i + 1; // Store index + 1
            mapT[charT] = i + 1;
        }

        return true;
    }
}


//Map<Character, Character> mapS = new HashMap<>();
//Map<Character, Character> mapT = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//char charS = s.charAt(i);
//char charT = t.charAt(i);
//
//        if (mapS.containsKey(charS) && mapS.get(charS) != charT)
//        return false;
//
//        if (mapT.containsKey(charT) && mapT.get(charT) != charS)
//        return false;
//
//        mapS.put(charS, charT);
//        mapT.put(charT, charS);
//    }
//
//            return true;
