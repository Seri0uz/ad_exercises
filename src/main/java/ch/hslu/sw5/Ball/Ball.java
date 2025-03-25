/*
 * Copyright 2025 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.sw5.Ball;

import java.util.Random;

import static ch.hslu.sw5.Ball.DemoBallsVirtualThreads.MIN_DIAMETER;

/**
 * Description of class Ball
 */
public final class Ball implements Runnable {

    private final int size;
    private int xPos;
    private int yPos;
    private String color;


    private static Random random = new Random();

    public static final String[] colourList = new String[]{
            "red", "black", "blue",
            "yellow", "green", "magenta" };

    /**
     * Erzeugt einen Ball mit gegebenen Parametern Grösse, Position und Farbe.
     *
     */
    public Ball(final int size, final int xPos, final int yPos, String color) {
        this.size = size;
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
    }

    @Override
    public void run() {
        Circle circle = new Circle(size,xPos,yPos,color);

        circle.makeVisible();

        int velocity = size/2;
        while(circle.getY() < Canvas.HEIGHT-circle.getDiameter()){
            circle.moveVertical(velocity);
        }
        while (circle.getDiameter() >= MIN_DIAMETER){
            circle.changeSize(circle.getDiameter()-1);
        }

        circle.makeInvisible();

    }


}
