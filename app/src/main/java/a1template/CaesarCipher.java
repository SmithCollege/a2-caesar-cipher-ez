// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

public class CaesarCipher {

    /** Character array to store the letters in the alphabet in order */
    Character[] alphabet;
    Character[] cleanAlphabet;

    /** DynamicArray object providing ArrayList-like operations for Characters */
    DynamicArray<Character> cipher;
    DynamicArray<Character> cleanCipher;

    /** Private offset that tracks how many positions to shift the index for
    * This cipher */
    private int offset;

    /** Constructor that should define the instance variables, including
     * populating the alphabet
     * @param offset Offset to use when creating `cipher` of DynamicArray type
     */
    CaesarCipher(int offset){
        this.cleanAlphabet = new Character[26];
        for (int i = 0; i < 26; i++) {
            cleanAlphabet[i] = Character.valueOf((char) ('a' + i));
        } 

        this.alphabet = new Character[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = Character.valueOf((char) ('a' + i - offset));
            if(i < offset){
                alphabet[i] = Character.valueOf((char) ('a' + i + 26 - offset));
            }
        } 
        this.offset = offset; 
        this.cipher = new DynamicArray(alphabet.length, alphabet);
        this.cleanCipher = new DynamicArray(cleanAlphabet.length, cleanAlphabet);
    }

    /** Implementation of linear search that looks through the alphabet
     * array to identify the position of the passed value
     * @param val character to search for
     * @return int indicating position of val in the alphabet array
     */
    public int findIndex(char val){
        for(int i = 0; i < this.alphabet.length; i++){
            if(val == alphabet[i]){
                return i;
            } else {
                continue;
            }
        }
        return -1; 
    }

    /** Encode a message using the cipher
     * @param T message to encode
     * @return encoded message */  
    public String encode(String message){
        Character array[] = new Character[message.length()];
        DynamicArray<Character> dynamicArray = new DynamicArray(message.length(), array);
        for(int i = 0; i < message.length(); i++){
            for(int a = 0; a < 26; a++){
                if(message.charAt(i) == cleanAlphabet[a]){
                    if((this.findIndex(message.charAt(i)) - this.offset) < 0){
                        dynamicArray.set(i, alphabet[26 + (this.findIndex(message.charAt(i)) - this.offset)]);
                        break;
                    } else {
                        dynamicArray.set(i, alphabet[this.findIndex(message.charAt(i)) - this.offset]);
                        break;
                    }
                } else {
                  dynamicArray.set(i, message.charAt(i));  
                }
            }
        }
        String finalString = "";
        for(int i = 0; i < message.length(); i++){
            finalString += dynamicArray.get(i);
        }
        return finalString; 
     }

    /** Decode a message using the cipher 
     * @param String message to decode
     * @param int key to use in decoding
     * @return decoded message
    */
    public String decode(String message){
        Character array[] = new Character[message.length()];
        DynamicArray<Character> dynamicArray = new DynamicArray(message.length(), array);
        for(int i = 0; i < message.length(); i++){
            for(int a = 0; a < 26; a++){
                if(message.charAt(i) == cleanAlphabet[a]){
                    if((this.findIndex(message.charAt(i))) + offset > 25){
                        System.out.println(26 - (this.findIndex(message.charAt(i)) + offset));
                        dynamicArray.set(i, alphabet[((this.findIndex(message.charAt(i)) + offset)) - 26]);
                        System.out.println("checkpoint");
                        break;
                    } else {
                        dynamicArray.set(i, alphabet[this.findIndex(message.charAt(i)) + offset]);
                        break;
                    }
                } else {
                  dynamicArray.set(i, message.charAt(i)); 
                }
            }
        }
        String finalString = "";
        for(int i = 0; i < message.length(); i++){
            finalString += dynamicArray.get(i);
        }
        return finalString; 
    }

    public char get(int y){
        return cipher.get(y);
    }

    public static void main(String[] args) {
        CaesarCipher cs = new CaesarCipher(4);
        String string = "white xylophone yellow zipper";
        String string2 = "stuv";
        System.out.println("The first index is " + string.charAt(0));
        for(int i = 0; i < 26; i++){
            System.out.println(i + " " + cs.alphabet[i]);
        }
        System.out.println("The encoded string is: " + cs.encode(string));
        System.out.println("The decoded string is: " + cs.decode(string2));
    }
    
}
