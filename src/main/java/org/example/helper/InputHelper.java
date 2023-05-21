package org.example.helper;

import java.util.Scanner;

public class InputHelper {
    Scanner scanner =new Scanner(System.in).useDelimiter("\n");
    public int readInt(int min, int max) {
        int choice;
        while (true) {
            try {

                choice = Integer.parseInt(scanner.next());
                if (choice >= min && choice <= max) {
                    break;
                }else {
                    System.out.println("Vui lòng nhập số trong menu");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ");
            }
        }
        return choice;
    }
    public Long readLong(Long min,Long max){
        Long input;
        while (true){
            try{
                input = Long.parseLong(scanner.next());
                if (input >= min && input <= max){
                    break;
                }else {
                    System.out.println("Nhập lại đi ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ");
            }
        }
        return input;
    }
    public String readString(){
        Long choice;
        String input;
        while (true){
            try {
                input=scanner.next();
                choice= (long) input.length();
                if (choice >=1)break;
                else System.err.println("Chưa nhập");
            } catch (Exception | Error e) {
                System.out.println("Bạn chưa nhập !!!");
            }
        }
        return input;
    }

}
