package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeItem {

    private String username;
    private String room;
    private String itemName;
    private String price;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void Set(String u, String r, String i, String p){
        this.username = u;
        this.room = r;
        this.itemName = i;
        this.price = p;
    }

    public String Get(){
        return this.username + "," + this.room + "," + this.itemName + "," + this.price;
    }

    public Boolean Write(String path) {
        try {
            double price = Double.parseDouble(this.getPrice());
            if (price <= 0 || price >= 10000) {
                return false;
            }
            // to append to a file
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
            out.println(this.Get());
            out.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
