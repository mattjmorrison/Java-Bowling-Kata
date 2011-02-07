package com.mattjmorrison.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> pins = new ArrayList<Integer>();

    public int get_score() {
        int score = 0;

        int frame = 0;
        while(frame < 10){
            score += pins.get(frame);

            if (is_strike(frame)){
                score += get_strike_bonus(frame);
            }
            else {
                score = get_non_strike_frame_total(score, frame);
                frame++;
            }
            frame++;
        }
        return score;
    }

    private int get_non_strike_frame_total(int score, int frame) {
        score += get_second_roll_of_frame(frame);
        if (is_spare(frame)){
            score += get_spare_bonus(frame);
        }
        return score;
    }

    private Integer get_second_roll_of_frame(int frame) {
        return pins.get(frame + 1);
    }

    private boolean is_spare(int frame) {
        return pins.get(frame) + pins.get(frame + 1) == 10;
    }

    private boolean is_strike(int frame) {
        return pins.get(frame) == 10;
    }

    private Integer get_spare_bonus(int frame) {
        return pins.get(frame + 2);
    }

    private int get_strike_bonus(int frame) {
        return pins.get(frame + 1) + pins.get(frame + 2);
    }

    public void roll(int pins) {
        this.pins.add(pins);
    }
}
