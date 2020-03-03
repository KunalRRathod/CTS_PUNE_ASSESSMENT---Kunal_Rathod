package com.cognizant.Assessment;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class Q3_StudentPredicate {
	// condition check

		public static Predicate<Q3_Student> isMarksAboveEqual80() {
			return student -> student.getMarks() >= 80;
		}
		// apply methods
		public static Predicate<Q3_Student> isMarksFirstClass() {
			
			return student -> student.getMarks() >= 60 && student.getMarks() <=79;
		}
			public static Predicate<Q3_Student> isMarksFail() {
			
			return student -> student.getMarks() < 50;
		
}
			public static List<Q3_Student> filterStudent(List<Q3_Student> q3_Students, Predicate<Q3_Student> predicate) {
					return q3_Students.stream().filter(predicate).collect(Collectors.toList());
}
			public static void main(String[] args) {
				// Create ArrayList
				
				List<Q3_Student> q3_Students = Arrays.asList( new Q3_Student("Kunal", 80),
						new Q3_Student("Ram", 50),
						new Q3_Student("Akshat", 90), 
						new Q3_Student("Gargi", 60), 
						new Q3_Student("Nimisha", 30),
						new Q3_Student("Sonu", 40));
				
				System.out.println("Distinction : ");
				
				// access methods
				Q3_StudentPredicate.filterStudent(q3_Students,
						Q3_StudentPredicate.isMarksAboveEqual80()).forEach(System.out::println);
					System.out.println("First Class: ");
					
				Q3_StudentPredicate.filterStudent(q3_Students,
						Q3_StudentPredicate.isMarksFirstClass()).forEach(System.out::println);
					System.out.println("Fail: ");
					
				Q3_StudentPredicate.filterStudent(q3_Students, 
						Q3_StudentPredicate.isMarksFail()).forEach(System.out::println);

				}

}
