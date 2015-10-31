/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author root
 */
public class Node implements Serializable{
    
    private String name;
    private float load;
    private float mem_total;
    private float mem_free;
    private int boottime;
    private float load_one;
    private float load_five;
    private float load_fifteen;
    private float cpu_idle;
    private float cpu_user;
    private float cpu_nice;
    private float cpu_aidle;
    private float cpu_system;
    private float cpu_wio;
    private int proc_total;
    private short cpu_num;
    private int cpu_speed;
    private int proc_run;
    private double disk_free;
    private double disk_total;
    private boolean dead;
    private boolean active;
    private String ip;
    
    LinkedList<Instance> instances = new LinkedList<Instance>();

    public LinkedList<Instance> getInstances() {
        return instances;
    }

    public void setInstances(LinkedList<Instance> instances) {
        this.instances = instances;
    }
    
    
    
    public Node(String name) 
    {
        this.name = name;
        
    }

    public Node(String name, float mem_total, float mem_free, int boottime, float load_one, float load_five, float load_fifteen, float cpu_idle, float cpu_user, float cpu_nice, float cpu_aidle, float cpu_system, float cpu_wio, int proc_total, short cpu_num, int cpu_speed, int proc_run, double disk_free, double disk_total, boolean dead, boolean active) {
        this.name = name;
        this.mem_total = mem_total;
        this.mem_free = mem_free;
        this.boottime = boottime;
        this.load_one = load_one;
        this.load_five = load_five;
        this.load_fifteen = load_fifteen;
        this.cpu_idle = cpu_idle;
        this.cpu_user = cpu_user;
        this.cpu_nice = cpu_nice;
        this.cpu_aidle = cpu_aidle;
        this.cpu_system = cpu_system;
        this.cpu_wio = cpu_wio;
        this.proc_total = proc_total;
        this.cpu_num = cpu_num;
        this.cpu_speed = cpu_speed;
        this.proc_run = proc_run;
        this.disk_free = disk_free;
        this.disk_total = disk_total;
        this.dead = dead;
        this.active = active;
    }
    
    
    
    public Node() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mem_total
     */
    public float getMem_total() {
        return mem_total;
    }

    /**
     * @param mem_total the mem_total to set
     */
    public void setMem_total(float mem_total) {
        this.mem_total = mem_total;
    }

    /**
     * @return the mem_free
     */
    public float getMem_free() {
        return mem_free;
    }

    /**
     * @param mem_free the mem_free to set
     */
    public void setMem_free(float mem_free) {
        this.mem_free = mem_free;
    }

    /**
     * @return the boottime
     */
    public int getBoottime() {
        return boottime;
    }

    /**
     * @param boottime the boottime to set
     */
    public void setBoottime(int boottime) {
        this.boottime = boottime;
    }

    /**
     * @return the load_five
     */
    public float getLoad_five() {
        return load_five;
    }

    /**
     * @param load_five the load_five to set
     */
    public void setLoad_five(float load_five) {
        this.load_five = load_five;
    }

    /**
     * @return the load_ten
     */
    public float getLoad_one() {
        return load_one;
    }

    /**
     * @param load_ten the load_ten to set
     */
    public void setLoad_one(float load_one) {
        this.load_one = load_one;
    }

    /**
     * @return the load_fifteen
     */
    public float getLoad_fifteen() {
        return load_fifteen;
    }

    /**
     * @param load_fifteen the load_fifteen to set
     */
    public void setLoad_fifteen(float load_fifteen) {
        this.load_fifteen = load_fifteen;
    }

    /**
     * @return the cpu_idle
     */
    public float getCpu_idle() {
        return cpu_idle;
    }

    /**
     * @param cpu_idle the cpu_idle to set
     */
    public void setCpu_idle(float cpu_idle) {
        this.cpu_idle = cpu_idle;
    }

    /**
     * @return the cpu_user
     */
    public float getCpu_user() {
        return cpu_user;
    }

    /**
     * @param cpu_user the cpu_user to set
     */
    public void setCpu_user(float cpu_user) {
        this.cpu_user = cpu_user;
    }

    /**
     * @return the cpu_nice
     */
    public float getCpu_nice() {
        return cpu_nice;
    }

    /**
     * @param cpu_nice the cpu_nice to set
     */
    public void setCpu_nice(float cpu_nice) {
        this.cpu_nice = cpu_nice;
    }

    /**
     * @return the cpu_aidle
     */
    public float getCpu_aidle() {
        return cpu_aidle;
    }

    /**
     * @param cpu_aidle the cpu_aidle to set
     */
    public void setCpu_aidle(float cpu_aidle) {
        this.cpu_aidle = cpu_aidle;
    }

    /**
     * @return the cpu_system
     */
    public float getCpu_system() {
        return cpu_system;
    }

    /**
     * @param cpu_system the cpu_system to set
     */
    public void setCpu_system(float cpu_system) {
        this.cpu_system = cpu_system;
    }

    /**
     * @return the cpu_wio
     */
    public float getCpu_wio() {
        return cpu_wio;
    }

    /**
     * @param cpu_wio the cpu_wio to set
     */
    public void setCpu_wio(float cpu_wio) {
        this.cpu_wio = cpu_wio;
    }

    /**
     * @return the proc_total
     */
    public int getProc_total() {
        return proc_total;
    }

    /**
     * @param proc_total the proc_total to set
     */
    public void setProc_total(int proc_total) {
        this.proc_total = proc_total;
    }

    /**
     * @return the cpu_num
     */
    public short getCpu_num() {
        return cpu_num;
    }

    /**
     * @param cpu_num the cpu_num to set
     */
    public void setCpu_num(short cpu_num) {
        this.cpu_num = cpu_num;
    }

    /**
     * @return the cpu_speed
     */
    public int getCpu_speed() {
        return cpu_speed;
    }

    /**
     * @param cpu_speed the cpu_speed to set
     */
    public void setCpu_speed(int cpu_speed) {
        this.cpu_speed = cpu_speed;
    }

    /**
     * @return the proc_run
     */
    public int getProc_run() {
        return proc_run;
    }

    /**
     * @param proc_run the proc_run to set
     */
    public void setProc_run(int proc_run) {
        this.proc_run = proc_run;
    }

    /**
     * @return the disk_free
     */
    public double getDisk_free() {
        return disk_free;
    }

    /**
     * @param disk_free the disk_free to set
     */
    public void setDisk_free(double disk_free) {
        this.disk_free = disk_free;
    }

    /**
     * @return the disk_total
     */
    public double getDisk_total() {
        return disk_total;
    }

    /**
     * @param disk_total the disk_total to set
     */
    public void setDisk_total(double disk_total) {
        this.disk_total = disk_total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Node(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public String toString()
    {
        String toString = this.getName() + "\n" + this.getDisk_total() + "\n" + this.getLoad_fifteen() + "\n" + this.getMem_total() + 
                "\n" + this.getDisk_free() + "\n" + this.getMem_free() + "\n" + this.getCpu_system() + "\n" + this.getProc_run()
                + "\n" + this.getCpu_speed();
        
        Iterator<Instance> inst = this.getInstances().iterator();
        
        toString = toString + "\n" + "----------------------------";
        
        while(inst.hasNext())
        {
            toString = toString + inst.next().toString();
        }
        
        return toString;
        
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