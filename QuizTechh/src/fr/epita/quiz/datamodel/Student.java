/*
 * 
 */
package fr.epita.quiz.datamodel;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 */
public class Student {

	/** The id. */
	private String name,id;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Instantiates a new student.
	 *
	 * @param name the name
	 * @param id the id
	 */
	public Student(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	
}
