package ru.gb.naumovets.homeWork6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        //try with resources - автоматически закрывает ресурс
        try (ServerSocket serverSocket = new ServerSocket(8189);
             Scanner scanner = new Scanner(System.in)) {
            //слушаем порт 8189
            //.accept() возвращает обычный сокет(не серверный) по которому мы будем общаться
            System.out.println("Подключение клиента...");
            //.accept() метод блокирующий. Пока не будет установлено соединение между клиентом и сервером мы так и будем висеть на этой строчке кода
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            //Общаться будем по стримам ввода-вывода через сокет. Для того, чтобы получать сообщения из сокета нужно создать специальные классы(стримы ввода-вывода)
            //Принимаем (читаем) входящие сообщения при помощи DataInputStream от клиента
            DataInputStream in = new DataInputStream(socket.getInputStream());
            //Отправляем сообщение обратно клиенту при помощи DataOutputStream
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            //Дадим возможность серверу писать сообщения
            Thread thread = new Thread(() -> {
                //Читаем сообщение при помощи бесконечного цикла
                try {
                    while (true) { // poison pill - отравленная таблетка. Позволяет выйти из цикла чтения сообщения сервером
                        //Для чтения сообщения вызываем метод .redUTF(), потому что будем общаться текстом
                        String message = in.readUTF();
                        //Ядовитая таблетка
                        if ("/end".equalsIgnoreCase(message)) {
                            break;
                        }
                        System.out.println("Сообщение от клиента: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            while (thread.isAlive()) {
                out.writeUTF(scanner.nextLine());
            }
            //как только мы выйдем из цикла, отработает try with resources и серверный сокет отключится
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
