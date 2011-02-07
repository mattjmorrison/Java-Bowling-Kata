package com.mattjmorrison.bowling;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BowlingGameTests {
    private BowlingGame game;

    @Before
    public void setUp(){
        this.game = new BowlingGame();
    }

    public void rollMany(int rolls, int pins){
        for (int roll=0;roll<rolls;roll++){
            game.roll(pins);
        }
    }

    @Test
    public void testGutterGame(){
        this.rollMany(20, 0);
        assertEquals(0, game.get_score());
    }

    @Test
    public void testAllOnes(){
        this.rollMany(20, 1);
        assertEquals(20, game.get_score());
    }

    @Test
    public void testOneSpare(){
        this.rollMany(3, 5);
        this.rollMany(17, 0);
        assertEquals(20, game.get_score());
    }

    @Test
    public void testOneStrike(){
        this.game.roll(10);
        this.rollMany(2, 1);
        this.rollMany(17, 0);
        assertEquals(14, this.game.get_score());
    }

    @Test
    public void testPerfectGame(){
        this.rollMany(12, 10);
        assertEquals(300, this.game.get_score());
    }
}
