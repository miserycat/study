package gc;

public class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    return "ListNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
  }


  public static void main(String[] args) {
    ListNode head = createNode(false);

//    printLinedNodes(head);

//    ListNode node = reverseLinkedNodes1(head);
//
//    printLinedNodes(node);


    ListNode circleNode = ListNode.createNode(true);

    System.out.println(checkCircleNodes(circleNode));


  }

  private static ListNode createNode(boolean circle) {
    ListNode head = new ListNode(5);
    ListNode node2 = new ListNode(4);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(2);
    ListNode node5 = new ListNode(1);
    head.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    if (circle) {
      node5.next = head;
    }

    return head;
  }


  private static ListNode reverseLinkedNodes1(ListNode node) {
    if (node == null || node.next == null) {
      return node;
    }

    ListNode newHead = reverseLinkedNodes1(node.next);

    node.next.next = node;
    node.next = null;

    return newHead;
  }


  private static ListNode reverseLinkedNodes2(ListNode node) {
    if (node == null || node.next == null) {
      return node;
    }

    ListNode newHead = null;
    ListNode currentNode = node;
    while (currentNode != null) {
      ListNode nextNode = currentNode.next;
      currentNode.next = newHead;
      newHead = currentNode;
      currentNode = nextNode;
    }

    return newHead;
  }

  private static boolean checkCircleNodes(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    ListNode slowNode = head;
    ListNode fastNode = head.next;

    while (fastNode != null && fastNode.next != null) {
      if (slowNode == fastNode) {
        return true;
      }
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
    }

    return false;
  }


  private static void printLinedNodes(ListNode node) {
    while (node != null) {
      System.out.println(node.val);
      node = node.next;
    }
  }
}