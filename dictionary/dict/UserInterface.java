package dict;


/**
 * Created by aramisknox on 9/10/18.
 *
 * Description: UserInterface is a separate class that handles displaying menus and receiving input from the user.
 */

public class UserInterface {

    private Dictionary dict; //This user interface only works for Dictionary objects

    public <T extends Dictionary> UserInterface(T dictRef) {
        this.dict = dictRef;
        displayUserInterface();
    }

    private String parseInput(String[] splitString) { //This method is mostly error checking
        String resultString;
        if(splitString.length > 3){
            System.out.print("|\nCannot have more than 3 arguments\n|\n");
            resultString = null;
        }
        else if(splitString.length == 3 && splitString[2].toLowerCase().contentEquals("distinct")){
            try {
                String partString = PartList.valueOf(splitString[1].toLowerCase()).getReturnValue(); //partString must match a part of speech in PartList
                resultString = splitString[0];
                dict.setSpeechPart(partString);
                dict.setDistinctSearch(true);
            } catch(IllegalArgumentException ex) {
                System.out.print("|\n<2nd argument must be a part of speech>\n|\n");
                resultString = null;
            }
        }
        else if(splitString.length == 2 && splitString[1].toLowerCase().contentEquals("distinct")){
            resultString = splitString[0];
            dict.setSpeechPart(null);
            dict.setDistinctSearch(true);
        }
        else if(splitString.length == 2){
            try {
                String partString = PartList.valueOf(splitString[1].toLowerCase()).getReturnValue(); //partString must match a part of speech in PartList
                resultString = splitString[0];
                dict.setSpeechPart(partString);
                dict.setDistinctSearch(false);
            } catch(IllegalArgumentException ex){
                resultString = null;
                System.out.print("|\n<2nd argument must be a part of speech>\n|\n");
            }
        }
        else{
            resultString = splitString[0];
            dict.setSpeechPart(null);
            dict.setDistinctSearch(false);
        }
        return resultString;
    }

    private void displayUserInterface(){
        Scanner reader = new Scanner(System.in);
        String resultString = new String();
        String stringBuffer;
        while(!resultString.toLowerCase().contentEquals("!q")){
            System.out.print("Search: ");
            stringBuffer = reader.nextLine();
            String[] splitString = stringBuffer.split("\\s+");
            resultString = this.parseInput(splitString);
            if(resultString != null && !resultString.toLowerCase().contentEquals("!q")){
                dict.search(resultString);
            }
            if(resultString == null){
                resultString = new String();
            }
        }
        System.out.print("\n\n-----Thank You!-----\n");
    }
}