package game;

import words.HiddenWord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Session {
    private final int maxTries = 6;
    private final HiddenWord word = new HiddenWord(getRandomWord());

    public Session() {
    }

    public int getMaxTries() {
        return maxTries;
    }

    private String getRandomWord() {
        List<String> wordsList;
        try {
            wordsList = Files.lines(Paths.get("src/game/words.txt")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
        Random random = new Random();
        int index = random.nextInt(wordsList.size());
        return wordsList.get(index);
    }

    public String getWord() {
        return this.word.getWord();
    }
}
