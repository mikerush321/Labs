package lab9;

import java.util.Random;

public class CharGrid{
    private CharGrid(){ }
    private static Random _rnd = new Random();

    public static char[][] generate(int N){
        var chars = new char[N][N];
        for (int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                chars[row][col] = (char)(_rnd.nextInt(26)+65);
            }
        }
        return chars;
    }

    public static void printGrid(char[][] chars, int N){
        for (int row = 0; row < N; row++){
            for(int col = 0; col < N; col++){
                System.out.print("["+chars[row][col]+"]");
            }
            System.out.println();
        }
    }
}