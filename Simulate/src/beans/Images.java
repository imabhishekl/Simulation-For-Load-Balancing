/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author root
 */
public class Images 
{    
    private String image_name;
    private String os;
    private int ram;
    private int hd;
    private float load;

    /**
     * @return the image_name
     */
    public String getImage_name() {
        return image_name;
    }

    /**
     * @param image_name the image_name to set
     */
    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    /**
     * @return the os
     */
    public String getOs() {
        return os;
    }

    /**
     * @param os the os to set
     */
    public void setOs(String os) {
        this.os = os;
    }

    /**
     * @return the ram
     */
    public int getRam() {
        return ram;
    }

    /**
     * @param ram the ram to set
     */
    public void setRam(int ram) {
        this.ram = ram;
    }

    /**
     * @return the hd
     */
    public int getHd() {
        return hd;
    }

    /**
     * @param hd the hd to set
     */
    public void setHd(int hd) {
        this.hd = hd;
    }

    /**
     * @return the load
     */
    public float getLoad() {
        return load;
    }

    /**
     * @param load the load to set
     */
    public void setLoad(float load) {
        this.load = load;
    }
     
}
