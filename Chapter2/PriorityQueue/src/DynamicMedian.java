import java.util.Arrays;


public class DynamicMedian<Key> {
	private MaxPQ<Key> maxpq;
	private MinPQ<Key> minpq;
	
	public DynamicMedian() {
		// TODO Auto-generated constructor stub
		maxpq = new MaxPQ<Key>();
		minpq = new MinPQ<Key>();
	}
	
	public void insert(Key v){
		if(maxpq.size() == 0 || ((Comparable)v).compareTo(maxpq.max()) < 0)	maxpq.insert(v);
		else	minpq.insert(v);
		if(maxpq.size() - minpq.size() > 1){
			Key k = maxpq.delMax();
			minpq.insert(k);
		}else if(minpq.size() - maxpq.size() > 1){
			Key k = minpq.delMin();
			maxpq.insert(k);
		}
	}
	
	public Key median() {
		if(maxpq.size() > minpq.size())	return maxpq.max();
		else if(maxpq.size() == minpq.size())	return maxpq.max();
		else return minpq.min();
	}
	
	public Key delMedian() {
		if(maxpq.size() > minpq.size())	return maxpq.delMax();
		else if(maxpq.size() == minpq.size())	return maxpq.delMax();
		else 	return minpq.delMin();
	}
	
	public void size() {
		System.out.println(maxpq.size() + " " + minpq.size());
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicMedian<Integer> dm = new DynamicMedian<Integer>();
		dm.insert(3);
		dm.insert(2);
		dm.insert(10);
		dm.insert(100);
		System.out.println(dm.median());
		dm.delMedian();
		System.out.println(dm.median());
		dm.delMedian();
		System.out.println(dm.median());
		dm.delMedian();
		System.out.println(dm.median());
		

	}

}
