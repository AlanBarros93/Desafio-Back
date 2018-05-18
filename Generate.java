/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alan.oliveira.bd;

import java.util.Random;

/**
 *
 * @author Alan Oliveira
 */
public class Generate {
    
    public static int geraAleatorio(int max, int min) {
        Random random = new Random();
        return (random.nextInt(max - (min - 1)) + min);
    }
    
}
