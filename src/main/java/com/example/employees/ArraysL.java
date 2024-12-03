package com.example.employees;

import java.util.ArrayList;
import java.util.List;

public class ArraysL {

//    Необходимо реализовать следующий метод:
//
//    Получаем на входе массив чисел.
//    Все четные числа увеличиваем на единицу.
//    Возвращаем кусок списка с 3-го по 7-й элемент.

    public static void main(String[] args) {
        int[] arg = {1, 2, 3, 4, 5, 6, 7, 8, 9,10};
        System.out.println(newList( arg ));
    }

    public static List<Integer> newList(int[] args){
        List<Integer> res = new ArrayList<>();
        for (int num: args) {
            res.add(num % 2 == 0 ? num + 1 : num);
        }
        return res.subList( 2,7 );
    }
}
