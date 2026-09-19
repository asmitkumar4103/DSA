class Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse
        ListNode prev = null;

        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // Compare
        while (prev != null) {
            if (head.val != prev.val)
                return false;

            head = head.next;
            prev = prev.next;
        }

        return true;
    }
}