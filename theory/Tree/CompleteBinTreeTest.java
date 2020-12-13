package Tree;

public class CompleteBinTreeTest {
    public static void main(String[] args) {
        int size = 10;
        CompleteBinaryTree tree = new CompleteBinaryTree(size);
        
        for(char i = 'A'; i<'A'+size; i++) {
            tree.add(i);
        }
        
        tree.bfs2();
    }
}
