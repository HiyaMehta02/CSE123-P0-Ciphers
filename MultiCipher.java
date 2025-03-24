// Hiya Mehta
// 01/30/2025
// CSE 123
// TA : Hayden Feeney

import java.util.*;

// This class implements a multi-layer encryption and decryption 
// scheme by combining multiple ciphers. It allows for the 
// sequential encryption and decryption of input data using a 
// list of ciphers, applying each cipher in the given order for 
// encryption, and in reverse order for decryption. The input is 
// processed through each cipher in the list, enabling complex 
// encryption techniques.
public class MultiCipher extends Cipher {

    private List<Cipher> ciphers;
    
    // This is a constructor
    // Behavior : 
    //    - creates a new MultiCipher with the list of Ciphers
    //      given by the user
    // Parameters : 
    //    - ciphers (List<Cipher>) : a list of ciphers that the 
    //      user wants to encrypt/decrypt based on 
    // Returns : None
    // Exceptions : 
    //    - IllegalArgumentException if ciphers is empty
    public MultiCipher(List<Cipher> ciphers) {
        if (ciphers == null) {
            throw new IllegalArgumentException();
        }
        this.ciphers = ciphers;
    }

    // Behavior : encrypt based on the given ciphers list
    // Parameters : 
    //     - input (String) : the string that the user wants to 
    //       encrypt
    // Returns : 
    //     - string : the encrypted string
    // Exceptions : 
    //     - IllegalArgumentException if input is empty
    @Override
    public String encrypt(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String code = input;
        for (Cipher temp : ciphers) {
            code = temp.encrypt(code);
        }
        return code;
    }

    // Behavior : decrypt based on the given ciphers list
    // Parameters : 
    //     - input (String) : the string that the user wants to 
    //       decrypt
    // Returns : 
    //     - string : the decrypted string
    // Exceptions : 
    //     - IllegalArgumentException if input is empty
    @Override
    public String decrypt(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        String code = input;
        for (int i = ciphers.size() - 1; i >= 0; i--) {
            code = ciphers.get(i).decrypt(code);
        }
        return code;
    }
}
