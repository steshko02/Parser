package text_elements;

import lombok.Data;

public enum Elements {

    WORD,
    SENTENCE,
    TEXT,
    PARAGRAPH,
    PUNCTUATION,
    CODE;

    private String RegexForSplit;
    static {
        TEXT.RegexForSplit = "(Start listing(\\s*.\\s*)+?\\n?End listing)|.*[A-Za-zА-Яа-я]+\\s*.*";
        CODE.RegexForSplit = "(Start listing(\\s*.\\s*)+?\\n?End listing)";
        SENTENCE.RegexForSplit = "[^.!?]+(\\.+|\\?|!|:\\n?)";
        WORD.RegexForSplit = "[A-Za-zА-Яа-я0-9]+|\\.+|\\?|!|,|(\\s?-\\s?)|\"|(:\\s?)|;";
        PUNCTUATION.RegexForSplit = "\\.+|\\?|!|,|(\\s?-\\s?)|\"|(:\\s?)|;";

    }
    public String getRegexForSplit() {
        return RegexForSplit;
    }
}
