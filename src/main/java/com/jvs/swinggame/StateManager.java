package com.jvs.swinggame;

import javax.swing.*;
import java.util.ArrayList;

public class StateManager {

    private ArrayList<State> states;
    private int currentState;

    private JFrame gameFrame;


    public StateManager(JFrame jFrame){
        this.gameFrame = jFrame;
        this.states = new ArrayList<State>();
        initAllStates();
    }

    private void initAllStates(){
        //TODO Add states
        states.add(new MenuState());
    }

    public void startCurrentState(){
        gameFrame.add(states.get(currentState));
        states.get(currentState).start();
    }

    public void stopCurrentState(){
        gameFrame.remove(states.get(currentState));
        states.get(currentState).stop();
    }

    public void setCurrentState(String name){
        for(int i=0; i < states.size(); i++){
            if(name.equals(states.get(i).name)){
                currentState = i;
            }
        }
    }
}
