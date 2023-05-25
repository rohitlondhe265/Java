package Trees;

import java.util.ArrayList;

import Trees.CBST.Node;

// import Trees.CBT.Node;

public class test {
    public static void main(String[] args) {
        // int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // CBT tree = new CBT();
        // Node root = tree.buildTree(arr);
        // tree.preorder(root);
        // tree.inorder(root);
        // tree.postorder(root);
        // tree.levelorder(root);
        // System.out.println(tree.countNodes(root));
        // System.out.println(tree.sumOfNodes(root));
        // System.out.println(tree.height(root));
        // System.out.println(tree.diameter(root).diameter);

        // CBT subTree = new CBT();
        // int[] arr2 = {1, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // Node subRoot = subTree.buildTree(arr2);
        // System.out.println(tree.isSubtree(root, subRoot));

        int[] arr = {5,1,3,4,2,7};
        CBST bst = new CBST();

        Node root = bst.insert(arr);
        // bst.inorder(root);
        // System.out.println(bst.includes(root, 11));
        // bst.delete(root, 4);
        // bst.inorder(root);
        // bst.printInRange(root, 5, 12);
        bst.RootToLeafPaths(root, new ArrayList<>());
    }
}
