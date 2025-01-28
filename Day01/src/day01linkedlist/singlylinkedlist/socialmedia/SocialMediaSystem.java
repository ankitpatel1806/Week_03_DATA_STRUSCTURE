package day01linkedlist.singlylinkedlist.socialmedia;

public class SocialMediaSystem {
    User head;

    public SocialMediaSystem() {
        this.head = null;
    }

    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        newUser.next = head;
        head = newUser;
    }

    public User searchUserByID(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public User searchUserByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addFriendConnection(int userID1, int userID2) {
        User user1 = searchUserByID(userID1);
        User user2 = searchUserByID(userID2);

        if (user1 != null && user2 != null) {
            if (!user1.friends.isFriend(userID2)) {
                user1.friends.addFriend(userID2);
            }
            if (!user2.friends.isFriend(userID1)) {
                user2.friends.addFriend(userID1);
            }
        } else {
            System.out.println("User(s) not found.");
        }
    }

    public void removeFriendConnection(int userID1, int userID2) {
        User user1 = searchUserByID(userID1);
        User user2 = searchUserByID(userID2);

        if (user1 != null && user2 != null) {
            user1.friends.removeFriend(userID2);
            user2.friends.removeFriend(userID1);
        } else {
            System.out.println("User(s) not found.");
        }
    }

    public void displayAllFriends(int userID) {
        User user = searchUserByID(userID);
        if (user != null) {
            System.out.print("Friends of " + user.name + ": ");
            user.friends.displayFriends();
        } else {
            System.out.println("User not found.");
        }
    }

    public void findMutualFriends(int userID1, int userID2) {
        User user1 = searchUserByID(userID1);
        User user2 = searchUserByID(userID2);

        if (user1 != null && user2 != null) {
            System.out.print("Mutual Friends between " + user1.name + " and " + user2.name + ": ");
            user1.friends.findMutualFriends(user2.friends);
        } else {
            System.out.println("User(s) not found.");
        }
    }

    public void displayUserInfo(int userID) {
        User user = searchUserByID(userID);
        if (user != null) {
            System.out.println("User ID: " + user.userID + ", Name: " + user.name + ", Age: " + user.age);
            System.out.print("Friends: ");
            user.friends.displayFriends();
        } else {
            System.out.println("User not found.");
        }
    }

    public void countFriends(int userID) {
        User user = searchUserByID(userID);
        if (user != null) {
            System.out.println("Number of friends of " + user.name + ": " + user.friends.countFriends());
        } else {
            System.out.println("User not found.");
        }
    }

    public static void main(String[] args) {
        SocialMediaSystem sms = new SocialMediaSystem();

        sms.addUser(1, "Ankit patel", 25);
        sms.addUser(2, "Anand Soni", 30);
        sms.addUser(3, "Ankit patel", 28);

        sms.addFriendConnection(1, 2);
        sms.addFriendConnection(2, 3);

        sms.displayAllFriends(1);
        sms.displayAllFriends(2);

        sms.findMutualFriends(1, 2);
        sms.findMutualFriends(1, 3);

        sms.removeFriendConnection(1, 2);
        sms.displayAllFriends(1);
        sms.displayAllFriends(2);

        sms.countFriends(1);
        sms.countFriends(2);

        sms.displayUserInfo(3);
    }
}
