import java.net.*;
import java.io.*;
import java.util.*;

class KnockKnockServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
		System.out.println("8");
        try {
        	System.out.println("10");
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + 4444 + ", " + e);
            System.exit(1);
        }

		System.out.println("17");
        Socket clientSocket = null;
        try {
        	System.out.println("20");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
        	System.out.println("23");
            System.out.println("Accept failed: " + 4444 + ", " + e);
            System.exit(1);
        }

        try {
        	System.out.println("29");
            BufferedReader br = new BufferedReader(
                                 new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("32");
            PrintWriter pw = new PrintWriter(
                             new BufferedOutputStream(clientSocket.getOutputStream(), 1024), false);
            KKState kks = new KKState();
            System.out.println("36");
            String inputLine, outputLine;

            outputLine = kks.processInput(null);
            pw.println(outputLine);
            pw.flush();

            while ((inputLine = br.readLine()) != null) {
                 outputLine = kks.processInput(inputLine);
                 pw.println(outputLine);
                 pw.flush();
                 if (outputLine.equals("Bye."))
                    break;
            }
            pw.close();
            br.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}