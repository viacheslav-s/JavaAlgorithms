package ru.vyacheslav.ja;

public class App 
{
    public static void main( String[] args ) {
        HashTable ht = new HashTable(25);
        ht.insert(new Cat(10, ""));
        ht.insert(new Cat(20, ""));
        ht.insert(new Cat(30, ""));
        ht.insert(new Cat(40, ""));
        ht.insert(new Cat(50, ""));
        ht.insert(new Cat(60, ""));
        ht.insert(new Cat(70, ""));
        ht.insert(new Cat(75, ""));
        ht.insert(new Cat(125, ""));
        ht.insert(new Cat(1, ""));
        System.out.println(ht);
        ht.delete(75);
        System.out.println(ht);
    }
}
