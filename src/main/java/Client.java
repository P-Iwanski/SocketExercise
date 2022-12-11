import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
     Socket socket = new Socket("localhost", 5555);

        PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        Scanner scanner = new Scanner(System.in);

        //Podaj id:
        String idRequest = bf.readLine();
        System.out.println(idRequest);

        //Tu użytkownik podaje ID do konsoli
        String id  = scanner.nextLine();
        pr.println(id);

        //Podaj hasło
        String passwordRequest = bf.readLine();
        System.out.println(passwordRequest);

        //Tu użytkownik podaje hasło
       String password = scanner.nextLine();
        pr.println(password);

        //Wyświetla dane użytkownika
        String showUserData = bf.readLine();
        if (showUserData.equals("Hasło niepoprawne")){
            System.out.println("Spróbuj ponownie później");
           return;
        }
        System.out.println(showUserData);

        //wyświetla auta
        String showVehicles = bf.readLine();
        System.out.println(showVehicles);

        //wyświetla ubezpieczenia
        String showInsurance = bf.readLine();
        System.out.println(showInsurance);
    }
}
