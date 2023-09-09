package task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.*;

/* 
Количество букв
Введи с клавиатуры 10 строчек и посчитай в них количество различных букв без учета регистра. Результат выведи на экран в алфавитном порядке.

Пример вывода:
а 5
б 8
в 3
г 7
д 0
...
я 9


Requirements:
1. Программа должна 10 раз считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Выведенный текст должен содержать 33 строки.
4. Каждая строка вывода должна содержать букву русского алфавита, пробел и количество раз, которое буква встречалась в введенных строках.*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Locale russianLocale = new Locale("ru", "RU");
        Collator collator = Collator.getInstance(russianLocale);


        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String line = reader.readLine();
            list.add(line.toLowerCase());
        }

        TreeMap<Character, Integer> map = new TreeMap<>(new Comparator<Character>() { //создание объекта анонимного класса с переопределенным методом сравнения с учетом локализации
            @Override
            public int compare(Character c1, Character c2) {
                return collator.compare(c1.toString(), c2.toString());
            }
        });

        for (Character abc: alphabet){
            int count = 0;

            for(String string: list){

                char[] token = string.toCharArray();

                for (int i = 0; i < token.length; i++) {
                    if (token[i] == abc){
                        count++;
                    }
                }
            }
            map.put(abc, count);


        }

        for (var put: map.entrySet()){
            System.out.println(put.getKey() + " " + put.getValue());
        }
    }
}
