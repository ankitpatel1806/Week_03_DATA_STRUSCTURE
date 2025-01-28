package day01linkedlist.singlylinkedlist.socialmedia;

public class FriendList {
    Friend head;

    public FriendList() {
        this.head = null;
    }

    public void addFriend(int friendID) {
        Friend newFriend = new Friend(friendID);
        newFriend.next = head;
        head = newFriend;
    }

    public void removeFriend(int friendID) {
        if (head == null) return;
        if (head.friendID == friendID) {
            head = head.next;
            return;
        }
        Friend temp = head;
        while (temp.next != null && temp.next.friendID != friendID) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public boolean isFriend(int friendID) {
        Friend temp = head;
        while (temp != null) {
            if (temp.friendID == friendID) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void displayFriends() {
        if (head == null) {
            System.out.println("No friends found.");
            return;
        }
        Friend temp = head;
        while (temp != null) {
            System.out.print(temp.friendID + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void findMutualFriends(FriendList otherList) {
        Friend temp1 = head;
        while (temp1 != null) {
            Friend temp2 = otherList.head;
            while (temp2 != null) {
                if (temp1.friendID == temp2.friendID) {
                    System.out.print(temp1.friendID + " ");
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        System.out.println();
    }

    public int countFriends() {
        int count = 0;
        Friend temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
