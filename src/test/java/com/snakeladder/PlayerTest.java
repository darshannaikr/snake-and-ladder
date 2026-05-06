package com.snakeladder;

import com.snakeladder.model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testPlayerPositionUpdate() {

        Player player = new Player("Darshan");

        player.setPosition(45);

        assertEquals(45, player.getPosition());
    }
}