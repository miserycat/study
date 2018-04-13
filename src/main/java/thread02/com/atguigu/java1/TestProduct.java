package thread02.com.atguigu.java1;

/*
 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，店员一次只能持有固定数量的产品(比如:20），
 如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，
 店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 这里可能出现两个问题：
 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 消费者比生产者快时，消费者会取相同的数据
 */
public class TestProduct {
	
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		
		Productor p = new Productor(clerk);
		Customer c = new Customer(clerk);
		
		new Thread(p).start();
		new Thread(c).start();
	}

}

class Clerk {
	private int product;

	public Clerk() {
	}

	// 进货
	public synchronized void getProduct() {
		if (product >= 20) {
			System.out.println("产品已满！");
			
			try {
				wait();
			} catch (InterruptedException e) {
			}
			
		} else {
			System.out.println("生产者生产了第 " + ++product + " 个产品");
			
			notifyAll();
		}
	}

	// 卖货
	public synchronized void saleProduct() {
		if (product <= 0) {
			System.out.println("缺货！");
			
			try {
				wait();
			} catch (InterruptedException e) {
			}
			
		} else {
			System.out.println("消费者取走了第 " + product-- + " 个产品");
			
			notifyAll();
			
		}
	}

}

// 生产者
class Productor implements Runnable {

	private Clerk clerk;

	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		while (true) {
			clerk.getProduct();
		}
	}
}

// 消费者
class Customer implements Runnable {

	private Clerk clerk;

	public Customer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		while(true){
			clerk.saleProduct();
		}
	}

}