/**
 * @(#)G19.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class G19 {

    public static void main(String[] args) {

    	CaesarCipher cipher = new CaesarCipher(4);

    	System.out.println(cipher.encrypt("hello world!"));
    	System.out.println(cipher.decrypt("ukq zez ep!"));

    	//Create a new cipher using the shifter(#) method
    	//Encrypt and decrypt a message with your new cipher

		CaesarCipher cipherTwo = new CaesarCipher(8);

		System.out.println(cipherTwo.encrypt("What is going on"));
		System.out.println(cipherTwo.decrypt("r sdbc fjwwj yjbb cqrb lujbb"));
    }


}