
public class Main {

    public static void main(String[] args) {
      
        System.out.println("Hello and welcome!");
        Logger log1 = Logger.getInstance();
        log1.log(Level.INFO  ,"My Application started");
        Logger log2 = Logger.getInstance();
        log2.log( Level.ERROR ,"User Not found");

        System.out.println(log1.getLogs());

    }
}
