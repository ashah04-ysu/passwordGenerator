
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public class PasswordGenerator {
    char [] digit = "0123456789".toCharArray();
    char [] upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    char [] lowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    char [] symbol = "!@#$%^&*()+/.,';?><:}{|-~`/".toCharArray();
    
    public StringBuffer generatePassword(boolean isDigit, boolean isLowerCase, boolean isUpperCase, boolean isSymbol,
    boolean isRepeat, boolean isSpace, boolean isRandom, int spaceAfter, int numSpace, int length)
    {
    StringBuffer password = new StringBuffer();
    ArrayList <Character> digitList = new ArrayList<>();
    ArrayList <Character> upperCaseList = new ArrayList<>();
    ArrayList <Character> lowerCaseList = new ArrayList<>();
    ArrayList <Character> symbolList = new ArrayList<>();
                    
    ArrayList <ArrayList<Character>> characterList = new ArrayList<>();
    
    for (char ch:digit) digitList.add(ch);
    for(char ch:upperCase) upperCaseList.add(ch);
    for (char ch:digit) lowerCaseList.add(ch);
    for(char ch:upperCase) symbolList.add(ch);
    
    if(isDigit || isSymbol || isLowerCase || isUpperCase){
        if(isDigit) characterList.add(digitList);
        if(isSymbol) characterList.add(digitList);
        if(isUpperCase) characterList.add(upperCaseList);
        if(isLowerCase) characterList.add(lowerCaseList);
        
        for (int i = 0; i < length; i++){
            if(isSpace){
                if(isRandom){
                    int randomSpace = (int) (Math.random()*8);
                    int randomNumOfSpace = (int) (Math.random()*4);
                    if (randomSpace == 0){
                        for (int k = 0; k < randomNumOfSpace; k++){
                            password.append(" ");
                        }
                    }
                }
                else{
                    if (i % spaceAfter == 0){
                       for (int k = 0; k< numSpace; k++){
                           password.append(" ");
                       } 
                    }
                }
            }
            int randomOption = (int) (Math.random()*characterList.size());
            if (characterList.size() > 0){
                int randomCharacter = (int) (Math.random()*characterList.get(randomOption).size());
                password.append(characterList.get(randomOption).get(randomCharacter));
                
                if (!isRepeat){
                    characterList.get(randomOption).remove(characterList.get(randomOption).get(randomCharacter));
                    
                }
            }
            
        }
    }
    
   
    
    
    return password;
    }
    
    
    
    
}
