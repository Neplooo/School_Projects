public class Student extends Person
{
	private int myGrade;

	public Student()
	{
		myGrade = 9;
	}

	public void setGrade(int grade)
	{
		myGrade = grade;
	}

	public int getGrade()
	{
		return myGrade;
	}
	
	public void passExams()
	{
		myGrade++;
	}

	public void saySomething()
	{
		System.out.println("I am a student");
	}

}
