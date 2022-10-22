package Project3;

    /*
    * A class that represents a node in a Trie tree
    **/
public class TrieNode<T> {
    private T data;
    private TrieNode<T>[] children;

    /*
    * A constructor that takes no parameters, initializes data to null and the children to an array of 26 spaces
    **/
    public TrieNode(){
        this.data = null;
        children = new TrieNode[26];
    }

    /*
    * Returns the data variable
    **/
    public T getData(){
        return data;
    }

    /*
    * Sets the data variable
    **/
    public void setData(T data){
        this.data = data;
    }

    /*
    * This method returns the TrieNode<T> associated with the given letter
    **/
    public TrieNode<T> getChild(char letter){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        
        int index = 0;
        boolean in = false;
        for(int i = 0; i<26; i++){
            if(alpha.charAt(i) == letter){
                in = true;
                index = i;
            }
        }
        
        if(!in){
            return null;
        }
        if(children[index] == null){
            TrieNode<T> val = new TrieNode<>();
            children[index] = val;
            return children[index];
        }else{
            return children[index];
        }
    }

    /*
    * Returns the number of nodes in the tree
    * The number of nodes in the part of the tree visible to this node *
    **/
    public int getTreeSize(){
        int size = 0;
        for(int i = 0; i< 26; i++){
            if(children[i] != null){
                size += children[i].getTreeSize();
            }
        }
        return size +1;
    }
}
