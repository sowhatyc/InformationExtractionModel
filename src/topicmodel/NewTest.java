package topicmodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile(".*?(((\\d{4}(-|/))?\\d{1,2}(-|/|:)\\d{1,2})|((����|��|Сʱ|��)ǰ))");
		Matcher isDate = pattern.matcher("11Сʱǰ");
		if(isDate.matches()){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}

}
