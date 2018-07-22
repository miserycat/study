package gc;


import java.math.BigInteger;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list. You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 *
 * Example: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 */
class Solution {

  public static void main(String[] args) {
    ListNode node1 = new ListNode(2);
    node1.next = new ListNode(4);
    node1.next.next = new ListNode(3);

    ListNode node2 = new ListNode(5);
    node2.next = new ListNode(6);
    node2.next.next = new ListNode(4);

    System.out.println(node1);
    System.out.println(node2);

    Solution solution = new Solution();
    ListNode mergedNode = solution.addTwoNumbers(node1, node2);
    System.out.println(mergedNode);
  }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();

    ListNode node1 = l1;
    ListNode node2 = l2;

    padding(sb1, node1);
    padding(sb2, node2);
    String mergeStr = new BigInteger(sb1.reverse().toString())
        .add(new BigInteger(sb2.reverse().toString())).toString();
    ListNode mergedNode = new ListNode(
        Integer.parseInt(mergeStr.charAt(mergeStr.length() - 1) + ""));
    mergeNode(mergeStr, mergedNode);
    return mergedNode;
  }

  private void padding(StringBuilder sb, ListNode node) {
    sb.append(node.val + "");
    if (node.next != null) {
      padding(sb, node.next);
    }
  }

  private void mergeNode(String str, ListNode node) {
    if (str.length() == 1) {
      node.next = null;
    } else {
      str = str.substring(0, str.length() - 1);
      node.next = new ListNode(Integer.parseInt(str.charAt(str.length() - 1) + ""));
      mergeNode(str, node.next);
    }
  }

}

