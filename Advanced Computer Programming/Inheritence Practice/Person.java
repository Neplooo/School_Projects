public class Person
{
	private int myAge;

	public Person()
	{
		myAge = 0;
	}

	public void setAge(int age)
	{
		myAge = age;
	}

	public int getAge()
	{
		return myAge;
	}

	public void haveBirthday()
	{
		myAge++;
	}

	public void saySomething()
	{
		System.out.println("I am a person");
	}

}