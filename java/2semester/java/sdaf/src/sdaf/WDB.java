package sdaf;

class Tree{
	class Node{
		int data;
		Node left;
		Node right;
		Node (int data) {
			this.data = data;
		}
	}
		Node root; 
		public void makeTree(int[] a) {
			root = makeTreeR(a, 0, a.length -1);
			//makeTreeR에 매개변수 a, 0, a배열길이에서 -1을 뺀게 a, start, end
		} 
		private Node makeTreeR(int[] a, int start, int end) {
			if(start > end) return null; //만약 start가 end보다 크면 return null
			int mid = (start + end) /2; //중간값 찾기
			Node node = new Node(a[mid]); //Node객체에 a배열 중간값 크기 생성
			node.left = makeTreeR(a, start, mid-1);
			node.right = makeTreeR(a, mid +1, end);
			return node;
		}
		public void searchBTree(Node n, int find) {
			if(find < n.data) {
				System.out.println("현재 노드 "+find+" 한 레벨 위 "+ n.data);
				searchBTree(n.left, find);
				System.out.println(n.left);
			}else if(find > n.data) {
				System.out.println("현재 노드 "+find+" 한 레벨 아래 " + n.data);
				searchBTree(n.right, find);
			}else {
				System.out.println("노드 찾았다!");
			}
		}
	

	
}
public class WDB {
	public static void main(String[] args) {
		
		int[] a = new int[10];//배열 10개
		for(int i=0; i<a.length; i++) {
			a[i] = i; //각배열에 0부터9까지
		} 
		
		Tree t = new Tree();
		t.makeTree(a); //트리생성
		t.searchBTree(t.root, 9); //노드 찾기
	}

}
