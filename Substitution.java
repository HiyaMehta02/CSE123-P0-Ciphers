// Hiya Mehta
// 01/30/2025
// CSE 123
// TA: Hayden Feeney

import java.util.*;

// This class allows the user to create a Substitution cipher, 
// set the code for encryption/decryption, and encrypt/decrypt 
// messages.
public class Substitution extends Cipher {

    private String encoding;

    // this is a constructor
    // Behavior : 
    //    - creates a new Substitution cipher with an undefined  
    //      encoding
    // Parameters: None
    // Returns: None
    // Exceptions: None
    public Substitution() {
        this.encoding = "";
    }

    // this is a constructor
    // Behavior : 
    //    - creates a new Substitution cipher with the 
    //              encoding given by the user
    // Parameters : 
    //    - encode (String): the string code that the user wants
    //              to encrypt using.
    // Returns : None
    // Exceptions : 
    //     -  IllegalArgumentException if the encoding is empty,
    //        has a duplicate, is longer than the amount of 
    //        characters they want to encode, or if any 
    //        characters are outside the encodable range.
    public Substitution(String encode) {
        setEncoding(encode);
        this.encoding = encode;
    }

    // Behavior :
    //    - this method checks if a string has any duplicates 
    // Parameters : 
    //    - str (String) : the code that the user wants to set 
    //            as the encoding
    // Returns :
    //    - boolean : true if the string has duplicates and false
    //                if it doesn't
    // Exceptions : None
    public boolean hasDuplicates(String str) {
        Set<Character> seenCharacters = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!seenCharacters.add(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    // Behavior : 
    //     - this method checks if any of the values are outside
    //       the encodable range
    // Parameters : 
    //    - str (String): the code that the user wants to set as 
    //            the encoding
    // Returns :
    //    - boolean : true if the string has values that are 
    //                the encodable range and false if not
    // Exceptions : None
    public boolean charOutsideRange(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > MAX_CHAR || str.charAt(i) < MIN_CHAR) {
                return true;
            }
        }
        return false;
    }

    // Behavior : 
    //     - the method sets the encoding that the user wants
    // Parameters : 
    //    - encode (String): the string code that the user wants
    //              to encrypt using.
    // Returns : None
    // Exceptions : 
    //     -  IllegalArgumentException if the encoding is empty,
    //        has a duplicate, is longer than the amount of 
    //        characters they want to encode, or if any 
    //        characters are outside the encodable range.
    public void setEncoding(String encoding) {
        if (encoding == null || encoding.equals(null) || encoding.length() != TOTAL_CHARS || 
        hasDuplicates(encoding) || charOutsideRange(encoding)) {
            throw new IllegalArgumentException();
        }
        this.encoding = encoding;
    }

    // Behavior : 
    //    -  encrypts the string using the code set by the user
    // Parameters : 
    //    -  input (String) : the string that the user wants 
    //            encrypted
    // Returns :
    //    -  string : the encrypted string
    // Exceptions : 
    //    - IllegalStateException if the encoding was never set
    //    - IllegalArgumentException if the input string is null
    //      or any of the characters in the input are outside the
    //      encodable range
    public String encrypt(String input) {
        if (encoding == "") {
            throw new IllegalStateException();
        }
        if (input == null || charOutsideRange(input)) {
            throw new IllegalArgumentException();
        }
        String encrypted = "";
        for (int i = 0; i < input.length(); i++) {
            encrypted += encoding.charAt((int)input.charAt(i) - MIN_CHAR);
        }
        return encrypted;
    }

    // Behavior : 
    //    -  decrypts the string using the code set by the user
    // Parameters : 
    //    -  input (String) : the string that the user wants 
    //          decrypted
    // Returns :
    //    -  string : the decrypted string
    // Exceptions : 
    //    - IllegalStateException if the encoding was never set
    //    - IllegalArgumentException if the input string is null
    //      or any of the characters in the input are outside the
    //      encodable range
    public String decrypt(String input) {
        if (encoding == "") {
            throw new IllegalStateException();
        }
        if (input == null || charOutsideRange(input)) {
            throw new IllegalArgumentException();
        } 
        String decrypted = "";
        for (int i = 0; i < input.length(); i++) {
            decrypted += (char) (MIN_CHAR + encoding.indexOf(input.charAt(i)));
        }
        return decrypted;
    }
}
