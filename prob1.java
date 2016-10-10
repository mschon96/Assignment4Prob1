/*
Name : Mariah Schon
Class : 3320-001
Program # : Assignment 4
Due Date : Oct 6
Honor Pledge: On my honor as a student of the University
of Nebraska at Omaha, I have neither given nor received
unauthorized help on this homework assignment.
NAME: Mariah Schon
NUID: 581
EMAIL: mschon@unomaha.edu
PARTNERS: CSLC
Description: AVL Tree
*/
import java.util.Scanner;

public class prob1{

    public static void main (String[] args){
        int choice = 0;

        MyAVLTree tree = new MyAVLTree();
        //        MyQueue q = new MyQueue();

        Scanner input = new Scanner(System.in);

        while( choice !=4){
            System.out.println("Enter your choice for menu below: ");
            System.out.println("1. Insert node");
            System.out.println("2. Print tree");
            System.out.println("3. Print the level order traversal of the tree");
            System.out.println("4. Exit program:");
//            System.out.println("5. Print size of tree");
          
            choice = input.nextInt();
          
            switch(choice){  
                case 1:
                    System.out.printf("Insert Node:");
                    int insNode = input.nextInt();
                    tree.insert(insNode);
                    //System.out.println("Insert");
    
                    break;
                case 2: 
                    tree.printTree();
                    System.out.println("");
                    break;
                case 3:
                      // System.out.println("Print level order");
                    tree.levelOrder();
                    System.out.println(" ");
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                //case 5:
                  //  System.out.printf("%d\n", tree.size());
            }
        }

    }
}

