package topicmodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Utils.StaticLib;

public class NewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Pattern pattern = Pattern.compile(".*?((\\d{4}(-|/)\\d{1,2}(-|/)\\d{1,2}(\\s|,)\\d{1,2}:\\d{1,2})|(\\d{1,2}\\s*ÔÂ\\s*\\d{1,2})).*?");
//		Matcher matcher = pattern.matcher("lala2013-4-3 16:04:06 3ÔÂ25ÈÕ");
//		while(matcher.find()){
//			System.out.println(matcher.group(1) + " " + matcher.group(2));
//		}
//		int i=0;
//		while(matcher.find()){
//			System.out.println("yes");
//			System.out.println(++i);
//		}
//		String str = "4/&nbsp";
//		str = str.replaceAll("&nbsp", "");
//		System.out.println(str);
//		StaticLib.changeFile("train_content_7.txt", "train_content_8.txt");
//		StaticLib.convertCRFPPFileToGRMMFile("test_content_8.txt", "template_content_7.txt", 1, "test_content_cpy8.txt");
		StaticLib.convertCRFPPFileToGRMMFile("train_content_8.txt", "template_content_7.txt", 1, "train_content_cpy8.txt");
	}

}
