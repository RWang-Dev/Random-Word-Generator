package Project3;
import java.util.Random;

    /*
    * A class to count how many times each letter has been added to it's collection 
    * and also generates a random letter from the bag
    **/
public class CharBag {
    
    private int[] bag;

    /*
    * Constructor method which creates an empty Charbag
    **/
    public CharBag(){
        bag = new int[27];
    }

    /*
    * Adds a char to the CharBag. If the char is an uppercase letter, it should be converted to a lowercase letter before adding
    * Uppercase letters and lowercase letters should be treated as equal
    * If the char is not an English alphabet letter, it should be converted to the STOP character '.'
    **/
    public void add(char letter){
        int index = 0;
        boolean in = false;
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i<26; i++){
            if(letter == alpha.charAt(i)){
                index = i;
                in = true;
            }
            else if(letter == ALPHA.charAt(i)){
                index = i;
                in = true;
                
            }

        }
        if(!in){
            bag[26] ++;
        }else{
            bag[index] ++;
        }
    }

    /*
    * Removes a char from the CharBag.
    * If the input letter is not in the CharBag, no change should happen
    * If the letter is in the CharBag multiple times, only one copy should be removed.
    **/
    public void remove(char c){
        int index = 0;
        boolean in = false;
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i<26; i++){
            if(c == alpha.charAt(i)){
                index = i;
                in = true;
            }
            else if(c == ALPHA.charAt(i)){
                index = i;
                in = true;
                
            }
        }
        if(in && bag[index] > 0){
            bag[index] --;
        }else if(!in && bag[26] >0){
            bag[26] --;
        }
    }

    /*
    * Returns how many times a given char is in the CharBag
    **/
    public int getCount(char c){
        int index = 0;
        boolean in = false;
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i<26; i++){
            if(c == alpha.charAt(i)){
                index = i;
                in = true;
            }
            else if(c == ALPHA.charAt(i)){
                index = i;
                in = true;
                
            }
        }
        if(!in){
            return bag[26];
        }else{
            return bag[index];
        }
    }

    /*
    * Returns the total size of the CharBag
    **/
    public int getSize(){
        int total = 0;
        for(int i = 0; i < 27; i++){
            total += bag[i];
        }
        return total;
    }

    /*
    * Returns a string noting the count of each letter
    **/
    public String toString(){
        String alpha = "abcdefghijklmnopqrstuvwxyz.";
        String output = "CharBag{";
        
        for(int i = 0; i<27; i++){
            
            if(i == 26){
                output += alpha.charAt(i) + ":" + Integer.toString(bag[i]) + "}";
            } else{
                output += alpha.charAt(i) + ":" + Integer.toString(bag[i]) + ", ";
            }
            
        }
        return output;     
    }

    /*
    * Returns a randomly chosen char from the chars in the char bag.
    * the chosen char is in proportion to the number of times a given char is in the data structure.
    **/
    public char getRandomChar(){
        int sum = 0;
        Random rand = new Random();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i<27; i++){
            sum += bag[i];
        }
        if(sum == 0){
            return '.';
        }
        int count = rand.nextInt(this.getSize());
        for(int i = 0; i<26; i++){
            count -= bag[i];
            if(count < 0){
                return alpha.charAt(i);
            }
        }
        
        return '.';
    
    }



}
