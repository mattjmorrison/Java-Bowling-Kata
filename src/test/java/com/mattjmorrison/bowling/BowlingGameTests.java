package com.mattjmorrison.bowling;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BowlingGameTests {
    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    private void rollMany(int rolls, int pins) {
        for (int roll=0;roll<rolls;roll++){
            game.roll(pins);
        }
    }

    @Test
    public void testJudysGame(){
        rollMany(20, 0);
        assertEquals(0, game.get_score());
    }

    @Test
    public void testAllOnesGame(){
        rollMany(20, 1);
        assertEquals(20, game.get_score());
    }

    @Test
    public void testOneSpare(){
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.get_score());
    }

    @Test
    public void testFirstRollStrike(){
        game.roll(10);
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertEquals(26, game.get_score());
    }

    @Test
    public void testBriansPerfectPerfectGameGame(){
        rollMany(12,10);
        assertEquals(300,game.get_score());
    }
}
