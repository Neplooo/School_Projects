public class APStudent extends Student implements Comparable
{
	private int myAPExamScore;

	public APStudent()
	{
		myAPExamScore = 3;
	}

	public void setAPExamScore(int apExamScore)
	{
		myAPExamScore = apExamScore;
	}

	public int getAPExamScore()
	{
		return myAPExamScore;
	}

	public void studyForExam()
	{
		if (myAPExamScore < 5)
		{
			myAPExamScore++;
		}
	}

	public void saySomething()
	{
		System.out.println("I am an AP student");
	}

	public int compareTo(Object other)
	{
		return getAPExamScore() - ((APStudent) other).getAPExamScore();
	}

	public String toString()
	{
		return "myAPExamScore = " + myAPExamScore;
	}

	public boolean equals(Object other)
	{

		if (myAPExamScore == ((APStudent) other).myAPExamScore)
		{
			return true;
		}

		return false;
	}

}