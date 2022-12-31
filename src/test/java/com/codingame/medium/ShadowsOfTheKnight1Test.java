package com.codingame.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class ShadowsOfTheKnight1Test {

    public static final int MAX_ALLOWED_TIME = 150;

    @Timeout(value=MAX_ALLOWED_TIME,unit = TimeUnit.MILLISECONDS)
    @Test
    public void easy_test(){
        var w= 10;
        var h =10;
        var maxNumberOfJumps=6;
        var initialPosition = new Coordinate(2,5);
        var bombLocation= new Coordinate(7,4);
        var k = new ShadowsOfTheKnight1();
        var actualPos = new int []{initialPosition.x,initialPosition.y};
        var numberOfJumps=0;
        do {
            actualPos=k.nextMove();
            numberOfJumps++;
        }while ( ((actualPos[0]!= bombLocation.x ) && (actualPos[1]!=bombLocation.y))
        && (numberOfJumps< maxNumberOfJumps));

        assertThat(actualPos[0]).isEqualTo(bombLocation.x);
        assertThat(actualPos[1]).isEqualTo(bombLocation.y);
        assertThat(numberOfJumps).isLessThanOrEqualTo(maxNumberOfJumps);

    }


    private record Coordinate(int x,int y){};
}