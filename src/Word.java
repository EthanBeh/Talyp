public class Word {
    private String word;
    private String type;
    private String meaning;

    public Word(String w, String t, String m) {
        this.word = w;
        this.type = t;
        this.meaning = m;
    }

    public String getWord() {
        return word;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return word + " (" + type + "):\n" + meaning;
    }
}