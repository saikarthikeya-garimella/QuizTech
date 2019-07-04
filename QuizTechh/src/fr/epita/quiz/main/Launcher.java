/*
 * 
 */
package fr.epita.quiz.main;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.services.dao.QuestionJDBCDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class Launcher.
 */
public class Launcher {
	
	/** The input. */
	private static Scanner input;
	
	/** The question JDBC dao. */
	static QuestionJDBCDAO questionJDBCDao = new QuestionJDBCDAO();
	
	/** The scanner. */
	private static Scanner scanner;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		init();
	}

	/**
	 * Inits the.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public static void init() throws FileNotFoundException, UnsupportedEncodingException {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter name");
		String name = scanner.nextLine();
		System.out.println("Your name is:" + name);

		System.out.println("Please enter your id");
		String id = scanner.nextLine();
		System.out.println("Your id is:" + id);

		System.out.println("Please Select your choice below");
		System.out.println("1. Add Question");
		System.out.println("2. Update Question");
		System.out.println("3. Delete Question");

		System.out.println("4. Search Question");
		System.out.println("5. Get Questions based on Difficulty");
		System.out.println("6. Get Topics");
		System.out.println("7. Take Quiz Online.");

		String input;
		input = scanner.nextLine();
		System.out.println("You have opted : " + input);

		switch (input) {
		case "1":
			System.out.println("To Insert");
			insertQ();
			break;
		case "2":
			System.out.println("To Update");
			updateQ();
			break;
		case "3":
			System.out.println("To Delete");
			deleteQ();
			break;
		case "4":
			System.out.println("To Search");
			searchQ();
			break;
		case "5":
			System.out.println("To get Questions based on Difficulty");
			difficultyonQ();
			break;
		case "6":
			System.out.println("To Get Topics");
			questionJDBCDao.getTopics();
			break;
		case "7":
			System.out.println("Quiz Online");
			takeQuizOnline();
			break;
		default:
			System.out.println("You have opted an invalid Option");
		}
	}

	/**
	 * Take quiz online.
	 */
	private static void takeQuizOnline() {
		input = new Scanner(System.in);
		System.out.println("Welcome to Student Portal ");
		System.out.print("Please give Topic : ");
		String topic = input.next();
		System.out.println("Enter Difficulty");
		int diffclty = input.nextInt();

		List<Answer> ansList = questionJDBCDao.studntQuiz(topic, diffclty);
		int score = 0;
		for (int i = 0; i < ansList.size(); i++) {
			System.out.println(ansList.get(i).getQues().getQuestion());
			System.out.println("A : " + ansList.get(i).getA());
			System.out.println("B : " + ansList.get(i).getB());
			System.out.println("C : " + ansList.get(i).getC());
			System.out.println("D : " + ansList.get(i).getD());
			
			System.out.println("Please Enter your Answer ::::: ");
			String chc = input.next();
			System.out.println("chc::"+chc);
			if (chc.equalsIgnoreCase(ansList.get(i).getText())) {
				score++;
			} else {
				System.out.println("Wassup");
			}

		}

		System.out.println("Congratulations, Quiz has been ended, and your total Score is :::" + score);

	}

	/**
	 * Insert Q.
	 */
	public static void insertQ() {
		input = new Scanner(System.in);
		System.out.print("Enter Question: ");
		String questn = input.nextLine();
		System.out.println("Enter Topic: ");
		String topic = input.nextLine();
		System.out.println("Enter Difficulty");
		String diffclty = input.nextLine();
		System.out.print("Enter A: ");
		String a = input.nextLine();
		System.out.print("Enter B: ");
		String b = input.nextLine();
		System.out.print("Enter C: ");
		String c = input.nextLine();
		System.out.print("Enter D: ");
		String d = input.nextLine();
		System.out.print("Enter Actual Answer: ");
		String ans = input.nextLine();

		questionJDBCDao.insertQ(questn, Integer.parseInt(diffclty), a, b, c, d, ans);

		System.out.println("Question has been created.");
	}

	/**
	 * Update Q.
	 */
	public static void updateQ() {

		input = new Scanner(System.in);

		System.out.print("Enter Question to Update: ");
		String questn = input.nextLine();

		System.out.println("Enter new Difficulty");
		int diffclty = input.nextInt();

		System.out.print("Enter  New Question ");
		String newQuestn = input.nextLine();

		System.out.println("Enter New topic");
		@SuppressWarnings("unused")
		String topicName = input.nextLine();

		questionJDBCDao.updateQ(questn, newQuestn, diffclty);
		System.out.println("Question has been updated.");
	}

	/**
	 * Delete Q.
	 */
	public static void deleteQ() {
		input = new Scanner(System.in);

		System.out.print("Enter Question to Delete: ");
		String questn = input.next();
		questionJDBCDao.deleteQ(questn);
		System.out.println("Question has been deleted.");

	}

	/**
	 * Search Q.
	 */
	public static void searchQ() {

		input = new Scanner(System.in);

		System.out.print("Enter Question to Search: ");
		String questn = input.next();

		questionJDBCDao.searchQ(questn);
		System.out.println("Search Completed.");

	}

	/**
	 * Difficultyon Q.
	 *
	 * @throws FileNotFoundException the file not found exception
	 * @throws UnsupportedEncodingException the unsupported encoding exception
	 */
	public static void difficultyonQ() throws FileNotFoundException, UnsupportedEncodingException {
		scanner = new Scanner(System.in);
		System.out.println("Please select Difficulty level");
		System.out.println("1.Easy");
		System.out.println("2.Medium");
		System.out.println("3.Hard");

		String diff;

		diff = scanner.nextLine();

		System.out.println("the difficulty you have selected is:" + diff);
		questionJDBCDao.difficultyonQ(diff);

	}

}
