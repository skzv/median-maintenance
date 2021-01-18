package dev.skz;

public class Main {

    public static void main(String[] args) {
        MedianMaintainer<Integer> mm = new MedianMaintainer<>();
        mm.add(1);
        System.out.println(mm.getMedian());
        mm.add(2);
        System.out.println(mm.getMedian());
        mm.add(3);
        System.out.println(mm.getMedian());
        mm.add(4);
        System.out.println(mm.getMedian());
        mm.add(5);
        System.out.println(mm.getMedian());
    }
}
