package day01linkedlist.singlylinkedlist.socialmedia;

public class User {
    int userID;
    String name;
    int age;
    FriendList friends;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friends = new FriendList();
        this.next = null;
    }
}
