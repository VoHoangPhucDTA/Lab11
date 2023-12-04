import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public void add(E e) {
		BNode<E> newNode = new BNode<E>(e);
		int comp = data.compareTo(e);
		if (comp < 0) {
			if (right == null) {
				right = newNode;
				return;
			} else
				right.add(e);
		} else if (comp > 0) {
			if (left == null) {
				left = newNode;
				return;
			} else
				left.add(e);
		} else {

		}
	}

	public boolean contains(E e) {
		int comp = e.compareTo(data);
		if (comp == 0)
			return true;
		else if (comp < 0)
			return (left == null) ? false : left.contains(e);
		else
			return (right == null) ? false : right.contains(e);
	}

	public E findMin() {
		if (this.left == null)
			return data;
		else
			return left.findMin();

	}

	public E findMax() {
		if (this.right == null)
			return data;
		else
			return right.findMax();
	}

	public int depth(E target) {
		return depthHelper(target, 0);
	}

	private int depthHelper(E target, int currentDepth) {
		int compareResult = target.compareTo(data);
		if (compareResult == 0) {
			return currentDepth; // Node found, return its depth
		} else if (compareResult < 0) {
			return left.depthHelper(target, currentDepth + 1);
		} else {
			return right.depthHelper(target, currentDepth + 1);
		}
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}

	

	public List<E> descendants(E e) {
		int comp = data.compareTo(e);
		List<E> res = new ArrayList<E>();
		if (comp == 0) {
			if (left != null) {
				res.add(left.data);
				res.addAll(left.descendants(e));
			}
			// TODO
			if (right != null) {
				res.add(right.data);
				res.addAll(right.descendants(e));
			}
		}
		return res;
	}

	public List<E> ancestors(E e) {
		int comp = data.compareTo(e);
		List<E> res = new ArrayList<E>();
		if (comp == 0)
			return res;
		if (left != null) {
			if (left.contains(e)) {
				res.add(data);
				res.addAll(left.ancestors(e));
			}
		}
		if (right != null) {
			if (right.contains(e)) {
				res.add(data);
				res.addAll(right.ancestors(e));
			}
		}
		return res;

	}

	public int height() {
		return heightHelper();
	}

	public int heightHelper() {
		int leftHeight = left != null ? left.heightHelper() : -1;
		int rightHeight = right != null ? right.heightHelper() : -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public int size() {
		return 0;
	}

	public boolean remove(E e) {
		return removeHelper(this, e);
	}

	private boolean removeHelper(BNode<E> root, E e) {
		if (root == null) return false;
		int comp = root.data.compareTo(e);
		if (comp < 0) {
			if (removeHelper(root.left, e)) {
				root.left = null;
				return true;
			}
		} else if (comp > 0) {
			if (removeHelper(root.right, e)) {
				root.right = null;
				return true;
			}
		} else {
			if (root.left == null) return true;
			else if  (root.right == null) return true;
			
			// two children
			root.data = findMin();
			removeHelper(root.right, root.data);
			return true;
		}
		return false;
	}

	public void inorder() {
		inorderHelper(this);
	}
	
	private void inorderHelper(BNode<E> root) {
		if (root != null) {
			inorderHelper(root.left);
			System.out.print(root.data + " ");
			inorderHelper(root.right);
		}
	}

	public void preorder() {
		preorderHelper(this);
	}
	
	private void preorderHelper(BNode<E> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderHelper(root.left);
			preorderHelper(root.right);

		}
	}

	public void postorder() {
		postorderHelper(this);
	}

	private void postorderHelper(BNode<E> root) {
		if (root != null) {
			postorderHelper(root.left);
			postorderHelper(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	
	
	
	
	
	

}
