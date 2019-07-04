/*
 * 
 */
package fr.epita.quiz.datamodel;

// TODO: Auto-generated Javadoc
/**
 * The Class Topics.
 */
public class Topics {

	/** The topic ID. */
	private int topicID;
	
	/** The topic name. */
	private String topicName;
	
	/**
	 * Gets the topic ID.
	 *
	 * @return the topic ID
	 */
	public int getTopicID() {
		return topicID;
	}
	
	/**
	 * Sets the topic ID.
	 *
	 * @param topicID the new topic ID
	 */
	public void setTopicID(int topicID) {
		this.topicID = topicID;
	}
	
	/**
	 * Gets the topic name.
	 *
	 * @return the topic name
	 */
	public String getTopicName() {
		return topicName;
	}
	
	/**
	 * Sets the topic name.
	 *
	 * @param topicName the new topic name
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	/**
	 * Instantiates a new topics.
	 *
	 * @param topicID the topic ID
	 * @param topicName the topic name
	 */
	public Topics(int topicID, String topicName) {
		super();
		this.topicID = topicID;
		this.topicName = topicName;
	}
	
	
}
