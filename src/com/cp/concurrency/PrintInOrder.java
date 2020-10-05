package com.cp.concurrency;

import java.util.concurrent.Semaphore;

public class PrintInOrder {

  Semaphore run2, run3;

  public PrintInOrder() {
    run2 = new Semaphore(0);
    run3  = new Semaphore(0);
  }

  public void first(Runnable printFirst) throws InterruptedException {
    // printFirst.run() outputs "first". Do not change or remove this line.
    printFirst.run();
    run2.release();
  }

  public void second(Runnable printSecond) throws InterruptedException {
    // printSecond.run() outputs "second". Do not change or remove this line.
    if(run2.tryAcquire())
      printSecond.run();
    run3.release();
  }

  public void third(Runnable printThird) throws InterruptedException {
    // printThird.run() outputs "third". Do not change or remove this line.
    if(run3.tryAcquire())
      printThird.run();
  }
}
