// this class works as the backend and will generate the password

import java.util.Random;

public class PasswordGenerator{
    // character pools
    // these strings will hold the characters/numbers/symbols that we are going to randomly pick to generate our password
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBER = "0123456789";
    public static final String SPECIAL_SYMBOL = "!@#$%^&*()-_=+[]{};:,.<>/?";

    // the random class allows us to generate a random number which will be used to randomly choose the characters
    private final Random random;

    // constructor
    public PasswordGenerator(){random = new Random();}

    // length - length of the password to be generated (taken from the user input)
    // includeUppercase and etc... considers if the password should include uppercase, lowercase, etc... (taken from the user)
    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialSymbols){
        // we will use string builder over string for better efficiency
        StringBuilder passwordBuilder = new StringBuilder();

        // store valid characters (toggle states)
        String validCharacter = "";
        if (includeUppercase){validCharacter += UPPERCASE_CHARACTERS;}
        if (includeLowercase){validCharacter += LOWERCASE_CHARACTERS;}
        if (includeNumbers){validCharacter += NUMBER;}
        if (includeSpecialSymbols){validCharacter += SPECIAL_SYMBOL;}

        // build password
        for (int i = 0; i < length; i++){
            // generate a random index
            int randomIndex = random.nextInt(validCharacter.length());

            // get the char based on the random index
            char randomChar = validCharacter.charAt(randomIndex); // charAt will retrieve the character at the provided index

            // store char into password builder
            passwordBuilder.append(randomChar); 

            // do this until we have reached the length that the user has provided
        }

        // return the result
        return passwordBuilder.toString(); // return the string
    }
}
