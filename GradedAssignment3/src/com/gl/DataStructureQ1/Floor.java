package com.gl.DataStructureQ1;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Floor {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the total no of floors in the building");
		int size = scan.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= size; i++) {
			
			System.out.println("Enter the floor size given on day : " + i);
			int floorSize = scan.nextInt();
			queue.add(floorSize);
		}

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		int element = size;
		
		for (int i = 1; i <= size; i++) {
			int head = queue.poll();
			priorityQueue.add(head);
			
			 if (head == element) {
				System.out.println("Day : " + i);
				Iterator<Integer> iterator = priorityQueue.iterator();
				int prev = priorityQueue.peek();
				boolean printFirst = false;
				while (iterator.hasNext()) {
					int max = priorityQueue.peek();
					if (!printFirst) 
					{
						System.out.print(max + " ");
						priorityQueue.poll();
						printFirst = true;
						element--;
					} 
					else
					{
						if (max == prev - 1)
						{
							System.out.print(max + " ");
							prev = priorityQueue.poll();
							element--;
						} else
							break;
					}
				}
				System.out.println();
			} 
			 else
			 {
				System.out.println("Day : " + i);
				System.out.println();
			 }
		}
	}

}