package com.mattjmorrison.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> game = new ArrayList<Integer>();
    private int EXPECTED_ROLLS = 20;

    public int get_score() {
        int score=0;
        int roll=0;
        for(int i=0;i<10;i++) {
            score +=game.get(roll);
            score +=game.get(roll+1);
            if(game.get(roll)==10) {
                score += game.get(roll+2);
            } else {
                if(game.get(roll) + game.get(roll+1) == 10) {
                    //previous frame was a spare
                    score += game.get(roll+2);
                }
                roll++;
            }
            roll++;
            System.out.println("score="+score);
        }
        return score;
    }

    public void roll(int pins) {
        game.add(pins);
    }
}
