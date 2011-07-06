import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

	public static void main(String[] args) {
//		String width = "-200px";
//		String regexPattern = "^((\\-?)(\\d*(\\.)?\\d*))((%)?|(px)?)$";
//        Matcher matcher = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE).matcher(width);
//        boolean negative = false, fractional = false, asPercentage = false, asPixels = false;
//        double number;
//        if (matcher.find()) {
//        	System.out.println("here");
//        	if(matcher.group(2).equals("-")) {
//        		System.out.println("hey negetive "+matcher.group(1));
//        		negative = true;
//        	}
//        	number = Double.parseDouble(matcher.group(1));
//        	System.out.println("NUMBER IS "+number);
//        	if(matcher.group(3)!=null) {
//        		System.out.println("hey fractional "+matcher.group(1));
//        		fractional = true;
//        	}
//        	if(matcher.group(4)!=null) {
//        		if(matcher.group(5)!=null)
//        			asPercentage = true;
//        		else
//        			asPixels = true;
//        		System.out.println("hey px "+asPixels);
//        		System.out.println("hey per "+asPercentage);
//        	} else if(!fractional)
//        		asPixels = true;
//        	if(fractional && !(number>1||number<-1))
//        		throw new IllegalArgumentException(width + " is not a valid width. fractional values can't be more than 1.0 which is 100%");
//        } else
//        	throw new IllegalArgumentException(width + " is not a valid width. Valid values are like 80, -80, 80px, -80px, 1.0, .2, 20% etc.");
		System.out.println(Pattern.compile("<img.*?</img>").matcher("hello <img fdsa >fds</img>fd").replaceAll(""));
	}

}
