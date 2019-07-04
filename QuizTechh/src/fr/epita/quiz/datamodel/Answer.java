/*
 * 
 */
package fr.epita.quiz.datamodel;

// TODO: Auto-generated Javadoc
/**
 * The Class Answer.
 */
public class Answer {

	/** The text. */
	private String text;
	
	/** The a. */
	private String a;
	
	/** The b. */
	private String b;
	
	/** The c. */
	private String c;
	
	/** The d. */
	private String d;
	
	/** The ques. */
	private Question ques;
	
	/**
	 * Instantiates a new answer.
	 *
	 * @param text the text
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @param d the d
	 */
	public Answer(String text, String a, String b, String c, String d) {
		this.text = text;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	

	

	/**
	 * Gets the ques.
	 *
	 * @return the ques
	 */
	public Question getQues() {
		return ques;
	}

	/**
	 * Sets the ques.
	 *
	 * @param ques the new ques
	 */
	public void setQues(Question ques) {
		this.ques = ques;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the a.
	 *
	 * @return the a
	 */
	public String getA() {
		return a;
	}

	/**
	 * Sets the a.
	 *
	 * @param a the new a
	 */
	public void setA(String a) {
		this.a = a;
	}

	/**
	 * Gets the b.
	 *
	 * @return the b
	 */
	public String getB() {
		return b;
	}

	/**
	 * Sets the b.
	 *
	 * @param b the new b
	 */
	public void setB(String b) {
		this.b = b;
	}

	/**
	 * Gets the c.
	 *
	 * @return the c
	 */
	public String getC() {
		return c;
	}

	/**
	 * Sets the c.
	 *
	 * @param c the new c
	 */
	public void setC(String c) {
		this.c = c;
	}

	/**
	 * Gets the d.
	 *
	 * @return the d
	 */
	public String getD() {
		return d;
	}

	/**
	 * Sets the d.
	 *
	 * @param d the new d
	 */
	public void setD(String d) {
		this.d = d;
	}

	/**
	 * Instantiates a new answer.
	 *
	 * @param text the text
	 */
	public Answer(String text) {
		super();
		this.text = text;
	}
	
	
}
