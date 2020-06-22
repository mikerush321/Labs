package lab8.string;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class LSDClient {
    private static Random _rnd = new Random();

    //Возвращает рандомную строку шириной Width
    private static String getRandomString(int width){
        var template = "qwertyuiopasdfghjklzxcvbnm";
        var str = new StringBuilder();
        for (int i = 0; i < width; i++){
            str.append(template.charAt(_rnd.nextInt(template.length())));
        }
        return str.toString();
    }

    //Реализация теста с замером
    private static void Test(String source){
        var start = Instant.now();
        var strings = Transpositor.getTranspositions(source);
        var time = Duration.between(start, Instant.now()).toMillis();
        System.out.println("Получить: "+time+" ms");
        start = Instant.now();
        LSD.Sort(strings, source.length());
        time = Duration.between(start, Instant.now()).toMillis();
        System.out.println("LSD Sort: "+time+" ms");
        for (int i = 0; i< strings.length; i++)
        {
            System.out.println((i+1)+": "+strings[i]);
        }
    }
    private static void ManualTest(){
        System.out.print("Введите строчку:");
        Test(new Scanner(System.in).nextLine());
    }
    private static void AutoTest(){
        System.out.print("Введите длину строки:");
        var width = new Scanner(System.in).nextInt();
        Test(getRandomString(width));
    }
    public static void main(String[] args) {
        AutoTest();
        ManualTest();
    }
}
