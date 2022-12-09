package upload;
import java.util.*;
import java.io.*;
public class Upload
{
	public Upload(){

	}
	public Vector<String> getMessageServer(String nameFile)
	{
		
		Vector<String> info = new Vector<String>();
		try 
		{
			FileReader fileReader = new FileReader(nameFile);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String[] line = reader.readLine().split(";;");
			for(int i=0;i<line.length;i++){
				info.add(line[i]);
			}
				
			reader.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		return info;
	}
}