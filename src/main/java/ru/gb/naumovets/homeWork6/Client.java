package ru.gb.naumovets.homeWork6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    //Клиент и сервер общаются по сокету. Специальный класс, который обеспечивает их общение.
    private Socket socket;
    //Чтение сообщений
    private DataInputStream in;
    //Отсылка сообщений
    private DataOutputStream out;
    //Переменная для создания потока ввода данных пользователем через консоль
    private Scanner scanner = new Scanner(System.in);
    private boolean workClient = true;


    public static void main(String[] args) {
        new Client().start();
    }

    private void start() {
        //Открываем соединение с сервером
        try {
            openConnection();
            while (workClient) {
                //Отправляем данные на сервер
                sendMessage(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openConnection() throws IOException {
        //Порт, который мы будем слушать = порту сервера. IP адрес = адресу локальной машины(локал хост). На любом компьюетере 127.0.0.1 означает саму машину.
        //То есть мы обратимся на саму машину по порту 8189
        socket = new Socket("localhost", 8189);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
//        .readUTF() метод блокирующий. Пока сообщение от сервера не придет, программа дальше не пойдет.
//        String message = in.readUTF();
        new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();
                    if ("/end".equalsIgnoreCase(message)) {
                        workClient = false;
                        break;
                    }
                    System.out.println("Сообщение от сервера: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }).start();
    }

    private void closeConnection() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}