package ru.vyacheslav.ja;

public class App 
{
    public static void main(String[] args) {
        DoublyRelatedList drl = new DoublyRelatedList();
        System.out.println(drl);
        System.out.println("First inserting:");
        drl.insertFirst(new Cat(2, "cat-1"));
        drl.insertFirst(new Cat(2, "cat-2"));
        drl.insertFirst(new Cat(2, "cat-3"));
        drl.insertFirst(new Cat(2, "cat-4"));
        System.out.println(drl);

        System.out.println("Last inserting:");
        drl.insertLast(new Cat(2, "cat-1"));
        drl.insertLast(new Cat(2, "cat-2"));
        drl.insertLast(new Cat(2, "cat-3"));
        drl.insertLast(new Cat(2, "cat-4"));
        System.out.println(drl);

    }
}
