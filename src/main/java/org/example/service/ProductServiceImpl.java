package org.example.service;

import org.example.Entity.Product;
import org.example.IO.FileIO;
import org.example.helper.IncreaseNumber;

public class ProductServiceImpl implements ProductService {
    private static final String fileName = "product.txt";
    Product product ;

    public ProductServiceImpl() {
        product = new Product();
    }

    @Override
    public void getAll() {
        FileIO loadFile = new FileIO();
        StringBuffer stringBuffer = loadFile.readFile();
        String[] allLine = stringBuffer.toString().split("\n");
        if (allLine.length == 0){
            System.err.println("Không có sản phẩm nào");
        }else {
            System.out.println(loadFile.readFile());
        }
    }

    @Override
    public boolean searchById(Long key) {
        FileIO loadFile = new FileIO();
        StringBuffer stringBuffer = loadFile.readFile();
        String[] allLine = stringBuffer.toString().split("\n");
        if (stringBuffer.isEmpty()){
            System.err.println("Không có sản phẩm nào");
        }else {
            int count=0;
            for (String line : allLine) {
                    String[] item = line.split(",");
                    String[] id = item[0].split("=");
                    Long idValue = Long.parseLong(id[1]);
                    if (idValue.equals(key)) {
                        System.out.println(line);
                        count=count+1;
                        return true;
                    }
            }
            if (count == 0){
                System.out.println("Không tìm thấy sản phẩm");
            }
        }
        return false;
    }

    @Override
    public void searchByName(String key) {
        FileIO loadFile = new FileIO();
        StringBuffer stringBuffer = loadFile.readFile();
        String[] allLine = stringBuffer.toString().split("\n");
        if (stringBuffer.isEmpty()){
            System.err.println("Không có sản phẩm nào");
        }else {
            int count = 0;
            for (String line : allLine) {
                String[] item = line.split(",");
                String[] id = item[1].split("=");
                String nameValue = id[1];
                if (nameValue.trim().toLowerCase().contains(key.trim().toLowerCase())) {
                    System.out.println(line);
                    count++;
                }
            }
            if (count == 0){
                System.out.println(" Không tìm thấy!!!");
            }
        }
    }


    @Override
    public void searchByCategory(String key) {
        FileIO loadFile = new FileIO();
        StringBuffer stringBuffer = loadFile.readFile();
        String[] allLine = stringBuffer.toString().split("\n");
        if(stringBuffer.isEmpty()){
            System.err.println("Không có sản phẩm nào");
        }else {
            int count=0;
            for (String line : allLine) {
                String[] item = line.split(",");
                String[] id = item[3].split("=");
                String categoryValue = id[1];
                if (categoryValue.trim().toLowerCase().contains(key.trim().toLowerCase())) {
                    System.out.println(line);
                    count++;
                }
            }
            if (count == 0){
                System.out.println(" Không tìm thấy!!!");
                System.out.println();
            }
        }
    }

    @Override
    public void searchByProducer(String key) {
        FileIO loadFile = new FileIO();
        StringBuffer stringBuffer = loadFile.readFile();
        String[] allLine = stringBuffer.toString().split("\n");
        if(stringBuffer.isEmpty()){
            System.err.println("Không có sản phẩm nào");
        }else {
            int count = 0;
            for (String line : allLine) {
                String[] item = line.split(",");
                String[] id = item[4].split("=");
                String nameValue = id[1];
                if (nameValue.trim().toLowerCase().contains(key.trim().toLowerCase())) {
                    System.out.println(line);
                    count++;
                }
            }
            if (count == 0){
                System.out.println(" Không tìm thấy!!!");
            }
        }
    }

    @Override
    public void searchByPrice(Long key) {
        FileIO loadFile = new FileIO();
        StringBuffer stringBuffer = loadFile.readFile();
        String[] allLine = stringBuffer.toString().split("\n");
        if(stringBuffer.isEmpty()){
            System.err.println("Không có sản phẩm nào");
        }else {
            int count = 0;
            for (String line : allLine) {
                String[] item = line.split(",");
                String[] id = item[5].split("=");
                String nameValue = id[1];
                String parseKey= String.valueOf(key);
                if (nameValue.contains(parseKey)) {

                    System.out.println(line);
                    count++;
                }
            }
            if (count == 0){
                System.out.println(" Không tìm thấy!!!");
            }
        }
    }

    @Override
    public void create(Product product) {
        FileIO loadFile = new FileIO();
        IncreaseNumber increaseNumber=new IncreaseNumber();
        product.setId(increaseNumber.increaseNumber());
        loadFile.writeFile(product.toString());
    }

    @Override
    public void update(Product product, Long id) {
        FileIO loadFile = new FileIO();
        StringBuffer stringBuffer = loadFile.readFile();
        String[] allLine = stringBuffer.toString().split("\n");
        if(stringBuffer.isEmpty()){
            System.err.println("Không thấy sản phẩm");
        }else {
            product.setId(id);
            StringBuffer temp = new StringBuffer();
            for (String line : allLine) {
                String[] item = line.split(",");
                String[] idItem = item[0].split("=");
                Long idValue = Long.parseLong(idItem[1]);
                if (idValue.equals(product.getId())) {
                    System.out.println("Sản phẩm cũ: "+ line);
                    line= line.replace(line, product.toString());
                    System.out.println("Sản phẩm mới: "+line);
                }
                temp.append(line).append("\n");
            }
            loadFile.writeNoAppend(temp.toString());
        }
    }

    @Override
    public void deleteById(Long id) {
        FileIO loadFile = new FileIO();
        StringBuffer stringBuffer = loadFile.readFile();
        String[] allLine = stringBuffer.toString().split("\n");
        if(stringBuffer.isEmpty()){
            System.err.println("Danh sách sản phẩm đang trống");
        }else {
            StringBuffer temp = new StringBuffer();
            for (String line : allLine) {
                String[] item = line.split(",");
                String[] idItem = item[0].split("=");
                Long idValue = Long.parseLong(idItem[1]);
                if (idValue.equals(id)) {
                    continue;
                }
                temp.append(line).append("\n");
            }
            loadFile.writeNoAppend(temp.toString());
        }
    }
}
