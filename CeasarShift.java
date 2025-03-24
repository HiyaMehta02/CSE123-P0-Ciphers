// Hiya Mehta
// 01/30/2025
// CSE 123
// TA : Hayden Feeney

import java.util.*;

// This class allows the user to create a Caesar Shift cipher, 
// set the number they want to characters to shift by for 
// encryption/decryption, and encrypt and decrypt messages.
public class CaesarShift extends Substitution {

    // This is a constructor
    // Behavior : 
    //    - shifts all the characters by the given shift and sets 
    //      the encoding to it.
    // Parameters : 
    //    - shift (int): an int that is the amount that the 
    //      characters get shifted
    // Returns : None
    // Exceptions : 
    //    - IllegalArgumentException if shift is less than or 
    //      equal to 0
    public CaesarShift(int shift) {
        super();
        if (shift <= 0) {
            throw new IllegalArgumentException("Shift has to be greater than 0");
        }
        String encoding = "";
        for (int i = MIN_CHAR; i <= MAX_CHAR; i++) {
            encoding += (char) i;
        }
        encoding = shiftCode(shift, encoding);
        setEncoding(encoding);
    }

    // Behavior: 
    //     - Shifts the encoding string by the specified 
    //           shift value.
    // Parameters: 
    //     - theShift (int) : The amount that the user wants the 
    //       characters to shift
    //     - theEncoding (String) : The string that has the 
    //       original list of characters before the shift
    // Returns: 
    //     - string : the shifted code
    // Exceptions: None.
    private String shiftCode(int theShift, String theEncoding) {
        String temp = "";
        int shift;
        if (theShift < theEncoding.length()) {
            shift = theShift;
        } else {
            shift = theShift % theEncoding.length();
        }
        for (int i = 0; i < shift; i++) {
            temp += theEncoding.charAt(i);
        }
        return theEncoding.substring(shift, theEncoding.length()) + temp;
    }
}
