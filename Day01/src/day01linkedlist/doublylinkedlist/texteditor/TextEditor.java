package day01linkedlist.doublylinkedlist.texteditor;

public class TextEditor {
    private TextState currentState;  // Pointer to the current text state
    private final int maxHistorySize;  // Max history size
    private int historySize;  // Tracks the number of states stored

    public TextEditor(int maxHistorySize) {
        this.currentState = new TextState("");  // Initial empty text state
        this.maxHistorySize = maxHistorySize;
        this.historySize = 1;  // Start with one history (initial empty state)
    }

    // Add a new text state to the history
    public void addTextState(String text) {
        // Remove redo history if there are any (as new action was performed)
        if (currentState.next != null) {
            currentState.next = null;
        }

        TextState newState = new TextState(text);  // Create a new state with the given text
        currentState.next = newState;  // Link the current state to the new state
        newState.prev = currentState;  // Link the new state back to the current state
        currentState = newState;  // Move the currentState pointer to the new state

        // Limit history size to the maximum allowed
        if (historySize < maxHistorySize) {
            historySize++;
        } else {
            removeOldestState();  // Remove the oldest state if the history exceeds max size
        }
    }

    // Remove the oldest state from history (keep the history size within limit)
    private void removeOldestState() {
        if (currentState.prev != null) {
            currentState = currentState.prev;  // Move the pointer to the previous state
            currentState.next = null;  // Remove the link to the next state (oldest state removed)
        }
    }

    // Undo operation: Revert to the previous state in the history
    public void undo() {
        if (currentState.prev != null) {
            currentState = currentState.prev;  // Move to the previous state (undo)
            System.out.println("Undo performed: " + currentState.textContent);
        } else {
            System.out.println("No more states to undo.");
        }
    }

    // Redo operation: Revert to the next state in the history
    public void redo() {
        if (currentState.next != null) {
            currentState = currentState.next;  // Move to the next state (redo)
            System.out.println("Redo performed: " + currentState.textContent);
        } else {
            System.out.println("No more states to redo.");
        }
    }

    // Display the current text in the editor
    public void displayCurrentState() {
        System.out.println("Current Text: " + currentState.textContent);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor(5); // Set max history size to 5

        // Add some text states
        editor.addTextState("Hello");
        editor.addTextState("Hello, World!");
        editor.addTextState("Hello, World! How are you?");
        editor.addTextState("Hello, World! How are you? I'm fine.");
        editor.addTextState("Hello, World! How are you? I'm fine. How about you?");

        editor.displayCurrentState();  // Current Text: Hello, World! How are you? I'm fine. How about you?

        // Perform undo actions
        editor.undo();  // Current Text: Hello, World! How are you? I'm fine.
        editor.undo();  // Current Text: Hello, World! How are you?

        // Perform redo actions
        editor.redo();  // Current Text: Hello, World! How are you? I'm fine.
        editor.redo();  // Current Text: Hello, World! How are you? I'm fine. How about you?

        // Add new text and exceed history size limit
        editor.addTextState("New text state beyond history limit");

        // Display final state
        editor.displayCurrentState();  // Current Text: New text state beyond history limit

        // Perform undo actions
        editor.undo();  // Current Text: Hello, World! How are you? I'm fine. How about you?
        editor.undo();  // Current Text: Hello, World! How are you?
        editor.undo();  // Current Text: Hello, World! How are you?
        editor.undo();  // Current Text: Hello, World! How are you?
        editor.undo();  // Current Text: Hello
        editor.undo();  // No more states to undo.
    }
}
