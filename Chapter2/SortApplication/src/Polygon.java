import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import jdk.nashorn.internal.ir.WhileNode;


public class Polygon {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		ArrayList<Point2D> l = new ArrayList<Point2D>();
		while(in.hasNext()){
			l.add(new Point2D(in.nextInt(), in.nextInt()));
		}
		Collections.sort(l, Point2D.CO_ORDER);
		Collections.sort(l, l.get(0).POLAR_ORDER);
		l.add(l.get(0));
		Stack<Point2D> s = new Stack<Point2D>();
		s.push(l.get(0));
		s.push(l.get(1));
		for (int i = 2; i < l.size(); i++) {
			Point2D p = s.pop();
			while(Point2D.ccw(s.peek(), p, l.get(i)) <= 0){
				p = s.pop();
			}
			s.push(p);
			s.push(l.get(i));
		}
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}

}
