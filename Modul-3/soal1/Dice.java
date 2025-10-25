package soal1;

import java.util.Random;

public class Dice {
    private int value;

    public Dice() {
        randomValue();
    }

    public void randomValue() {
        Random rand = new Random();
        value = rand.nextInt(6) + 1;
    }

    public int getValue() {
        return value;
    }
}
