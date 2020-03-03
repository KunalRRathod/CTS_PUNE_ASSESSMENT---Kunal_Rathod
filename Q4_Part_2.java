package com.cognizant.Assessment;
// importing all the packages
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.text.AbstractDocument.BranchElement;
import java.io.*;


public class Q4_Part_2 {
	// initialise Arraylist
	public static void highestScorer(ArrayList<String> list, int n) {
		int[] arr = new int[n];
		String[] arrOfStr;	
		// iterate over values
		for (int j = 0; j < list.size(); j++) {
			int sum = 0;	
			arrOfStr = list.get(j).split("-");
			for (int i = 1; i < 4; i++) {
				sum = sum + Integer.parseInt((String) Array.get(arrOfStr, i));
			}
			arr[j] = sum;
			System.out.println("Total marks of student " + (j + 1) + " is: " + sum);
		}
		int max = arr[0];
		for (int k = 0; k < n; k++) {
			if (arr[k] > max) {
				max = arr[k];	
				}
		}
		
		// print max marks 
		System.out.println("Student Having maximum marks: " + max);
	}
				public static void main(String[] args) throws NumberFormatException, IOException {
					ArrayList<String> list = new ArrayList<>();
					
					BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
					System.out.println("Enter no of Records ie value of n:");
					int n = Integer.parseInt(bin.readLine());		
					
					for (int i = 0; i < n; i++) {
						list.add(bin.readLine());		
						}
					System.out.println("ArrayList contains: " + list);
					highestScorer(list, n);	
					}
}
