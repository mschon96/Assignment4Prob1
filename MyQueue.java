/*
Name : Mariah Schon
Class : 3320-001
Assignment 3
Due Date : September 22, 2016
Honor Pledge: On my honor as a student of the University
of Nebraska at Omaha, I have neither given nor received
unauthorized help on this homework assignment.

NAME: Mariah Schon
NUID: 581
EMAIL: mschon@unomaha.edu
Partners: CSLC
*/

public class MyQueue{

private MyLinkedList queue;
    int count;

    public MyQueue(){
        queue = new MyLinkedList();
    }

    public void enque(AVLNode node){
        queue.add(0, node);
        count ++;
    }

    public AVLNode deque(){
        AVLNode node = queue.remove(queue.size() -1);
        count --;

        return node;
    }

    public boolean isEmpty(){
        if (count == 0)
            return true;
        else
            return false;
    }

    public int getSize(){
        int qSize= queue.size();
        return qSize;
    }

}
~      
