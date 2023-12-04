import java.util.Collection;
import java.util.List;


public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		if (root == null)
			root = new BNode<E>(e);
		root.add(e);
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			root.add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		return root.depth(node);
	}

	// compute the height of BST
	public int height() {
		return root.height();
	}

	// Compute total nodes in BST
	public int size() {
		return root.size();
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		return root.contains(e);
	}

	// Find the minimum element in BST
	public E findMin() {
		if (root == null)
			return null;
		return root.findMin();
	}

	// Find the maximum element in BST
	public E findMax() {
		if (root == null)
			return null;
		return root.findMax();
	}

	// Remove element e from BST
	public boolean remove(E e) {
		return root.remove(e);
	}

	// get the descendants of a node (chau chat)
	public List<E> descendants(E data) {
		return root.descendants(data);
	}

	// get the ancestors of a node (to tien)
	public List<E> ancestors(E data) {
		return root.ancestors(data);
	}
	
	public void inorder() {
		root.inorder();
	}
	
	public void preorder() {
		root.preorder();
	}
	
	public void postorder() {
		root.postorder();
	}

	public static void test() {
		BST<Integer> myBST = new BST<Integer>();
		myBST.init();

		myBST.add(90);
		myBST.add(5);

		System.out.println("Find Max: " + myBST.findMax());
		System.out.println("Find Min: " + myBST.findMin());
		
		
		
		System.out.println("Tổ tiên của 10: " + myBST.ancestors(10));
		System.out.println("Cháu chắt của 15: " + myBST.descendants(15));
		
		System.out.println("Depth của Node 10: " + myBST.depth(10));
		
		System.out.println("Height của BST: " + myBST.height());
		
		System.out.print("Duyệt cây inorder: ");
		myBST.inorder();
		System.out.println();
		
		System.out.print("Duyệt cây preorder: ");
		myBST.preorder();
		System.out.println();
		
		System.out.print("Duyệt cây postorder: ");
		myBST.postorder();
		System.out.println();


	}

	public void init() {
		BNode<Integer> b1 = new BNode<Integer>(25);
		BNode<Integer> b2 = new BNode<Integer>(15);
		BNode<Integer> b3 = new BNode<Integer>(50);
		BNode<Integer> b4 = new BNode<Integer>(10);
		BNode<Integer> b5 = new BNode<Integer>(22);
		BNode<Integer> b6 = new BNode<Integer>(35);
		BNode<Integer> b7 = new BNode<Integer>(70);

		root = (BNode<E>) b1;
		b1.setLeft(b2);
		b1.setRight(b3);
		b2.setLeft(b4);
		b2.setRight(b5);
		b3.setLeft(b6);
		b3.setRight(b7);

	}

	public static void main(String[] args) {
		test();
	}

}
