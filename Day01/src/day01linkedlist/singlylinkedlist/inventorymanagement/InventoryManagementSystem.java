package day01linkedlist.singlylinkedlist.inventorymanagement;

public class InventoryManagementSystem {
    Item head;

    public InventoryManagementSystem() {
        this.head = null;
    }

    public void addItemAtBeginning(String itemName, int itemID, int quantity, double price) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtEnd(String itemName, int itemID, int quantity, double price) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addItemAtPosition(String itemName, int itemID, int quantity, double price, int position) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        if (position == 0) {
            newItem.next = head;
            head = newItem;
            return;
        }
        Item temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeItemByID(int itemID) {
        if (head == null) return;
        if (head.itemID == itemID) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemID != itemID) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void updateItemQuantity(int itemID, int newQuantity) {
        Item item = searchItemByID(itemID);
        if (item != null) {
            item.quantity = newQuantity;
        } else {
            System.out.println("Item not found");
        }
    }

    public Item searchItemByID(int itemID) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Item searchItemByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equals(itemName)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public double calculateTotalInventoryValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        return totalValue;
    }

    public void sortInventoryByName(boolean ascending) {
        if (head == null || head.next == null) return;
        head = mergeSortByName(head, ascending);
    }

    private Item mergeSortByName(Item head, boolean ascending) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextToMiddle = middle.next;
        middle.next = null;
        Item left = mergeSortByName(head, ascending);
        Item right = mergeSortByName(nextToMiddle, ascending);
        return mergeByName(left, right, ascending);
    }

    private Item mergeByName(Item left, Item right, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;
        if ((ascending && left.itemName.compareTo(right.itemName) <= 0) || (!ascending && left.itemName.compareTo(right.itemName) > 0)) {
            left.next = mergeByName(left.next, right, ascending);
            return left;
        } else {
            right.next = mergeByName(left, right.next, ascending);
            return right;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return null;
        Item slow = head;
        Item fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayInventory() {
        if (head == null) {
            System.out.println("No items in inventory");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Item ID: " + temp.itemID + ", Item Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addItemAtBeginning("Item1", 1, 50, 10.5);
        ims.addItemAtEnd("Item2", 2, 30, 20.0);
        ims.addItemAtPosition("Item3", 3, 100, 5.0, 1);

        ims.displayInventory();

        ims.updateItemQuantity(2, 40);
        ims.displayInventory();

        ims.removeItemByID(1);
        ims.displayInventory();

        Item item = ims.searchItemByID(3);
        if (item != null) {
            System.out.println("Found item: " + item.itemName);
        } else {
            System.out.println("Item not found");
        }

        double totalValue = ims.calculateTotalInventoryValue();
        System.out.println("Total Inventory Value: " + totalValue);

        ims.sortInventoryByName(true);
        ims.displayInventory();
    }
}
