package shop.ingong.dto;

import lombok.Data;

@Data
public class StoreVo {
    private String menu ="";
    private String price = "";

    public StoreVo(String menu,String price){
        this.menu = menu;
        this.price = price;
    }

}
