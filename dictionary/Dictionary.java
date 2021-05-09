import java.util.LinkedList;
import java.util.TreeMap;

public class Dictionary {
    /*
    TreeMap was the data structure used because it can take in a comparator as a parameter for its constructor,
    allowing it to easily handle case insensitive search.  The TreeMap values are LinkedLists.  This is done
    so that duplicate keys can be stored in the LinkedLists, since TreeMaps can't store duplicate keys.
    */
    private TreeMap<String, LinkedList<String[]>> structure = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private boolean distinctSearch = false; //If distinctSearch == true, the "distinct" keyword was input by the user.
    private String speechPart = null; //If speechPart != null, a part of speech that matches one in PartList was input by the user.

    public Dictionary(){
        this.loadDict();
    }

    public void setDistinctSearch(boolean distinct){
        this.distinctSearch = distinct;
    }

    public void setSpeechPart(String speechPart){
        this.speechPart = speechPart;
    }

    private void loadDict(){
        System.out.print("! Loading data...\n");
        for(WordList entry : WordList.values()){
            if(structure.containsKey(entry.getKeyWord())){ //Checks to see if there is a duplicate before adding a new entry to the TreeMap.
                structure.get(entry.getKeyWord()).add(entry.getEntryValue()); //If there is a duplicate, just append to the LinkedList.
            }
            else{ //If no duplicate was found, create a new LinkedList and put it in the TreeMap.
                LinkedList<String[]> temp = new LinkedList<>();
                temp.add(entry.getEntryValue());
                structure.put(entry.getKeyWord(), temp);
            }
        }
        System.out.print("! Loading completed...\n\n-----Dictionary 340 JAVA-----\n\n");
    }

    public void search(String searchKey){
        try {
            boolean resultFound = false; //Handles the case where no matches were found.
            LinkedList<String[]> results = structure.get(searchKey); //The LinkedList containing all keyword matches to the search.
            LinkedList<String[]> storage = new LinkedList<>(); //This LinkedList is used to check for duplicates.
            System.out.print("|\n");
            for (String[] word : results) {
                if((word[1] == speechPart || speechPart == null) && !distinctSearch) { //Find matches that match the speechPart if there is one specified.
                    System.out.print(word[0] + " [" + word[1] + "] : " + word[2] + "\n");
                    resultFound = true;
                }else if((word[1] == speechPart || speechPart == null) && distinctSearch){ //Logic to search for duplicates
                    boolean duplicateFound = false;
                    for(String[] element : storage){
                        if(element[1].contentEquals(word[1]) && element[2].contentEquals(word[2])){ //Check to see if a match was already stored.
                            duplicateFound = true;
                        }
                    }
                    if(!duplicateFound) {
                        resultFound = true;
                        storage.add(word); //If no match was found in storage, then add the new word to storage.
                        System.out.print(word[0] + " [" + word[1] + "] : " + word[2] + "\n");
                    }
                }
            }
            if(!resultFound){
                throw new NullPointerException();
            }
            System.out.print("|\n");
        }catch(NullPointerException ex){
            System.out.print("<Not found>\n|\n");
        }
    }

    public static void main(String[] args){
        System.out.print("run:\n");
        Dictionary theDict = new Dictionary();
        UserInterface ui = new UserInterface(theDict);
    }
}