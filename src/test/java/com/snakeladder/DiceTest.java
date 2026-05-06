package com.snakeladder;

import com.snakeladder.util.Dice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {

    @Test
    void testDiceRange() {

        Dice dice = new Dice();

        for (int i = 0; i < 100; i++) {

            int value = dice.roll();

            assertTrue(value >= 1 && value <= 6);
        }
    }
}