import java.util.Iterator;


public class RandomBag<Item> implements Iterable<Item>{
	
	private Item[] a = (Item[])new Object[1];
	private int N;
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	private void resize(int max){
		Item[] temp = (Item[])new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public void add(Item item){
		if(N == a.length)	resize(a.length * 2);
		a[N++] = item;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomBag<Integer> b = new RandomBag<Integer>();
		b.add(3);
		b.add(4);
		b.add(1);
		b.add(2);
		b.add(5);
		for (Integer integer : b) {
			StdOut.println(integer);
		}
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RandomBagIterator();
	}
	
	private class RandomBagIterator implements Iterator<Item>{

		public RandomBagIterator() {
			// TODO Auto-generated constructor stub
			for(int i = 0; i < N; ++i){
				int j = StdRandom.uniform(i, N);
				Item temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		int index = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return index < N;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[index++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
