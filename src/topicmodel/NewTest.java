package topicmodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile(".*?(((\\d{4}(-|/))?\\d{1,2}(-|/|:)\\d{1,2})|((分钟|秒|小时|天)前))");
		Matcher isDate = pattern.matcher("11小时前");
		if(isDate.matches()){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}

}
