package com.snakeladder.board;
import com.snakeladder.exception.InvalidBoardException;
import com.snakeladder.service.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import  java.util.*;

public class Board {
    private Map<Integer, Integer> snakes = new HashMap<>();
    private Map<Integer, Integer> ladders = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(Board.class);

    public void addSnake(int head, int tail) {

        if (head <= tail) {
            logger.error("Invalid snake configuration: {} -> {}", head, tail);
            throw new InvalidBoardException(
                    "Snake head must be greater than tail"
            );
        }

        if (head >= 100 || tail <= 0) {
            logger.error("Snake position out of board range: {} -> {}", head, tail);
            throw new InvalidBoardException(
                    "Snake position out of board range"
            );
        }

        snakes.put(head, tail);
    }

    public void addLadder(int start, int end) {

        if (start >= end) {
            logger.error("Ladder start must be less than end: {} -> {}", start, end);
            throw new InvalidBoardException(
                    "Ladder start must be less than end"
            );
        }

        if (start <= 0 || end > 100) {
            logger.error("Ladder position out of board range: {} -> {}", start, end);
            throw new InvalidBoardException(
                    "Ladder position out of board range"
            );
        }

        ladders.put(start, end);
    }

    public int resolvePosition(int position) {
        boolean changed = true;

        while (changed) {
            changed = false;

            if (snakes.containsKey(position)) {
                position = snakes.get(position);
                changed = true;
            }

            else if (ladders.containsKey(position)) {
                position = ladders.get(position);
                changed = true;
            }
        }

        return position;
    }
}
