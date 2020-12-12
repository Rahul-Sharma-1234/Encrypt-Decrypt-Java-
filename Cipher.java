//Rahul Sharma

//CS 1400

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class Cipher {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to My Encryption/Decryption Program");
        System.out.println("Please enter the letter of your chosen operation:");
        System.out.println("\ta) Encrypt a message");
        System.out.println("\tb) Decrypt a message");
        System.out.println("\tc) Exit");
        System.out.print("Enter option: ");

        Scanner scanchoice = new Scanner(System.in);
        String choiceentry = scanchoice.nextLine().toLowerCase();
        String EnterMessage = "";
        String EnterPassword = "";
        int MessageLength;
        int PassLength = 0;
        if (choiceentry.equals("a")) {
            System.out.println("Input Your Message");
                EnterMessage = scanchoice.nextLine();
            System.out.println("Input Password (Must Be 8 Characters or Longer)");
             EnterPassword = scanchoice.nextLine();
            while (EnterPassword.length() < 8) {
                System.out.println("Invalid Password Length, Please try Again");
                EnterPassword = scanchoice.nextLine();

            }

            System.out.println("Enter File Name");
            String FileName = scanchoice.nextLine();
            FileWriter WritingtoaFile = new FileWriter(FileName, true);
            PrintWriter outputfile = new PrintWriter(WritingtoaFile);
            outputfile.printf("0x");
            for (int i = 0, j = 0; i < EnterMessage.length() && j <= EnterPassword.length(); i++, j++) {
                if (j == EnterPassword.length());
                    j = 0;
                        int xor = (EnterMessage.charAt(i) ^ EnterPassword.charAt(j));
                    String XortoHex = Integer.toHexString(xor);
                    if (XortoHex.length() < 2)
                        XortoHex = "0" + XortoHex;
                    outputfile.printf(XortoHex);
            }
            outputfile.close();
        } else if (choiceentry.equals("b")) {
            System.out.println("Enter Your Password");
            String DecryptPassword = scanchoice.nextLine();
            System.out.println("Enter File Name");
            String DecryptFile = scanchoice.nextLine();
            File CipherFile = new File(DecryptFile);
            Scanner InputFile = new Scanner(CipherFile);
            String  CipherMessage = InputFile.nextLine();
            PassLength += DecryptPassword.length();
            MessageLength = (CipherMessage.length()-2)/2;

            for (int i = 2, j = 0 ; i < MessageLength && j <= PassLength; i += 2,j++){
                if (j == EnterPassword.length());
                j = 0;
                char Letter1 = CipherMessage.charAt(i);
                char Letter2 = CipherMessage.charAt(i + 1);
                String HexLetter = Letter1 + Character.toString(Letter2);
                int IntFromHex = Integer.parseInt(HexLetter, 16);
                int intofDecipheredMessage = IntFromHex^DecryptPassword.charAt(j);
                char MessageDeciphered = (char) intofDecipheredMessage;
                System.out.print(MessageDeciphered);
            }
        } else if (choiceentry.equals("c")) {
            System.exit(0);

        }

    }

}
