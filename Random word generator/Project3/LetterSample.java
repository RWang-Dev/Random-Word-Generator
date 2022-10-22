package Project3;

/*
    * A class to represent one data point for the program
    **/
public class LetterSample {
    private String segment;
    private char nextLetter;
    public static final char STOP = '.';

    /*
    * This constructor method takes and sets a value for the segment string 
    * and the nextLetter char.
    **/
    public LetterSample(String segment, char nextLetter){
        this.segment = segment;
        this.nextLetter = nextLetter;
    }

    /*
    * Returns the segment string for this object
    **/
    public String getSegment(){
        return this.segment;
    }

    /*
    * Returns the nextLetter char for this object
    **/
    public char getNextLetter(){
        return this.nextLetter;
    }

    /*
    * Generates String output in the format "segment" -> nextLetter
    **/
    public String toString(){
        return "\"" + this.segment + "\" -> " + this.nextLetter;
    }

    /*
    * Takes a string and generates letter samples from it.
    * Returns a LetterSample array with all possible letter samples within String input of segment length segmentSize or less.
    **/
    public static LetterSample[] toSamples(String input, int segmentSize){
        String word = input += STOP;
        LetterSample[] samples = new LetterSample[word.length()];
        int begin = 0;
        for(int i = 0; i<word.length(); i++){
            if(i-begin == segmentSize){
                samples[i] = new LetterSample(word.substring(begin, i), word.charAt(i));
                begin ++;
            }
            else{
                samples[i] = new LetterSample(word.substring(begin, i), word.charAt(i));
            }
        }
        return samples;
    }
}
