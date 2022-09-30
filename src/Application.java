public class Application {
    public void run() {

        ClientHttp clientHttp = new ClientHttp();
        String cmd = "";

        System.out.println("#####################################################################################");
        System.out.println("Kanye West quotes.\nType 'next' to get another citation. Type 'exit' to exit program.");
        System.out.println("#####################################################################################");
        String response = clientHttp.Get("https://api.kanye.rest/text");
        System.out.println(response);

        while(cmd != "exit") {
            cmd = System.console().readLine();
        
            switch(cmd) {
                case "next":
                    response = clientHttp.Get("https://api.kanye.rest/text");
                    if(response == null)
                        return;
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
