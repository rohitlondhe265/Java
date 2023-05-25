package Trees;

import java.util.ArrayList;

public class CBST {

    // insert in BST
    public Node insertRec(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.data > val) {
           root.left = insertRec(root.left, val);
        } else {
           root.right = insertRec(root.right, val);
        }
        return root;
    }
    public Node insert(int[] arr) {
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insertRec(root, arr[i]);
        }
        return root;
    }

    // Search in BST
    public boolean includes(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data > key) {
            return includes(root.left, key);
        } else if(root.data == key) {
            return true;
        } else {
            return includes(root.right, key);
        }
    }

    // Delete in BST
    // 3 cases here : Node we want to delete has 1) No child { leaf Node }, 2) One child, 3) Two Childeren { replace the Node with it's Inorder successor and Delete the Node for Inorder Successor }
    // Inorder Successor : The Left Most Node in the Right Subtree OF the Root Node is it's Inorder Successor. Inorder Successor always has 0 or 1 child.
    public Node inorderSuccessor(Node root) {
        while (root.left != null) {
            inorderSuccessor(root.left);
        }
        return root;
    }
    public Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if(root.data < val) {
            root.right = delete(root.right, val);
        }
        else { // root.data == val { match found }
            // case 1
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);    
        }
        return root;
    }

    // Print in Range numbers present in BST X(start limit) & Y(end limit)
    // 3 cases here : 1) X <= root <= Y => numbers in range are in both left and right subtrees, 2) X > root => numbers are in right subtree, 3) Y < root => numbers are in left subtree
    public void printInRange(Node root, int x, int y) {
        if(root == null) {
            return;
        }
        if (root.data >= x && root.data <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.data+" ");
            printInRange(root.right, x, y);
        }
        else if(root.data >= y) {
            printInRange(root.left, x, y);
        }
        else {
            printInRange(root.right, x, y);
        }
    }

    // Root to leaf Paths
    public void printPath(ArrayList<Integer> path) {
        for (Integer i : path) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public void RootToLeafPaths(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) { // for leaf Nodes
            printPath(path);
        } else { // For non leaf nodes
            RootToLeafPaths(root.left, path);
            RootToLeafPaths(root.right, path);
        }
        path.remove(path.size()-1);
    }

    public void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public class Node {
        public int data;
        public Node left;
        public Node right;

        Node(int data) {
            this.data = data;
        }
    }
}