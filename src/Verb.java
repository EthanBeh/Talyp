public class Verb extends Word {
    public Verb(String w, String t, String m) {
        super(w, t, m);
    }

    public String[][] getConjugationTable() {
        String[][] table = new String[5][6];
        String[] tense = {"shi", "pi", "ri", "alsos", ""};
        String[] number = {"u", "aa", "a", "yu", "we", "o"};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                table[i][j] = getWord() + " " + tense[i] + number[j];
            }
        }
        return table;
    }

    public static String[][] getConjugationTable(Verb v) {
        String[][] table = new String[5][6];
        String[] tense = {"shi", "pi", "ri", "alsos", ""};
        String[] number = {"u", "aa", "a", "yu", "we", "o"};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                table[i][j] = v.getWord() + " " + tense[i] + number[j];
            }
        }
        return table;
    }
}
