package ru.vyacheslav.ja;

public class App 
{
    public static void main(String[] args) {
        Array arr0 = new Array(5);
        arr0.appendRandom(100,100);
        Array arr1 = new Array(arr0);
        Array arr2 = new Array(arr0);
        Array arr3 = new Array(arr0);

        System.out.printf("Bubble: %d\n", arr0.sortBubble());
        System.out.printf("Insert: %d\n", arr1.sortInsert());
        System.out.printf("Select: %d\n", arr2.sortSelect());
        System.out.printf("BubbleImp: %d\n", arr3.sortBubbleImproved());
    }
}
