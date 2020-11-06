import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvalScript {
  public static void main(String args[]) {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("javascript");
    try {
      //engine.put(x=1);
      engine.eval("var x=1;");
      double name = (double) engine.get("x");
      System.out.println(name);
    } catch (ScriptException e) {
      System.err.println(e);
    }
  }
}