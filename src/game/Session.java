package game;

import words.HiddenWord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Session {
    private final int maxTries;
    private int currentTries = 0;
    private final HiddenWord word = new HiddenWord(getRandomWord());
    private final HashSet<Character> usedLetters = new HashSet<>();
    private final Random random = new Random();

    public Session(int maxTries) {
        this.maxTries = maxTries;
    }

    private String getRandomWord() {
        List<String> wordsList;
        try {
            wordsList = Files.lines(Paths.get("src/game/words.txt")).toList();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        int index = random.nextInt(wordsList.size());
        return wordsList.get(index);
    }

    public boolean isUsed(Character letter) {
        return usedLetters.contains(letter);
    }

    private void addLetter(Character letter) {
        usedLetters.add(letter);
    }

    public boolean updateWord(Character letter) {
        this.word.openLetters(letter);
        this.addLetter(letter);
        return this.word.isInWord(letter);
    }

    public boolean isWordHidden() {
        return this.word.isHidden();
    }

    public String getWord() {
        return this.word.getWord();
    }

    public int getCurrentTries() {
        return currentTries;
    }

    public void setCurrentTries(int currentTries) {
        this.currentTries = currentTries;
    }

    public void addTry() {
        this.currentTries++;
    }

    public int getMaxTries() {
        return maxTries;
    }
}
