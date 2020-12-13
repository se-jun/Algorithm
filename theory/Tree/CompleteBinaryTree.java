package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

    char[] nodes; // char 관리하는 tree

    int lastIndex; // 현재 데이터의 위치.

    final int size; // 관리할 데이터의 크기.

    public CompleteBinaryTree(int size) {
        this.size = size;
        nodes = new char[size + 1]; // 배열의 시작이 1번이므로.
    }
    
    public boolean isEmpty() {
        return lastIndex == 0;
    }

    public boolean isFull() {
        return lastIndex == size;
    }

    public void add(char data) {
        if(isFull()) {
            System.out.println("full!!");
            return;
        }
        else {
            nodes[++lastIndex] = data;
        }
    }
    
    public void bfs() {

        StringBuilder output = new StringBuilder();
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        
        Integer front;
        
        while(!q.isEmpty()) {
            front = q.poll();
            
            output.append(nodes[front]).append(" ");
            
            if(front * 2 <=lastIndex) {
                q.add(front*2);
            }
            if(front * 2+1 <= lastIndex) {
                q.add(front * 2 +1);
            }
        }
        System.out.println(output);
    }

    public void bfs2() {
        StringBuilder output = new StringBuilder();
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        
        Integer front;
        int level = 0, size;
        
        while(!q.isEmpty()) {
            size = q.size();
            
            output.append("현재 레벨은 : " + level++ + "\n");
            
            while(--size >= 0) {
                front = q.poll();
                output.append(nodes[front]).append(" ");
                if(front * 2 <=lastIndex) {
                    q.add(front*2);
                }
                if(front * 2+1 <= lastIndex) {
                    q.add(front * 2 +1);
                }
                
            }
            output.append("\n");
        }
        System.out.println(output);
    }

    private void preOrder(int idx) {
        if(idx <= lastIndex) {
            System.out.println(nodes[idx] + " ");
            preOrder(idx*2);
            preOrder(idx*2+1);
        }
    }
    
    public void printPreOrder() {
        System.out.println("preorder");
        preOrder(1);
    }
    
    private void postOrder(int idx) {
        if(idx <= lastIndex) {
            preOrder(idx*2);
            preOrder(idx*2+1);
            System.out.println(nodes[idx] + " ");
        }
    }
    
    public void printPostOrder() {
        System.out.println("postorder");
        postOrder(1);
    }
    
    private void inOrder(int idx) {
        if(idx <= lastIndex) {
            preOrder(idx*2);
            System.out.println(nodes[idx] + " ");
            preOrder(idx*2+1);
        }
    }
    
    public void printInOrder() {
        System.out.println("preorder");
        inOrder(1);
    }
    
    
}












