package game;

import words.HiddenWord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Session {
    private final int maxTries = 6;
    private int currentTries = 0;
    private final HiddenWord word = new HiddenWord(getRandomWord());
    private final HashSet<Character> usedLetters = new HashSet<>();

    public Session() {
    }

    private String getRandomWord() {
        List<String> wordsList;
        try {
            wordsList = Files.lines(Paths.get("src/game/words.txt")).toList();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        Random random = new Random();
        int index = random.nextInt(wordsList.size());
        return wordsList.get(index);
    }

    public boolean isUsed(Character letter) {
        return usedLetters.contains(letter);
    }

    public void addLetter(Character letter) {
        usedLetters.add(letter);
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

    public int getMaxTries() {
        return maxTries;
    }
}
