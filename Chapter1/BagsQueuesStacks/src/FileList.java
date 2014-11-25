import java.io.File;


public class FileList {
	
	private static class Node{
		public Node(int lev, String name, String parent) {
			// TODO Auto-generated constructor stub
			this.level = lev;
			this.name = name;
			this.parent = parent;
		}
		int level;
		String name;
		String parent;
	}
	
	private static void printQueue(Queue<Node> q){
		while(!q.isEmpty()){
			Node n = q.dequeue();
			File file = new File(n.parent, n.name);
			StdOut.printf("%" + (n.level + n.name.length()) + "s\n", n.name);
			if(file.isDirectory()){
				String[] files = file.list();
				Queue<Node> newq = new Queue<Node>();
				for (String str : files) {
					newq.enqueue(new Node(n.level + 1, str, n.parent + "/" + n.name));
				}
				printQueue(newq);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = args[0];
		File f = new File(path);
		assert f.isDirectory() : "not a directory";
		Queue<Node> q = new Queue<Node>();
		String[] s = f.list();
		for (String string : s) {
			q.enqueue(new Node(0, string, path));
		}
		printQueue(q);
	}

}
