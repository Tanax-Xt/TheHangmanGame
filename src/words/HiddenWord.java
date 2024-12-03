package words;

public class HiddenWord extends Word{
    public HiddenWord(String word) {
        super(word, true);
    }

    public void openLetters(Character letter) {
        if (this.isInWord(letter)) {
            for (Letter l : this.getCharactersList()) {
                if (l.equals(letter))
                    l.setHidden(false);
            }
        }
    }

    public boolean isHidden() {
        for (Letter l : this.getCharactersList()) {
            if (l.isHidden())
                return true;
        }
        return false;
    }
}
