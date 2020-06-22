package lab9;

import java.util.Scanner;

public class WordSearchInGridClient{

    private static void ManualGenGrid(){
        System.out.print("Введите сетку (N x N) размером: ");
        var N = new Scanner(System.in).nextInt();
        var chars = new char[N][N];
        var rowIndex = 0;
        while(rowIndex!=N){
            System.out.print(String.format("Введите строку, длина которой равна %d:", N));
            var row = new Scanner(System.in).nextLine();
            if(row.length()!=N){
                System.out.println(String.format("Ошибка: длина строки должна быть равна %d", N));
                continue;
            }
            chars[rowIndex] = row.toUpperCase().toCharArray();
            rowIndex++;
        }
        Test(chars);
    }

    private static void Test(char[][]chars){
        CharGrid.printGrid(chars, chars.length);
        do {
            System.out.print("Введите слово (количество букв >= 2) или выход(q):");
            var word = new Scanner(System.in).nextLine();

            if(word.toLowerCase().equals("q"))
                break;
            if(word.length()<2) {
                System.out.println("Ошибка: длина менее 2");
                continue;
            }

            var paths = Searcher.GetWords(word.toUpperCase(), chars, chars.length);
            if(paths.size()==0)
                System.out.println("Слово не найдено");
            else
                for (var path:paths) {
                    System.out.println(String.format("Слово \"%s\" Найдено\n\tСтрока: %d\n\tКолонка: %d\n\tПозиция: %s",
                            word, path.Row()+1, path.Column()+1, path.Direction().toString()));
                }
        } while(true);
    }

    private static void AutoGenGrid(){
        System.out.print("Введите сетку (N x N) размером: ");
        var N = new Scanner(System.in).nextInt();
        Test(CharGrid.generate(N));
    }
    public static void main(String[] args) {
        ManualGenGrid();
        AutoGenGrid();
    }
}