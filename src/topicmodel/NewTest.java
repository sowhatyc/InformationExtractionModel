package topicmodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("(?is).*?(\\d{4}(-|/))?\\d{1,2}(-|/|:)\\d{1,2}[^\\d]*?");
		Matcher isDate = pattern.matcher("��[ת��] �����ġ�����������Ϊ�����ǵ�����ս�����ң���\n���ߣ��Ϸ���ĩ����\n�����ڣ�3/3232\n�������&nbs��...");
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
