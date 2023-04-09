package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class PropertyFile_Utility {

	public String getDAtaFromPropertyFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IConstant_Utility.propertiFile);
		Properties p=new Properties();
		p.load(fis);
		String Value=p.getProperty(key);
		return Value;
		
	}
}
