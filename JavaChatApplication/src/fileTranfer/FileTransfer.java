/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileTranfer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author THIS PC
 */
public class FileTransfer {
    public static void sendFile(DataOutputStream output, File fileToSend) throws IOException {
        output.writeUTF("IS SENDING FILE...");
        try (FileInputStream fileInput = new FileInputStream(fileToSend)) {
            String fileName = fileToSend.getName();
            long fileSize = fileToSend.length();
            
            output.writeUTF(fileName);
            output.writeLong(fileSize);

            byte[] buffer = new byte[4 * 1024];
            int bytesRead;
            while ((bytesRead = fileInput.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            output.flush();
        }
    }

    public static void receiveFile(DataInputStream input, String saveDirectory) throws IOException {
        String fileName = input.readUTF();
        long fileSize = input.readLong();
        
        File outputFile = new File(saveDirectory, fileName);
        try (FileOutputStream fileOutput = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[4 * 1024];
            int bytesRead;
            while (fileSize > 0 && 
                   (bytesRead = input.read(buffer, 0, (int) Math.min(buffer.length, fileSize))) != -1) {
                fileOutput.write(buffer, 0, bytesRead);
                fileSize -= bytesRead;
            }
        }
    }
}