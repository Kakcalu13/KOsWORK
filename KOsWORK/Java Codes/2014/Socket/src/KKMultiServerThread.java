import java.net.*;
import java.io.*;

class KKMultiServerThread extends Thread {
    Socket socket = null;

    KKMultiServerThread(Socket socket) {
        super("KKMultiServerThread");
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(
                                  new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(
                              new BufferedOutputStream(socket.getOutputStream(), 1024), false);
            KKState kks = new KKState();
            String inputLine, outputLine;

            outputLine = kks.processInput(null);
            pw.println(outputLine);
            pw.flush();

            while ((inputLine = br.readLine()) != null) {
                outputLine = kks.processInput(inputLine);
                pw.println(outputLine);
                pw.flush();
                if (outputLine.equals("Bye"))
                    break;
            }
            pw.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}