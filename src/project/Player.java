/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Alexa
 */
public class Player {

    private String name;
    private boolean ai;
    private boolean madeStep;
    private char figure;

    public Player() {
    }

    public Player(String name, boolean ai, boolean madeStep, char figure) {
        this.name = name;
        this.ai = ai;
        this.madeStep = madeStep;
        this.figure = figure;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", ai=" + ai + ", madeStep=" + madeStep + '}';
    }

    public boolean isMadeStep() {
        return madeStep;
    }

    public void setMadeStep(boolean madeStep) {
        this.madeStep = madeStep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAi() {
        return ai;
    }

    public void setAi(boolean ai) {
        this.ai = ai;
    }

    public char getFigure() {
        return figure;
    }

    public void setFigure(char figure) {
        this.figure = figure;
    }
    
    

}
