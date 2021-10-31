package com.tms.lesson13.prog02FunctionalInterface;

import java.util.Scanner;

/**
 * 3. Создать обобщенный функциональный интерфейс.
 * Написать класс с одним методом (подумать и аргмументировать решение о том будет ли это статический метод или нет).
 * В этом методе реализуйте логику:
 * 	- если в консоль введена цифра 1, то: использования интерфейса со строковым типом и передать в метод интерфейса
 * 	логику реверса строки(вывода строки в обратном порядке).
 *
 * 	- если в консоль введена цифра 2, то: использования интерфейса с целочисленным типом и передать в метод интерфейса
 * 	логику нахождения факториала числа.
 */
public class GenericFunctionalDemo {
    public static void main(String[] args) {
        String inStr = "Строка для вывода в обратном порядке";
        int randomNumber = (int) (Math.random() * (11 - 1)) + 1; // Диапазон целых чисел [1; 11)(11 не включительно). Формула (Math.random()*(b-a))+a) = [a; b)

        // В консоль вводится цифра 1 или 2
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Введите цифру 1 или 2: ");
            int number = 0;

            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    number = sc.nextInt();
                    if (number == 1) {
                        System.out.println();
                        System.out.println("Вы ввели число " + number);
                        System.out.println("Выполняется реверс строки \"" + inStr + "\"...");
                        System.out.println();

                        // Описываем тело метода
                        IFunc<String> reverse = (str) -> {
                            String result = "";
                            for (int i = str.length() - 1; i >= 0; i--)
                                result += str.charAt(i);
                            return result;
                        };

                        // Используем наш метод
                        System.out.println("Результат: " + reverse.func(inStr));

                        break;
                    } else if (number == 2){
                        System.out.println();
                        System.out.println("Вы ввели число " + number);
                        System.out.println("Случаное число = " + randomNumber + ". Высчитываю факториал случайного числа...");
                        System.out.println();

                        // Описываем тело метода
                        IFunc<Integer> calculateFactorial = (numberInt) -> {
                            int result = 1;
                            for (int i = 1; i <= numberInt; i ++){
                                result = result * i;
                            }
                            return result;
                        };

                        // Используем наш метод
                        System.out.println("Результат равен " + calculateFactorial.func(randomNumber));

                        break;
                    }
                    else {
                        System.out.println("Число " + number + " не соответствует заданному диапазону. Попробуйте ещё раз.");
                        System.out.println();
                        System.out.print("Введите цифру 1 или 2: ");
                    }
                } else {
                    String str = sc.nextLine();
                    System.out.println("\"" + str + "\" не является целым числом. Попробуйте ещё раз.");
                    System.out.println();
                    System.out.print("Введите цифру 1 или 2: ");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
