package utilities;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class FakerUtility
{
	
	
	
	
	public static String fakerEnterNews(String letter)
	{ 
		 Faker faker=new Faker(); 
		 return faker.letterify(letter);
	}
	public static String fakerEnterName()
	{ 
		 Faker faker=new Faker(); 
		 return faker.name().name();
	}
	public static String fakerPhoneNo()
	{
		Faker faker=new Faker();
		return faker.phoneNumber().cellPhone();
	}
	public static String fakerAddress()
	{
		Faker faker=new Faker();
		return faker.address().fullAddress();
	}
	
	public static String fakerEmailId()
	{
		Faker faker=new Faker();
		return faker.internet().emailAddress();
	}
	public static String fakerEmailIdboth()
	{
		Faker faker=new Faker();
		return faker.bothify("????##@gmail.com");
	}
	public static String fakerUsername()
	{
		Faker faker=new Faker();
		return faker.name().username();
	}
	public static String fakerPassword()
	{
		Faker faker=new Faker();
		return faker.internet().password();
	}
	public static String fakerplace()
	{
		Faker faker=new Faker();
		return faker.nation().capitalCity();
	}
		
}