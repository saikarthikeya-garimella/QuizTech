/*
 * 
 */
package fr.epita.quiz.datamodel;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class Question.
 */
public class Question {


	/** The id. */
	private int id;

	/** The question. */
	private String question;

	/** The topics. */
	private String[] topics;

	/** The difficulty. */
	private int difficulty;

	/**
	 * Instantiates a new question.
	 */
	public Question() {
		super();
	}

	/**
	 * Instantiates a new question.
	 *
	 * @param question the question
	 */
	public Question(String question) {
		super();
		this.question = question;
	}
	
	/**
	 * Instantiates a new question.
	 *
	 * @param question the question
	 * @param difficulty the difficulty
	 */
	public Question(String question, int difficulty) {
		this.question = question;
		this.difficulty = difficulty;
	}


	/**
	 * Gets the question.
	 *
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 *
	 * @param question the new question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Gets the topics.
	 *
	 * @return the topics
	 */
	public String[] getTopics() {
		return topics;
	}

	/**
	 * Sets the topics.
	 *
	 * @param topics the new topics
	 */
	public void setTopics(String[] topics) {
		this.topics = topics;
	}

	/**
	 * Gets the difficulty.
	 *
	 * @return the difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * Sets the difficulty.
	 *
	 * @param difficulty the new difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", topics=" + Arrays.toString(topics) + ", difficulty="
				+ difficulty + "]";
	}

}
