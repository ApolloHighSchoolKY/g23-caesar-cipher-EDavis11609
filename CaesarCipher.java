/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class CaesarCipher {

	private char[] alphabet;
	private char[] shifted;
	private int shift;

    public CaesarCipher() {
        alphabet = new char[26];
        shifted = new char[26];
        shift = 0;
        shifter(0);
    }

    public CaesarCipher(int num){
        alphabet = new char[26];
        shifted = new char[26];
        shifter(num);  
    }

    public String encrypt(String message){
        String result = "";
        //In case if their are any capitals so we can exactly relate back to alpha
        message = message.toLowerCase();

        for(int i =0; i<message.length();i++)
        {
            //What letter is in the current position of the message
            char current = message.charAt(i);
            //A boolean sentinal to stop the loop once the condition is met
            boolean found = false;

            //Looping through the alphabet
            for(int a = 0; a< alphabet.length; a++)
            {
                if(alphabet[a] == current && !found)
                {
                    result += shifted[a];
                    found = true;
                }
            }
            //During the looping process, if a letter was found and caused index not to be -1 
            //then it gets shifted and added to the result
            if(!found)
                result += current;      
        }
        return result;

    }

    public String decrypt(String message){
         String result = "";
        //In case if their are any capitals so we can exactly relate back to alpha
        message = message.toLowerCase();

        for(int i =0; i<message.length();i++)
        {
            //What letter is in the current position of the message
            char current = message.charAt(i);
            //A boolean sentinal to stop the loop once the condition is met
            boolean found = false;

            //Looping through the alphabet
            for(int a = 0; a< alphabet.length; a++)
            {
                if(shifted[a] == current && !found)
                {
                    result += alphabet[a];
                    found = true;
                }
            }
            //During the looping process, if a letter was found and caused index not to be -1 
            //then it gets shifted and added to the result
            if(!found)
                result += current;      
        }
        return result;

    }

    public void shifter(int num){

        shift = num;

        String alpha = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i<alphabet.length;i++)
        {
            alphabet[i] = alpha.charAt(i);

            int shiftedSpot = (i + num) % 26;
            if(shiftedSpot<0)
                    shiftedSpot += 26;
            shifted[i] = alpha.charAt(shiftedSpot);
        }   
    }
}