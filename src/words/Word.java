package words;

import java.util.ArrayList;

class Word {
    private final ArrayList<Letter> charactersList = new ArrayList<>();

    protected Word(String word, boolean isHidden) {
        for (char l : word.toCharArray()) {
            charactersList.add(new Letter((Character) l, isHidden));
        }
    }

    public String getWord() {
        StringBuilder result = new StringBuilder();
        for (Letter l : this.charactersList) {
            result.append(l.printLetter());
        }
        return result.toString();
    }

    public boolean isInWord(Character letter) {
        for (Letter l : this.charactersList)
            if (l.equals(letter))
                return true;
        return false;
    }

    protected ArrayList<Letter> getCharactersList() {
        return charactersList;
    }


}
