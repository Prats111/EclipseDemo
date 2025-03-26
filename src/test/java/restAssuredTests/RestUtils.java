package restAssuredTests;
import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String getName() {
		return "john" + RandomStringUtils.randomAlphabetic(1);
	}
	public static String getJob() {
		return "qa" + RandomStringUtils.randomAlphabetic(1);
	}
	
}
