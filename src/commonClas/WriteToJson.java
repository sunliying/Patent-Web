package commonClas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToJson{
	public void appendString(String fileStorePath, String appendString, boolean append){
		
		try {
			File file = new File(fileStorePath);

			if(!file.exists()){
				file.getParentFile().mkdir();
			}
			FileWriter writer = new FileWriter(file, append);
			writer.write(appendString);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}