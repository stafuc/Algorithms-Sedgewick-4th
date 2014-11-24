import java.util.Iterator;


public class RandomQueue<Item> implements Iterable<Item>{
	
	private Item[] a = (Item[])new Object[1];
	int N;
	
	private void resize(int max){
		Item[] temp = (Item[])new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void enqueue(Item item){
		if(N == a.length)	resize(2 * a.length);
		a[N++] = item;
	}
	
	public Item dequeue(){
		int i = StdRandom.uniform(N);
		Item temp = a[i];
		a[i] = a[N - 1];
		a[N - 1] = temp;
		N--;
		if(N > 0 && N <= a.length / 4)	resize(a.length / 2);
		return temp;
	}
	
	public Item sample(){
		return a[StdRandom.uniform(N)];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomQueue<Integer> rq = new RandomQueue<Integer>();
		rq.enqueue(1);
		rq.enqueue(2);
		rq.enqueue(3);
		rq.enqueue(4);
//		int[] cnt = new int[4];
//		for (int i = 0; i < 1000; i++) {
//			cnt[rq.sample() - 1]++;
//		}
//		StdOut.println(cnt[0] + " " + cnt[1] + " " + cnt[2] + " " + cnt[3]);
//		
//		rq.dequeue();
//		rq.dequeue();
//		rq.dequeue();
		
		for (Integer integer : rq) {
			StdOut.println(integer);
		}

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RandomQueueIterator();
	}
	
	private class RandomQueueIterator implements Iterator<Item>{

		public RandomQueueIterator() {
			// TODO Auto-generated constructor stub
			for (int i = 0; i < a.length; i++) {
				Item temp = a[i];
				int j = StdRandom.uniform(i, N);
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		int cur = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cur < N;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[cur++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
