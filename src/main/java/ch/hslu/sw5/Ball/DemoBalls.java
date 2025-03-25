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

import static ch.hslu.sw5.Ball.Ball.colourList;
import static ch.hslu.sw5.Ball.Canvas.HEIGHT;
import static ch.hslu.sw5.Ball.Canvas.WIDTH;

/**
 * Demonstration von Bällen.
 */
public final class DemoBalls {

    public static final int MIN_DIAMETER = 20;
    public static final int MAX_DIAMETER = 50;

    private static Random random = new Random();

    public static void main(final String[] args) throws InterruptedException {
        Canvas canvas = Canvas.getCanvas();
        for(int i = 0; i<30; i++) {
            Thread thread = new Thread(new Ball(randomRangeInteger(MIN_DIAMETER,MAX_DIAMETER),randomRangeInteger(1,WIDTH),randomRangeInteger(1,HEIGHT/3),randomColourString()),"ball" + i);
            thread.start();
            Thread.sleep(1000);
        }

        System.exit(0);
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

