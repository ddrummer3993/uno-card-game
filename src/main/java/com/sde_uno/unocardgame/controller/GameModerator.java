package com.sde_uno.unocardgame.controller;

import com.sde_uno.unocardgame.model.State;

public class GameModerator {

    int randNum = (Math.random() <= 0.5) ? 1 : 2;

    private State state;

    public void play() {

        if (randNum == 1) {
            state = State.PLAYER_ONE_MOVE;
        } else if (randNum == 2) {
            state = State.COMPUTER_MOVE;
        }

        //TODO determine if need new method for determining player state, and then call play method, or determine player state inside class and then use in method.

    }

}
