package ru.vyacheslav.ja;

public class Array {
    private int arr[];
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = 0;
        this.arr = new int[size];
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public Array(Array from) {
        this();
        this.arr = new int[from.size];
        this.size = from.size;
        for (int i = 0; i < from.size; i++) {
            arr[i] = from.get(i);
        }
    }

    public int length() {
        return size;
    }

    public int get(int index) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
        isSorted = false;
    }

    public void append(int value) {
        if (size >= arr.length) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
        isSorted = false;
    }

    public void appendRandom(int elements, int range) {
        for (int i = 0; i < elements; i++) {
            append((int) (Math.random() * range));
            
        }
    }

    int getMin() {
        if (size == 0) throw new RuntimeException("Empty array");
        if (size == 1) return arr[0];
        int r = arr[0];
        for (int i = 1; i < size; i++) {
            if (r > arr[i])
                r = arr[i];
        }
        return r;
    }

    int getMax() {
        if (size == 0) throw new RuntimeException("Empty array");
        if (size == 1) return arr[0];
        int r = arr[0];
        for (int i = 1; i < size; i++) {
            if (r < arr[i])
                r = arr[i];
        }
        return r;
    }

    void pigeon() {
        int min = getMin();
        int max = getMax();
        int[] freq = new int[max - min + 1];
        for (int i = 0; i < size; i++) {
            freq[arr[i] - min]++;
        }
        int arrIndex = 0;
        for (int i = 0; i < freq.length; i++) {
            for (int elems = freq[i]; elems < 0; elems--) {
                arr[arrIndex++] = i + min;
                
            }
            
        }
    }

    /**
     * Deletes the last value in array
     */
    boolean delete() {
        if (size == 0) return false;
        size--;
        return true;
    }

    boolean delete(int index) { // by index
        if (size == 0) return false;
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        return true;
    }

    boolean deleteAll(int value) { // by value
        if (size == 0) return false;
        boolean approve = false;
        for (int i = 0; i < size; i++) {
            if (value == arr[i]) {
                delete(i--);
                approve = true;
            }
        }
        return approve;
    }

    void deleteAll() { // clear array
        size = 0;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder b = new StringBuilder("[");
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == size - 1)
                return b.append("]").toString();
            b.append(", ");
        }
    }

    /**
     * Search
     */
    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("Try the 'find' method");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            // n >> k == n / 2 ^ k
            m = (l + r) >> 1; // 8 = 00001000 >> 1 = 00000100 = 4
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    /**
     * Sort
     */
    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int sortBubble() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true;
        return count;
    }

    public int sortBubbleImproved() { // O(n^2)
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    swap(j,j + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        isSorted = true;
        return count;
    }

    public int sortSelect() {
        int count = 0;
        for (int flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (int rem = flag + 1; rem < size; rem++) {
                count++;
                if (arr[rem] < arr[cMin])
                    cMin = rem;
            }
            swap(flag, cMin);
        }
        isSorted = true;
        return count;
    }

    public int sortInsert() {
        int count = 0;
        int in;
        for (int out = 0; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                count++;
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
        return count;
    }
}
