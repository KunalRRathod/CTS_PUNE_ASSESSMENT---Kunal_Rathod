package com.cognizant.Assessment;

import java.util.ArrayList;
import java.util.List;
public class Q4_Part_1 {
	
	
	ArrayList<Q4_Student> students = null;

	{
		students = new ArrayList<>();
		Q4_Student std1 = new Q4_Student(1, "Kunal", 50, 60, 70);
		students.add(std1);
		Q4_Student std2 = new Q4_Student(2, "Neha", 50, 60, 70);
		students.add(std2);
		Q4_Student std3 = new Q4_Student(3, "Sanket", 50, 60, 70);
		students.add(std3);
			
	}
	public void addStudent(Q4_Student q4_Student){
		students.add(q4_Student);
	}
	public List<Q4_Student> getAllStudent() {
		return students;
	}
	


	
	
	
	}


