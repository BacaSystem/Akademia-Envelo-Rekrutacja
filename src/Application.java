import java.util.ArrayList;

public class Application {

    ClientHttp clientHttp = new ClientHttp();
    ArrayList<String> quotes = new ArrayList<String>();

    public void run() {

        String cmd = "";

        System.out.println("#####################################################################################");
        System.out.println("Kanye West quotes.\nType 'next' to get another citation. Type 'exit' to exit program.");
        System.out.println("#####################################################################################");
        
        String response = clientHttp.Get("https://api.kanye.rest/text");
        if(response == null)
            return;
        quotes.add(response);
        System.out.println(response);

        while(cmd != "exit") {
            cmd = System.console().readLine();
        
            switch(cmd) {
                case "next":
                    response = clientHttp.Get("https://api.kanye.rest/text");
                    if(response == null)
                        return;
                    if(quotes.contains(response)) {
                        System.out.println("This quote was already shown. Try next one!");
                        break;
                    }
                    quotes.add(response);
                    System.out.println(response);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Not recognizable command!");
            }
        }
    }
}
