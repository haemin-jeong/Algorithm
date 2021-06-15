package inflearn.recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;

//Tree 말단 노드까지의 가장 짧은 경로
public class Main7_9 {

    public static int bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 0; //트리의 현재 레벨 = 간선의 개수

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node node = q.poll();

                if (node.left == null && node.right == null) //자식노드가 없다는건 말단 노드
                    return level;

                q.offer(node.left);
                q.offer(node.right);
            }

            level++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);

        System.out.println(bfs(root));
    }
}
