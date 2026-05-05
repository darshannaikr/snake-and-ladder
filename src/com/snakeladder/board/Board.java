package com.snakeladder.board;
import  java.util.*;

public class Board {
    private Map<Integer, Integer> snakes = new HashMap<>();
    private Map<Integer, Integer> ladders = new HashMap<>();

    public void addSnake(int head, int tail) {
        snakes.put(head, tail);
    }

    public void addLadder(int start, int end) {
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
