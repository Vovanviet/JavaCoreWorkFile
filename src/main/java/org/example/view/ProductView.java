package org.example.view;

import org.example.Entity.Product;
import org.example.helper.InputHelper;
import org.example.service.ProductService;
import org.example.service.ProductServiceImpl;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ProductView {
    private InputHelper inputHelper=new InputHelper();
    private ProductService service=new ProductServiceImpl();
    public void Menu() {
        System.out.println("************MENU**************");
        System.out.println("1.tìm theo id sản phẩm");
        System.out.println("2.tạo mới sản phẩm");
        System.out.println("3.cập nhật sản phẩm theo id");
        System.out.println("4.xóa sản phẩm theo id");
        System.out.println("5.xem tất cả sản phẩm");
        System.out.println("6.tìm theo tên sản phẩm");
        System.out.println("7.tìm theo loại sản phẩm");
        System.out.println("8.tìm theo nhà sản xuất");
        System.out.println("9.tìm theo giá sản phẩm");
        System.out.println("10. exit");
        System.out.println();
        System.out.println("Choice: ");
        int choice = inputHelper.readInt(1, 10);
        switch (choice) {
            case 1:
                searchProductById();
                break;
            case 2:
                createProduct();
                break;
            case 3:
                update();
                break;
            case 4:
                deleteById();
                break;
            case 5:
                    getAll();
                break;
            case 6:
                searchProductByName();
                break;
            case 7:
                searchProductByCategory();
                break;
            case 8:
                searchProductByProducer();
                break;
            case 9:
                searchProductByPrice();
                break;
            case 10:
                System.out.println("Pai!!!!!!!!!!");
                break;
        }
    }


    public void searchProductById(){
        System.out.println("Nhập id sản phẩm:");
        Long key=inputHelper.readLong(0L,999999999999999999L);
        service.searchById(key);
        Menu();
    }
    public void searchProductByName(){
        System.out.println("Nhập tên sản phẩm:");
        String key=inputHelper.readString();
        service.searchByName(key);
        Menu();
    }
    public void searchProductByCategory(){
        System.out.println("Nhập loại sản phẩm:");
        String key = inputHelper.readString();
        service.searchByCategory(key);
        Menu();
    }
    public void searchProductByProducer(){
        System.out.println("Nhập nhà sản xuất:");
        String key = inputHelper.readString();
        service.searchByProducer(key);
        Menu();
    }
    public void searchProductByPrice(){
        System.out.println("Nhập giá sản phẩm:");
        Long price = inputHelper.readLong(0L,999999999999999999L);
        service.searchByPrice(price);
        Menu();
    }
    public Product inputProduct(){
        while (true){
            System.out.println("Nhập tên sản phẩm: ");
            String name = inputHelper.readString();
            if (name != null){
                System.out.println("Nhập thông tin sản phẩm: ");
                String des = inputHelper.readString();
                if (des != null){
                    System.out.println("Nhập loại sản phẩm: ");
                    String cat = inputHelper.readString();
                    if(cat != null){
                        System.out.println("Nhập nhà sản xuất: ");
                        String producer = inputHelper.readString();
                        if (producer != null){
                            System.out.println("Nhập giá sản phẩm: ");
                            Long price = inputHelper.readLong(0L,999999999999999999L);
                            return new Product(name,des,cat,producer,price);
                        }
                    }
                }
            }
        }

    }
    public void createProduct(){
        Product product=inputProduct();
        service.create(product);
        Menu();


    }
    public void getAll(){
        service.getAll();
        Menu();
    }
    public void update(){
        System.out.println("Please import ID: ");
        Long id = inputHelper.readLong(0L,999999999999999999L);
        boolean data= service.searchById(id);
        if (data == true){
            Product product= inputProduct();
            service.update(product,id);
        }
        Menu();
    }
    public void deleteById(){
        System.out.println("Please import ID: ");
        Long id = inputHelper.readLong(0L,999999999999999999L);
        service.searchById(id);
        service.deleteById(id);
        Menu();
    }
}
