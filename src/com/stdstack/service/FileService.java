package com.stdstack.service;

import com.stdstack.model.ConnectionInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String FILE_DIR = MAIN_DIR + FILE_SEP + "files";


    private static void checkDir(){
        File file = new File(FILE_DIR);
        if (!file.exists()){
            file.mkdir();
        }
    }

    public static void writeInfoToFile (ConnectionInfo connectionInfo, String fileName, boolean append, boolean newProcess){
        checkDir();

        try ( FileWriter fileWriter = new FileWriter(FILE_DIR + FILE_SEP + fileName, append) ){
            if(newProcess){
                fileWriter.write("---------------------------------\n");
            }
            fileWriter.write(connectionInfo.toString() + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ConnectionInfo> readInfoFromFile (String fileName) {
        List<ConnectionInfo> result = new ArrayList<>();
        try (FileReader fileReader = new FileReader(FILE_DIR + FILE_SEP + fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader))
        {
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                if(!line.startsWith("------")){
                    String[] words = line.split(" ");

                    Integer sessionId = Integer.valueOf(words[0]);
                    Long connectionTime = Long.valueOf(words[1]);
                    String ip = words[2];

                    ConnectionInfo connectionInfo = new ConnectionInfo(sessionId, ip, connectionTime);
                    result.add(connectionInfo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
