package Main.Vehicles;

import java.io.Serializable;

abstract public class Air_Vehicles extends Vehicle implements Serializable {
    private int max_Fly_Height;
    private int band_Length;
    //____________________setter__________________________//
    public void setMax_Fly_Height(int max_Fly_Height) {
        this.max_Fly_Height = max_Fly_Height;
    }

    public void setBand_Length(int band_Length) {
        this.band_Length = band_Length;
    }
    //_______________________getter____________________________//
    public int getBand_Length() {
        return band_Length;
    }

    public int getMax_Fly_Height() {
        return max_Fly_Height;
    }
    //______________________constructor______________________//
    public Air_Vehicles(int price, String company_Name, int vehicle_ID, int capacity,int band_Length,int max_Fly_Height){
        super(price,company_Name,vehicle_ID,capacity);
        setBand_Length(band_Length);
        setMax_Fly_Height(max_Fly_Height);
    }
    //____________________________________________//
    public abstract void printInfo();

}
