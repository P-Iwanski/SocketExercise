import dao.InsurerDao;
import dao.UserDao;
import dao.VehicleDao;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {

        runner(5555);
    }

    private static void runner(int port) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                executorService.submit(() -> {
                    System.out.println("New client connected");
                    while (true) {
                        UserDao userDao = new UserDao();
                        VehicleDao vehicleDao = new VehicleDao();
                        InsurerDao insurerDao = new InsurerDao();

                        OutputStream output = socket.getOutputStream();
                        InputStream input = socket.getInputStream();
                        PrintWriter writer = new PrintWriter(output, true);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

                        writer.println("Podaj id użytkownika");
                        String userId = bufferedReader.readLine();
                        String password = userDao.checkPassword(Integer.valueOf(userId));
                        writer.println("Podaj hasło dla użytkownika o id" + userId);
                        String passwordToCheck = bufferedReader.readLine();

                        if (passwordToCheck.equals(password)) {
                            writer.println(userDao.read(Integer.valueOf(userId)));
                            writer.println(vehicleDao.findAll(Integer.valueOf(userId)));
                            writer.println(insurerDao.findAll(Integer.valueOf(userId)));
                        } else {
                            writer.println("Hasło niepoprawne");
                        }
                    }
                });
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}