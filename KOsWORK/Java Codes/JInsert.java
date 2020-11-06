import java.io.*;

 public class JInsert {
   public static void main(String args[]){
     try {
       JInsert j = new JInsert();
      j.insertStringInFile
          (new File(args[0]),Integer.parseInt(args[1]), args[2]);
       }
     catch (Exception e) {
       e.printStackTrace();
       }
     }

   public void insertStringInFile
         (File inFile, int lineno, String lineToBeInserted) 
       throws Exception {
     // temp file
     File outFile = new File("$$$$$$$$.tmp");
     
     // input
     FileInputStream fis  = new FileInputStream(inFile);
     BufferedReader in = new BufferedReader
         (new InputStreamReader(fis));

     // output         
     FileOutputStream fos = new FileOutputStream(outFile);
     PrintWriter out = new PrintWriter(fos);

     String thisLine = "";
     int i =1;
     while ((thisLine = in.readLine()) != null) {
       if(i == lineno) out.println(lineToBeInserted);
       out.println(thisLine);
       i++;
       }
    out.flush();
    out.close();
    in.close();
    
    inFile.delete();
    outFile.renameTo(inFile);
    }
}