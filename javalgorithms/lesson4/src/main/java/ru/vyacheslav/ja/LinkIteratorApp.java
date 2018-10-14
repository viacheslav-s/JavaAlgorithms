package ru.vyacheslav.ja;

import java.util.Iterator;

public interface LinkIteratorApp<T> extends Iterator {
        void reset();
        boolean atEnd();
        boolean atBegin();
        T deleteCurrent();
        void insertFirst(T c);
        void insertLast(T c);
        T getCurrent();
}