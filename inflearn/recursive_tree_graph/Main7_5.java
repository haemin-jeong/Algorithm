package inflearn.recursive_tree_graph;

//이진트리 순회(깊이 우선 탐색)
public class Main7_5 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print("전위 순회 : ");
        preorder(root);
        System.out.println();

        System.out.print("중위 순회 : ");
        inorder(root);
        System.out.println();

        System.out.print("후위 순회 : ");
        postorder(root);
        System.out.println();
    }

    //전위 순회 : 부모 -> 왼쪽 자식 -> 오른쪽 자식
    private static void preorder(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //중위 순회 : 왼쪽 자식 -> 부모 -> 오른쪽 자식
    private static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //후위 순회 : 왼쪽 자식 -> 오른쪽 자식 -> 부모
    private static void postorder(Node root) {
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

}