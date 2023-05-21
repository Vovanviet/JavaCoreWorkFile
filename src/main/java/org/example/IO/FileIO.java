package org.example.IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileIO {
    private String fileName="product.txt";
    public FileIO(){
        try{
            Files.createFile(Path.of(fileName));
        } catch (IOException e) {

        }
    }
    public StringBuffer readFile(){
        StringBuffer stringBuffer = new StringBuffer();
        try {
            BufferedReader reader= new BufferedReader(new FileReader(fileName));
            long size = Files.lines(Path.of(fileName)).count();
            for (long i = 0L;i < size;i++){
                String readLine= reader.readLine();
                String[] line = readLine.split(",");
                if (readLine.equals("") | line.length != 6){
                    continue;
                }
                stringBuffer.append(readLine).append("\n");

            }
            reader.close();
        } catch (IOException |ArrayIndexOutOfBoundsException e) {
            System.err.println("Có lỗi xảy ra: "+ e.getMessage() );
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
        return stringBuffer;
    }
    public void writeFile(String data){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
            writer.append(data);
            writer.newLine();
            System.out.println("thêm mới sản phẩm thành công");
            System.out.println(data);
            writer.close();
        } catch (IOException |ArrayIndexOutOfBoundsException e) {
            System.err.println("Có lỗi xảy ra: "+ e.getMessage() );
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }
    public void writeNoAppend(String data){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(data);
            writer.close();
        } catch (IOException |ArrayIndexOutOfBoundsException e) {
            System.err.println("Có lỗi xảy ra: "+ e.getMessage() );
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
