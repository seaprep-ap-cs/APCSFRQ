package exam.five.question1;

// Exam #5 Question 1

public class Cipher
{
    private static final String abc = "abcdefghijklmnopqrstuvwxyz";
    //private static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /********************* Part (a) *********************/

    /** Returns a new string in which each letter in text is
     *  replaced with the letter whose index in abc is equal
     *  to the index of the original letter plus key, with
     *  wraparound, if needed, back to the beginning of abc.
     *  All the characters in text that are not letters remain
     *  unchanged.
     *  Precondition: all letters in text are uppercase;
     *                0 < key < 26.
     */
    public static String encrypt(String text, int key)
    {
        String code = "";

        for (int i = 0; i < text.length(); i++)
        {
            // get the original letter
            String letter = text.substring(i, i+1);
            // get the corresponding index in the alphabet of the letter
            int j = abc.indexOf(letter);

            // if we have a letter, encrypt it
            if (j >= 0)
            {
                // get the index of the encrypted letter via the key (i.e. shift)
                j = (j + key) % 26;

                // get the encrypted letter and add it to the encoded message
                String encryptedLetter = abc.substring(j, j+1);
                code += encryptedLetter;
            }
            // otherwise, do not encrypt the character and simply add it to the code
            else
            {
                code += letter;
            }
        }

        return code;
    }

    /********************* Part (b) *********************/

    /** Returns a new string in which each letter in code is
     *  replaced with the letter whose index in abc is equal
     *  to the index of the letter minus key, with
     *  wrap-around at index 0.
     *  Precondition: All letters in code are uppercase;
     *                0 < key < 26
     */
    public static String decrypt(String code, int key)
    {
        return encrypt(code, 26 - key);
    }

    public static void main(String[] args)
    {
        String text = "hello, world!";
        System.out.println(text);
        String code = Cipher.encrypt(text, 7);
        System.out.println(code);
        text = Cipher.decrypt(code, 7);
        System.out.println(text);
    }
}
