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
            //A index if a character in the message exists
            int index = -1;
            //A boolean sentinal to stop the loop once the condition is met
            boolean found = false;

            //Looping through the alphabet
            for(int a = 0; a< alphabet.length; a++)
            {
                if(alphabet[a] == current && !found)
                {
                    index = a;
                    found = true;
                }
            }
            //During the looping process, if a letter was found and caused index not to be -1 
            //then it gets shifted and added to the result
            if(index != -1)
                result += shifted[index];
            else
                //Add the unchanged character 
                result += current;        
        }
        return result;

    }

    public String decrypt(String message){
        String result = "";
        //Turning the message to lower case
        message = message.toLowerCase();

        for(int i =0; i<message.length();i++)
        {
            //Same as last time we need a variable to 
            //keep track of the current position in the message
            char current = message.charAt(i);
            //Same purpose as the encrypt method
            int index = -1;
            boolean found = false;

            //Now we have to look for the char in shifted to decrpyt
            for(int a = 0; a<shifted.length && !found;a++)
            {
                if(shifted[a]==current)
                {
                    index = a;
                    found = true;
                }
            }
            //Now we map the message back to the normal alphabet
            if(index != -1)
                result += alphabet[index];
            else
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