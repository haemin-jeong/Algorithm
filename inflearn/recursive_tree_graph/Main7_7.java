package inflearn.recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;

//이진트리 순회(넓이우선탐색 : 레벨탐색)
public class Main7_7 {

    public static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                System.out.print(node.data + " ");

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        bfs(root);
    }

}
