package humber.cpan205na.controller;

/**
 * Created by ivan on 15/11/15.
 */
public class DataGenerator {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";


    public static String getWord(int _len) {
        String result = "";
        int idx = 0;

        for(int i = 0; i <= _len; i++) {
            idx = (int)(Math.random() * ALPHABET.length());
            result += ALPHABET.charAt(idx);
        }

        return result;
    }

}
