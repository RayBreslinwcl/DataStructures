package com.DataStructures._01Arrays;

/**
 * Created by Administrator on 2018/12/10.
 */
public class _06student {
    private String name;
    private int score;

    public _06student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        _06ArrayFanxing<_06student> arr = new _06ArrayFanxing<>();
        arr.addLast(new _06student("Alice", 100));
        arr.addLast(new _06student("Bob", 66));
        arr.addLast(new _06student("Charlie", 88));
        System.out.println(arr);
    }
}
