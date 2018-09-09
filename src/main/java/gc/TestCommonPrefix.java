package gc;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shengchao wu on 7/26/2018.
 */
public class TestCommonPrefix {
    public static void main(String[] args) {
//        String[] array = {"flower","flow","flight"};
//        Stream.of(array).sorted((s1, s2) -> s1.length() - s2.length()).forEach(System.out::println);
//        System.out.println(primeNums(100));
//        System.out.println(longestCommonPrefix(array));


        /**
         *      1
         *   100   2
         * 3
         */
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(100);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        root.left = left1;
        root.right = right1;
        root.right.left = left2;
        preorderTraversal(root).forEach(System.out::println);

    }

    public static String longestCommonPrefix(String[] array) {
        if (array.length <= 1) {
            return "";
        }
        List<String> sortedStrs = Stream.of(array).sorted((s1, s2) -> s1.length() - s2.length()).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sortedStrs.get(0).length(); i++) {
            for (int j = 1 ; j < sortedStrs.size(); j++) {
                if (sortedStrs.get(j).indexOf(sb.toString() + sortedStrs.get(0).charAt(i)) != 0) {
                    return sb.toString();
                }
            }
            sb.append(sortedStrs.get(0).charAt(i));
        }

        return sb.toString();
    }


    private static List<Integer> primeNums(int limit) {
        List<Integer> result = new ArrayList<>(Arrays.asList(1,2));
        if (limit == 1) {
            result.remove(1);
            return result;
        }

        if (limit == 2) {
            return result;
        }

        out:for (int i = 3; i < limit; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue out;
                }
            }
            result.add(i);
        }

        return result;

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveNode(root, result);
        return result;
    }


    private static void recursiveNode(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        recursiveNode(node.left, result);
        recursiveNode(node.right, result);
    }

}

class TreeNode {
    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
