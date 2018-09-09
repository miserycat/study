package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WordDictionary {
    
    private List<String> data;

    /** Initialize your data structure here. */
    public WordDictionary() {
        data = new ArrayList<>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        data.add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Pattern pattern = Pattern.compile("([a-z]*)(\\.*)");
        Matcher matcher = pattern.matcher(word);
        return matcher.find();
    }


    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("_ad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }



}