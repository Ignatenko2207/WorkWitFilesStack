package com.stdstack;

import com.stdstack.model.ConnectionInfo;
import com.stdstack.service.FileService;
import com.stdstack.util.Randomizer;

import java.util.Date;
import java.util.List;

public class ApplicationRunner {

    public static void main(String[] args){

        ConnectionInfo connectionInfo =
                    new ConnectionInfo(Randomizer.getRandomSessionId(), Randomizer.getRandomIp(), new Date().getTime() );

        FileService.writeObjectToFile(connectionInfo, "object.obj");
        ConnectionInfo newConnectionInfo = FileService.readObjectFromFile("object.obj");

        System.out.println(connectionInfo.getSessionId());
        System.out.println(newConnectionInfo.getSessionId());
//        boolean newProcess = true;
//        boolean append = false;
//        for (int i = 0; i < 10; i++) {
//            Long period = 1000*60*60*12L;
//            ConnectionInfo connectionInfo =
//                    new ConnectionInfo(Randomizer.getRandomSessionId(), Randomizer.getRandomIp(), new Date().getTime() - (i*period) );
//            FileService.writeInfoToFile(connectionInfo, "connections.txt", append, newProcess);
//            newProcess = false;
//            append = true;
//        }
//
//        List<ConnectionInfo> connectionInfoList = FileService.readInfoFromFile("connections.txt");
//        System.out.println(connectionInfoList.size());

//        int number = 12345;
//
//        System.out.println(getSumByDiv(number));
//
//        number = 12345;
//
//        System.out.println(getSumByTypeFormat(number));

//        FileService.copyFile("cat.jpg", "cat-copy.jpg");


    }

    private static int getSumByTypeFormat(int number) {
        int result = 0;
        char[] symbols = String.valueOf(number).toCharArray();
        for (char symbol : symbols ) {
            result = result + Character.getNumericValue(symbol);
        }

        return result;
    }

    private static int getSumByDiv(int number) {
        int result = 0;
        while (number > 0){
            result = result + number%10;
            number = number/10;
        }
        return result;
    }
}
