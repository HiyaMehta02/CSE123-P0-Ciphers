// Hiya Mehta
// 01/30/2025
// CSE 123
// TA : Hayden Feeney

import java.util.*;

// This class allows the user to create a Caesar Key cipher, set 
// the key for encryption/decryption, and encrypt and decrypt 
// messages.
public class CaesarKey extends Substitution {

    // This is a constructor
    // Behavior : 
    //    - creates a new Caesar Key cipher with an the first few 
    //      values set to the key given by the user and randomly 
    //      sets the rest of the values
    // Parameters : 
    //    - key (String): the key that the user wants the string 
    //      to be encoded with
    // Returns : None
    // Exceptions :
    //    - IllegalArgumentException if the key is empty, if the 
    //      key has duplicates, and if the key has an characters 
    //      outside the encodable range.
    public CaesarKey(String key) throws IllegalArgumentException {
        super();
        if (key == null || key.isEmpty() || hasDuplicates(key) || charOutsideRange(key)) {
            throw new IllegalArgumentException();
        }
        String code = key;
        for(int i = MIN_CHAR; i <= MAX_CHAR; i++) {
            if (!(key.contains("" + (char) i))) {
                code += "" + (char) i;
            }
        }
        setEncoding(code);
    }
}
