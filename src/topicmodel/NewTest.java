package topicmodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("(?is).*?(\\d{4}(-|/))?\\d{1,2}(-|/|:)\\d{1,2}[^\\d]*?");
		Matcher isDate = pattern.matcher("《[转帖] 美丽的“自由民主”为何总是导致内战与内乱？》\n作者：南方周末读者\n发表于：3/3232\n最后发帖：&nbs…...");
		if(isDate.matches()){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
//		String str = "4/&nbsp";
//		str = str.replaceAll("&nbsp", "");
//		System.out.println(str);
	}

}
