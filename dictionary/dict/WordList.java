package dict;

public enum WordList {
    Placeholder("Placeholder", "Placeholder", "adjective", "To be updated..."),
    Placeholder_2("Placeholder", "Placeholder", "adjective", "To be updated..."),
    Placeholder_3("Placeholder", "Placeholder", "adverb", "To be updated..."),
    Placeholder_4("Placeholder", "Placeholder", "conjunction", "To be updated..."),
    Placeholder_5("Placeholder", "Placeholder", "interjection", "To be updated..."),
    Placeholder_6("Placeholder", "Placeholder", "noun", "To be updated..."),
    Placeholder_7("Placeholder", "Placeholder", "noun", "To be updated..."),
    Placeholder_8("Placeholder", "Placeholder", "noun", "To be updated..."),
    Placeholder_9("Placeholder", "Placeholder", "preposition", "To be updated..."),
    Placeholder_10("Placeholder", "Placeholder", "pronoun", "To be updated..."),
    Placeholder_11("Placeholder", "Placeholder", "verb", "To be updated..."),
    CSC210("CSC210", "CSC210", "adjective", "Comfortable with Objects and Classes."),
    CSC210_2("CSC210", "CSC210", "adjective", "Ready for CSC 220."),
    CSC210_3("CSC210", "CSC210", "noun", "Intro to Java."),
    CSC210_4("CSC210", "CSC210", "verb", "To learn Java."),
    CSC220("CSC220", "CSC220", "adjective", "Ready to create complex data structures."),
    CSC220_2("CSC220", "CSC220", "noun", "Data Structures."),
    CSC220_3("CSC220", "CSC220", "verb", "To create data structures."),
    CSC340("CSC340", "CSC340", "adjective", "= C++ version of CSC210 + CSC 220 + more."),
    CSC340_2("CSC340", "CSC340", "noun", "A CS upper division course."),
    CSC340_3("CSC340", "CSC340", "noun", "Many hours outside of class."),
    CSC340_4("CSC340", "CSC340", "noun", "Programming Methodology."),
    Verb("Verb", "Verb", "noun", "Verb is a word or group of words that expresses an action (such as eat)," +
            " an event (such as happen) or a state (such as exist)."),
    Book("Book", "Book", "noun", "A set of pages."),
    Book_1("Book", "Book", "noun", "A written work published in printed or electronic form."),
    Book_2("Book", "Book", "verb", "To arrange for someone to have a seat on a plane."),
    Book_3("Book", "Book", "verb", "To arrange something on a particular date."),
    Bookable("Bookable", "Bookable", "adjective", "Can be ordered in advance."),
    Conjunction("Conjunction", "Conjunction", "noun", "Conjunction is a word that joins words, phrases," +
            " or sentences, for example 'and', 'but', 'or'."),
    Interjection("Interjection", "Interjection", "noun", "Interjection is a short sound, word or phrase" +
            " spoken suddenly to express an emotion. Oh!, Look out! and Ow! are interjections."),
    Adjective("Adjective", "Adjective", "noun", "Adjective is a word that describes a person or thing, for" +
            " example big, red and clever in a big house, red wine and a clever idea.");

    /*
    The keyWord is the key when the data is loaded into the TreeMap.  The displayName is the name that is displayed
    for output.  The displayName is usually the same as the keyWord, but keyWord is modified when searching because of
    the String.CASE_INSENSITIVE_ORDER comparator used with the TreeMap.  That's why there is a separate, unmodified
    displayName field in WordList.
    */
    private String keyWord;
    private String displayName;
    private String part;
    private String definition;

    WordList(String keyWord, String displayName, String part, String definition){
        this.keyWord = keyWord;
        this.displayName = displayName;
        this.part = part;
        this.definition = definition;
    }

    public String getKeyWord(){
        return keyWord;
    }

    public String[] getEntryValue(){
        String[] grouping = new String[3];
        grouping[0] = displayName;
        grouping[1] = part;
        grouping[2] = definition;
        return grouping;
    }

}