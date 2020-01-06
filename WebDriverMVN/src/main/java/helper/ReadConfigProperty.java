package helper;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperty {
	
	protected InputStream input = null;
	protected Properties prop = null; 
	public ReadConfigProperty()  {
		try {
			input = ReadConfigProperty.class.getClassLoader()
					.getResourceAsStream("resource/config.properties");
			prop = new Properties();
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		//System.out.println("url : "+prop.getProperty("url"));
		//System.out.println("browser : "+prop.getProperty("browser"));
		//System.out.println("username : "+prop.getProperty("username"));
		//System.out.println("password : "+prop.getProperty("password"));

	}
	public String getUrl(){
			if(prop.getProperty("url") == null){
				return "";
			}
			return prop.getProperty("url");
	}
	public String getBrowser(){
		if(prop.getProperty("browser") == null){
			return "";
		}
		return prop.getProperty("browser");
	}
	public String getUsername(){
		if(prop.getProperty("username") == null){
			return "";
		}
		return prop.getProperty("username");
	}
	public String getPassword(){
		if(prop.getProperty("password") == null){
			return "";
		}
		return prop.getProperty("password");
	}
	public int getElementWait(){
		if(prop.getProperty("ElementWait") == null){
			return 0;
		}
		return Integer.parseInt(prop.getProperty("ElementWait"));
	}
	public int getPageLoadWait(){
		if(prop.getProperty("PageLoadWait") == null){
			return 0;
		}
		return Integer.parseInt(prop.getProperty("PageLoadWait"));
	}
}
