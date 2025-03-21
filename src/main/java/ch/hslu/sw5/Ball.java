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
package ch.hslu.ad.exercise.n1.balls;

import java.util.Random;

/**
 * Description of class Ball
 */
public final class Ball implements Runnable {

    public static final int MIN_DIAMETER = 20;
    public static final int MAX_DIAMETER = 50;

    private static Random random = new Random();

    public static final String[] colourList = new String[]{
            "red", "black", "blue",
            "yellow", "green", "magenta" };

    /**
     * Erzeugt einen Ball mit gegebenen Parametern Grösse, Position und Farbe.
     *
     */
    public Ball() {
    }

    @Override
    public void run() {
        Circle circle = new Circle(Ball.randomRangeInteger(MIN_DIAMETER,MAX_DIAMETER),
                randomRangeInteger(1,Canvas.WIDTH),randomRangeInteger(1,Canvas.HEIGHT/3),
                randomColourString());

        circle.makeVisible();

        int velocity = Ball.randomRangeInteger(1,10);
        while(circle.getY() < Canvas.HEIGHT-circle.getDiameter()){
            circle.moveVertical(velocity);
        }
        while (circle.getDiameter() >= MIN_DIAMETER){
            circle.changeSize(circle.getDiameter()-1);
        }

        circle.makeInvisible();

    }


    public static int randomRangeInteger(int min, int max){
        if(random == null){
            random = new Random();
        }

        return random.nextInt(min+max)+min;
    }

    public static String randomColourString(){
        return colourList[randomRangeInteger(0,colourList.length)];
    }
}
