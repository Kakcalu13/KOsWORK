import java.applet.*;
import java.awt.*;

public class InJava extends java.applet.Applet {
        public void sayHello() 
        {
        	Graphics g= getGraphics();
        	g.drawString("Hellow from JAVA!", 10, 10);
        }       
    }