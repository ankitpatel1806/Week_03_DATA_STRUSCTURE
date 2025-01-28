package day01linkedlist.circularlinkedlist.roundrobin;

public class Process {
    int processId;
    int burstTime;
    int remainingBurstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingBurstTime = burstTime; // Initially, remaining time equals burst time
        this.priority = priority;
        this.next = null;
    }
}
