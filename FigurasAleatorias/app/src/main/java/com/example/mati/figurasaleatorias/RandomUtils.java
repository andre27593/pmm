package com.example.mati.figurasaleatorias;

import java.util.Objects;
import java.util.Random;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by mati on 9/11/16.
 */

public class RandomUtils {

    private static Random r = new Random();

    public static int randomInt(int range){
        return(r.nextInt(range));
    }

    public static int randomIndex(Object[] array){
        return(randomInt(array.length));
    }

    public static <T> T randomElement(T[] array){
        return(array[randomIndex(array)]);
    }

    public static float randomFloat(int n){
        return(float)Math.random()*n;
    }
}
