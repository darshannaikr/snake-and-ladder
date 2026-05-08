package com.snakeladder.service;
import com.snakeladder.board.Board;
import com.snakeladder.model.Player;
import com.snakeladder.util.Dice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import java.util.*;

public class Game {

    private static final Logger logger = LoggerFactory.getLogger(Game.class);
    private Board board;
    private Queue<Player> players;
    private Dice dice;

    public Game(Board board, List<Player> playerList) {
        this.board = board;
        this.players = new LinkedList<>(playerList);
        this.dice = new Dice();
    }

    public void startGame() {

        while (true) {

            Player current = players.poll();
            int diceValue = dice.roll();

            int oldPosition = current.getPosition();
            int newPosition = oldPosition + diceValue;

            if (newPosition <= 100) {
                newPosition = board.resolvePosition(newPosition);
            } else {
                newPosition = oldPosition;
            }

            current.setPosition(newPosition);

//            System.out.println(
//                    current.getName() + " rolled a " + diceValue +
//                            " and moved from " + oldPosition +
//                            " to " + newPosition
//            );
            logger.info("{} rolled a {} and moved from {} to {}",
                    current.getName(),
                    diceValue,
                    oldPosition,
                    newPosition);

            if (newPosition == 100) {
//                System.out.println(current.getName() + " wins the game");
                logger.info("{} wins the game", current.getName());
                break;
            }

            players.offer(current);
        }
    }
}
