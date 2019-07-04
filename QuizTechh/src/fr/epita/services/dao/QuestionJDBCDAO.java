/*
 * 
 */
package fr.epita.services.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.Configuration;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestionJDBCDAO.
 */
public class QuestionJDBCDAO {

	/** The Constant INSERT_QUERY. */
	private static final String INSERT_QUERY = "INSERT INTO QUESTIONS (QUESTION,DIFFICULTY,ANS,A,B,C,D) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	/** The Constant UPDATE_QUERY. */
	private static final String UPDATE_QUERY = "UPDATE QUESTIONS SET QUESTION=?,DIFFICULTY=? WHERE QUESTION=?";
	
	/** The Constant DELETE_QUERY. */
	private static final String DELETE_QUERY = "DELETE QUESTIONS WHERE QUESTION=?";
	
	/** The Constant SEARCH_QUERY. */
	private static final String SEARCH_QUERY = "SELECT QUESTION FROM QUESTIONS WHERE QUESTION like ?";
	
	/** The Constant selectQuery. */
	private static final String selectQuery = "select Question from QUESTIONS where difficulty=?";
	
	/** The question. */
	private String question;

	/**
	 * Insert Q.
	 *
	 * @param questionName the question name
	 * @param dfc the dfc
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @param d the d
	 * @param ans the ans
	 */
	public void insertQ(String questionName, int dfc, String a, String b, String c, String d, String ans) {
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(INSERT_QUERY);
			stmt.setString(1, questionName);
			stmt.setInt(2, dfc);
			stmt.setString(3, ans);
			stmt.setString(4, a);
			stmt.setString(5, b);
			stmt.setString(6, c);
			stmt.setString(7, d);

			stmt.execute();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update Q.
	 *
	 * @param questionName the question name
	 * @param newQuestionName the new question name
	 * @param dfc the dfc
	 */
	public void updateQ(String questionName, String newQuestionName, int dfc) {
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(UPDATE_QUERY);
			stmt.setString(1, questionName);
			stmt.setInt(2, dfc);
			stmt.setString(3, newQuestionName);
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete Q.
	 *
	 * @param question the question
	 */
	public void deleteQ(String question) {
		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(DELETE_QUERY);
			stmt.setString(1, question);

			stmt.execute();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Search Q.
	 *
	 * @param question the question
	 */
	public void searchQ(String question) {

		try {
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(SEARCH_QUERY);

			stmt.setString(1, "%" + question + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String SearchedQuestion = rs.getString(1);
				System.out.format("%s  \n", SearchedQuestion);

			}
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gets the topics.
	 *
	 * @return the topics
	 */
	public void getTopics() {

		String sqlQuery = "select * from topic";
		try {
			Connection connection = getConnection();
			PreparedStatement pst = connection.prepareStatement(sqlQuery);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int topicID = rs.getInt(1);
				String topicName = rs.getString(2);

				System.out.format("%s %s \n", topicID, topicName);
			}
			pst.close();
			connection.close();

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Difficultyon Q.
	 *
	 * @param difficulty the difficulty
	 * @throws FileNotFoundException the file not found exception
	 */
	public void difficultyonQ(String difficulty) throws FileNotFoundException {

		
		//PrintWriter writer;

		try {
			Connection connection = getConnection();
			PreparedStatement selectStatement = connection.prepareStatement(selectQuery);

			selectStatement.setString(1, difficulty);

			ResultSet rs = selectStatement.executeQuery();
			while (rs.next()) {
				question = rs.getString(1);
				System.out.println(question);
			}
			selectStatement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private Connection getConnection() throws SQLException,  IOException {
		Configuration config = Configuration.getInstance();
		String url = config.getPropertyValue("jdbc.url");
		String username = config.getPropertyValue("jdbc.username");
		String password = config.getPropertyValue("jdbc.password");

		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * Studnt quiz.
	 *
	 * @param topic the topic
	 * @param diffclty the diffclty
	 * @return the list
	 */
	public List<Answer> studntQuiz(String topic, int diffclty) {
		String stdntQuery = "select Question, difficulty, ans, A, B, C, D from QUESTIONs where difficulty=?";
		List<Answer> ansLst = new ArrayList<Answer>();
		try {
			Connection connection = getConnection();
			PreparedStatement st = connection.prepareStatement(stdntQuery);

			st.setInt(1, diffclty);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String qs = rs.getString(1);
				int diff = rs.getInt(2);
				String ans = rs.getString(3);
				String a = rs.getString(4);
				String b = rs.getString(5);
				String c = rs.getString(6);
				String d = rs.getString(7);

				Answer answer = new Answer(ans, a, b, c, d);
				Question ques = new Question(qs, diff);
				answer.setQues(ques);
				ansLst.add(answer);

			}
			st.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ansLst;

	}

}
