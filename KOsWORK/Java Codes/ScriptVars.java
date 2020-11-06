import javax.script.*;
import java.io.File;

public class ScriptVars {
	public static void main (String[] args) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		
		File f=new File("test.txt");
		//expose File object as varaible to script
		engine.put("file",f);
		
		//evaluate a script string. The script accesses "file"
		//variable and calls method on it
		engine.eval("print(file.getAbsolutePath())");
	}
    
}