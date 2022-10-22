package Project3;

/*
    * A class that can be trained in how a written language works
    * can then generate gibberish words for that language
    **/
public class Gibberisher {
    private Trie<CharBag> model;
    private int length;
    private int numSamples;
    
    /*
    * A constructor that takes the value of the segment length, and initializes the Trie and sample count variables
    **/
    public Gibberisher(int length){
        this.length = length;
        model = new Trie<>();
        numSamples = 0;
    }

    /*
    * "Trains" the program to recognize the model of a certain string of words given to it
    * The model represents the connection between letters in the words of that language
    **/
    public void train(String[] words){
        for(int i = 0; i<words.length; i++){
            LetterSample[] samples = LetterSample.toSamples(words[i], this.length);
            
            numSamples ++;
            for(int j = 0; j<samples.length; j++){           
                if(model.get(samples[j].getSegment())==null){
                    CharBag newBag = new CharBag();             
                    newBag.add(samples[j].getNextLetter());   
                    model.put(samples[j].getSegment(), newBag);
                
                }else{
                    CharBag modelGet = model.get(samples[j].getSegment());
                    modelGet.add(samples[j].getNextLetter());                    
                    model.put(samples[j].getSegment(), modelGet);   
               }        
            }
        }
    }

    /*
    * Returns the number of samples used so far to train the model
    **/
    public int getSampleCount(){
        return numSamples;
    }

    /*
    * Generates the string that represents the gibberished word
    **/
    public String generate(){
        String word = "";
        boolean check = true;
        if(word.length()== 0){
            check = true;
        }else if(word.charAt(word.length()-1) != '.'){
            check = true;
        }else check = false;
        while(check == true){
            String sample = "";

            if(word.length() <= this.length){
                sample = word;
            }else{
                sample = word.substring(word.length()-this.length);
            }
        
            CharBag modelGet = new CharBag();
            modelGet = model.get(sample);
            char nextLetter = modelGet.getRandomChar();
            word += nextLetter;
            if(word.length()== 0){
                check = true;
            }else if(word.charAt(word.length()-1) != '.'){
                check = true;
            }else check = false;
        }
        return word.substring(0, word.length()-1);
    }
}
