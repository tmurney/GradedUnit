import java.util.*;


public class SavingsGoal {
	
	private String goalName;
	private float goalAmount;
	private Date goalDeadline;
	
	public String getGoalName() {
		return goalName;
	}
	public void setGoalName(String goalName) throws InputValidationException {
		this.goalName = goalName;
	}
	
	public float getGoalAmount() {
		return goalAmount;
	}
	public void setGoalAmount(float goalAmount) throws InputValidationException{
		this.goalAmount = goalAmount;
	}
	
	public Date getGoalDeadline() {
		return goalDeadline;
	}
	public void setGoalDeadline(Date goalDeadline) throws InputValidationException{
		this.goalDeadline = goalDeadline;
	}
	
}
