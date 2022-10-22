package Project3;

    /*
    * A class that behaves like a dictionary
    * Key-values are short strings
    **/
public class Trie<T> {
    private TrieNode<T> root;

    /*
    * A constructor that initializes the root to a new node
    **/
    public Trie(){
        this.root = new TrieNode<>();
        
    }

    /*
    * Takes a string and returns the appropriate TrieNode. 
    **/
    private TrieNode<T> getNode(String word){
        TrieNode<T> child = new TrieNode<>();
        if(word.equals("")){
            return root;
        }
        for(int i = 0; i<word.length(); i++){ 
            if(i == 0){
                child = root.getChild(word.charAt(i));
                
            }else{
                child = child.getChild(word.charAt(i));
            }
        } 
        return child;
    }

    /*
    * Returns the data currently stored on the TrieNode associated with the input string
    **/
    public T get(String word){
        return getNode(word).getData();
    }

    /*
    * Sets the data currently stored on the TrieNode associated with the input string to the T value provided
    **/
    public void put(String word, T val){
        getNode(word).setData(val);
    }

    /*
    * Returns the root node
    **/
    public TrieNode<T> getRoot(){
        return this.root;
    }
}
