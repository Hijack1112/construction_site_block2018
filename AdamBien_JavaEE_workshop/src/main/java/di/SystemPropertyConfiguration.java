package di;

public class SystemPropertyConfiguration implements Configuration{

	public String getConfig(String key) {
		return System.getProperty(key);
	}
	
}
