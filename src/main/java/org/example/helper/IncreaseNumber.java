package org.example.helper;

import org.example.IO.FileIO;

public class IncreaseNumber {
    private FileIO fileIO=new FileIO();
    private final StringBuffer stringBuffer = fileIO.readFile();
    private String[] allLine = stringBuffer.toString().split("\n");
    public long increaseNumber(){
        Long count = 0L;
        for (String line : allLine) {
            String[] item = line.split(",");
            String[] id = item[0].split("=");
            if (id.length == 1){
                count=1L;
            }else {
                Long nameValue = Long.parseLong(id[1]);
                if (nameValue >= count) {
                    count= nameValue +1;
                }

            }

        }
        return count;
    }
}
