package utility;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker faker=new Faker();
	
	public String randomUsername()
	{
			return faker.name().username();
		
	}
	public String randomPassword()
	{
		return faker.internet().password();
	}
	public String randomFullName()
	{
		return faker.name().fullName();
	}
	public String randomEmail()
	{
		return faker.internet().emailAddress();
	}
	public String randomMobileNumber()
	{
		return faker.phoneNumber().cellPhone();

}
}
