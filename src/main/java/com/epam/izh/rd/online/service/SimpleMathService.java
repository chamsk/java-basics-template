package com.epam.izh.rd.online.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        return value1>value2?1:((value1==value2)?0:-1);
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        int result = 0;
        if (value1==value2){
            throw new ArithmeticException("Вы ввели одинаковые числа");
        }
        result = value1>value2?value1:value2;
        return result;
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        return Arrays.stream(values).boxed().max(Integer::compare).get();
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        return Arrays.stream(values).sum();
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        return Arrays.stream(values).filter(x -> (x % 2)==0).boxed().mapToInt(o -> (int)o).toArray();
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        if(initialVal < 0){
            throw new ArithmeticException("Отрицательное число недопустимо");
        }
        long result = 1L;
        for(int i=initialVal; i>0; i--){
            result*=i;
        }
        return result;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        if(number < 0){
            throw new ArithmeticException("Отрицательное число недопустимо");
        }
        List<Long> list = new ArrayList<>();
        list.add(0l);
        list.add(1l);
        for (int i=2; i<=number; i++){
            int temp = list.size();
            list.add(list.get(temp-2)+list.get(temp-1));
        }
        return list.get(number);
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        for (int i=0; i<values.length;i++){
            for(int j=0;j<values.length;j++){
                if(values[i]<values[j]){
                    int temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }
        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        if(number<2){
            return false;
        }
        if (number==2||number==3){
            return true;
        }
        if(number % 2 == 0){
            return false;
        }
        if(number % 3 == 0){
            return false;
        }
        return true;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int[] result = new int[values.length];
        int size = values.length;
        for (int i=0;i<values.length;i++){
            size--;
            result[i] = values[size];
        }
        return result;
    }
}
