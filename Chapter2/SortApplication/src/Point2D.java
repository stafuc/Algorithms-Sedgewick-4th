import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Point2D {
	int x, y;
	public Point2D(int x1, int y1) {
		// TODO Auto-generated constructor stub
		x = x1;
		y = y1;
	}
	
	public String toString() {
		return x + " " + y;
	}
	
	public static final XOrder X_ORDER = new XOrder();
	public static final YOrder Y_ORDER = new YOrder();
	public static final CoordinateOrder CO_ORDER = new CoordinateOrder();
	public final PolarOrder POLAR_ORDER = new PolarOrder();
	
	private class PolarOrder implements Comparator<Point2D>{
		@Override
		public int compare(Point2D o1, Point2D o2) {
			// TODO Auto-generated method stub
			int dy1 = o1.y - y;
			int dy2 = o2.y - y;
			int dx1 = o1.x - x;
			int dx2 = o2.x - x;
			if(dy1 >= 0 && dy2 < 0)	return -1;
			else if(dy1 < 0 && dy2 >= 0)	return 1;
			else if(dy1 == 0 && dy2 == 0){
				if(dx1 >= 0 && dx2 < 0)	return -1;
				else if(dx1 < 0 && dx2 >= 0)	return 1;
				else	return dx1 - dx2;	//避免重复点的情况
			}else{
				int ret = -ccw(Point2D.this, o1, o2);
				if(ret != 0)	return ret;
				else{
					double s1 = distance(o1), s2 = distance(o2);
					if(s1 < s2)	return -1;
					else if(s1 > s2)	return 1;
					else	return 0;
				}
			}
		}
	}
	
	public double distance(Point2D p1) {
		return Math.sqrt((x - p1.x) * (x - p1.x) + (y - p1.y) * (y - p1.y));
	}
	
	public static int ccw(Point2D a, Point2D b, Point2D c) {
		int area = (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
		if(area > 0)	return 1;
		else if(area < 0)	return -1;
		else	return 0;
	}
	
	private static class XOrder implements Comparator<Point2D>{
		@Override
		public int compare(Point2D o1, Point2D o2) {
			// TODO Auto-generated method stub
			return o1.x - o2.x;
		}	
	}
	
	private static class CoordinateOrder implements Comparator<Point2D>{
		@Override
		public int compare(Point2D o1, Point2D o2) {
			// TODO Auto-generated method stub
			if(o1.y < o2.y)	return	-1;
			else if(o1.y > o2.y)	return 1;
			else	return o1.x - o2.x;
		}
	}
	
	private static class YOrder implements Comparator<Point2D>{
		@Override
		public int compare(Point2D o1, Point2D o2) {
			// TODO Auto-generated method stub
			return o1.y - o2.y;
		}	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point2D p1 = new Point2D(0, 0);
		Point2D p2 = new Point2D(1, 1);
		Point2D p3 = new Point2D(-1, 1);
		Point2D	p4 = new Point2D(-2, -2);
		Point2D	p5 = new Point2D(2, -2);
		ArrayList<Point2D> l = new ArrayList<Point2D>();
		l.add(p1);
		l.add(p2);
		l.add(p3);
		l.add(p4);
		l.add(p5);
		Collections.sort(l, p4.POLAR_ORDER);
		for (Point2D point2d : l) {
			System.out.println(point2d.x + " " + point2d.y);
		}
	}

}
