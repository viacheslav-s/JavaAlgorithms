package ru.vyacheslav.ja;

public class App 
{
    public static void main(String[] args) {
        DoublyRelatedList drl = new DoublyRelatedList();
        System.out.println(drl);
        drl.push(new Cat(1, "cat-1"));
        drl.push(new Cat(2, "cat-2"));
        drl.push(new Cat(3, "cat-3"));
        System.out.println(drl);
        drl.pop();
        System.out.println(drl);
        drl.pop();
        System.out.println(drl);
        drl.deleteCurrent();
        System.out.println(drl);
        drl.push(new Cat(5, "cat-5"));
        System.out.println(drl);
        drl.delete(new Cat(5, "cat-5"));
        System.out.println(drl);
    }
}
