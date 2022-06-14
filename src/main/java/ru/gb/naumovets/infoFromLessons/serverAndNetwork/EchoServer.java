package ru.gb.naumovets.infoFromLessons.serverAndNetwork;

import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    //  Эхо-сервер - возвращает клиенту сообщение, которое клиент послал на сервер
    public static void main(String[] args) {
//  Socket - специальный класс для общения по сети
        //ServerSocket serverSocket = null;
        //try with resources - автоматически закрывает ресурс
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
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
            //Читаем сообщение при помощи бесконечного цикла
            while (true){ // poison pill - отравленная таблетка. Позволяет выйти из цикла чтения сообщения сервером
                //Для чтения сообщения вызываем метод .redUTF(), потому что будем общаться текстом
                String message = in.readUTF();
                //Ядовитая таблетка
                if("/end".equalsIgnoreCase(message)){
                    //Отправляем клиенту тоже самое сообщение, так как это эхо сервер
                    out.writeUTF("/end");
                    break;
                }
                out.writeUTF("[echo] " + message);
                System.out.println("Сообщение от клиента: " + message);
            }
            //как только мы выйдем из цикла, отработает try with resources и серверный сокет отключится
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
////  Указываем на какой порт шлем сообщение от сервера программе
//            serverSocket = new ServerSocket(8189);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (serverSocket != null) {
//                try {
//                    serverSocket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
