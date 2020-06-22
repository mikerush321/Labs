package lab6;

import java.rmi.NoSuchObjectException;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class SimpleBSTClient {
    private static void ManualTest() throws NoSuchObjectException {
        var tree = new BSTBreaker<Integer>();
        var scan = new Scanner(System.in);
        var capacity = 0;
        System.out.print("Введите размер:");
        capacity = scan.nextInt();
        while (capacity!=0)
        {
            System.out.print("Введите число:");
            tree.Add(scan.nextInt());
            capacity--;
        }
        System.out.print("Введите значение для замены:");
        var replace = scan.nextInt();
        System.out.print("Введите значение для заменяемого элемента:");
        var value = scan.nextInt();
        tree.Replace(replace, value);
        var start = Instant.now();
        SimpleBSTExtension.IsBSTCorrect(tree);
        var time = Duration.between(start, Instant.now()).toMillis();
        System.out.println("Привильное ли дерево: "+tree.IsBSTCorrect());
        System.out.println("Время: " + time+"ms");
    }
    private static void AutoTest() throws NoSuchObjectException {
        var rnd = new Random();
        for (int i = 10; i <= Math.pow(10,7); i*=10) {
            var tree = new BSTBreaker<Integer>();
            var testVal = 0;
            for (int j = 0; j < i; j++) {
                if(i/2==j){
                    testVal = rnd.nextInt(i);
                    tree.Add(testVal);
                }
                else tree.Add(rnd.nextInt(i));
            }
            tree.Replace(testVal, rnd.nextInt(i));
            var start = Instant.now();
            SimpleBSTExtension.IsBSTCorrect(tree);
            var time = Duration.between(start, Instant.now()).toMillis();
            System.out.println("Привильное ли дерево: "+tree.IsBSTCorrect());
            System.out.println("Время: " + time+"ms");
        }
    }
    public static void main(String[] args) throws NoSuchObjectException {
        AutoTest();
        ManualTest();
    }
}