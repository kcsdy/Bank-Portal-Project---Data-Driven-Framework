package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// System.out.println(System.getProperty("user.dir"));
		Properties config = new Properties();

		Properties ObjectReference = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);

		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\ObjectReference.properties");
		ObjectReference.load(fis);

		System.out.println(config.getProperty("browser"));
		System.out.println(config.getProperty("testUrl"));

		System.out.println(ObjectReference.getProperty("bmlBtn"));

	}

}
