package words;

class Letter {
    Character  letter;
    boolean isHidden;

    protected Letter(Character letter, boolean isHidden) {
        this.isHidden = isHidden;
        this.letter = letter;
    }

    public Character printLetter() {
        return (isHidden == false) ? letter : '*';
    }

    public boolean equals(Character obj) {
        return this.letter.equals(obj);
    }

    protected boolean isHidden() {
        return isHidden;
    }

    protected void setHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }
}
