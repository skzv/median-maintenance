package dev.skz;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianMaintainer <T extends Comparable<T>> {
  PriorityQueue<T> hLo = new PriorityQueue<>(Collections.reverseOrder());
  PriorityQueue<T> hHi = new PriorityQueue<>();
  T currentMedian = null;

  public void add(T x) {
    if (hLo.size() == 0) {
      hLo.add(x);
    } else if (x.compareTo(hLo.peek()) <= 0) {
      hLo.add(x);
    } else if (x.compareTo(hLo.peek()) > 0) {
      hHi.add(x);
    }
    rebalanceIfNecessary();
    currentMedian = hLo.peek();
  }

  public T getMedian() {
    return currentMedian;
  }

  // hLo will always have more if the total is odd
  private void rebalanceIfNecessary() {
    T x;

    while (hHi.size() > hLo.size()) {
      x = hHi.poll();
      hLo.add(x);
    }

    while (hLo.size() - hHi.size() > 1) {
      x = hLo.poll();
      hHi.add(x);
    }
  }
}
