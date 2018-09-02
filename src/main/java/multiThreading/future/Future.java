package multiThreading.future;

public class Future {
  private boolean down;

  private Product product;

  public synchronized void setProduct(Product product) {
    if (down) {
      return;
    }
    this.product = product;
    down = true;
    notifyAll();
  }

  public synchronized Product get() {
    while(!down) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return product;
  }
}
