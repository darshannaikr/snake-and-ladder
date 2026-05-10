package com.snakeladder;

import com.snakeladder.board.Board;
import com.snakeladder.exception.InvalidBoardException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void testSnakeResolution() {

        Board board = new Board();
        board.addSnake(99, 10);

        int result = board.resolvePosition(99);

//        assertEquals(10, result);
        assertEquals(999, result);
    }

    @Test
    void testLadderResolution() {

        Board board = new Board();
        board.addLadder(5, 50);

        int result = board.resolvePosition(5);

        assertEquals(50, result);
    }

    @Test
    void testNormalPosition() {

        Board board = new Board();

        int result = board.resolvePosition(25);

        assertEquals(25, result);
    }

    @Test
    void testInvalidSnake() {

        Board board = new Board();

        assertThrows(InvalidBoardException.class, () -> {
            board.addSnake(10, 50);
        });
    }

    @Test
    void testInvalidLadder() {

        Board board = new Board();

        assertThrows(InvalidBoardException.class, () -> {
            board.addLadder(80, 20);
        });
    }
}