/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class Instance implements Serializable{
    String filename;
    String domain_name;
    String uuid;
    float ram;
    double memory;
    int cpu;
    float load ;
    String ip = "";

    public Instance(String filename, String domain_name, String uuid) {
        this.filename = filename;
        this.domain_name = domain_name;
        this.uuid = uuid;
    }

    public Instance(String filename, String domain_name, String uuid, float ram, double memory, int cpu, float load, String ip) {
        this.filename = filename;
        this.domain_name = domain_name;
        this.uuid = uuid;
        this.ram = ram;
        this.memory = memory;
        this.cpu = cpu;
        this.load = load;
        this.ip = ip;
    }

    public Instance(String filename, String domain_name, String uuid, float ram, double memory, int cpu, float load) {
        this.filename = filename;
        this.domain_name = domain_name;
        this.uuid = uuid;
        this.ram = ram;
        this.memory = memory;
        this.cpu = cpu;
        this.load = load;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public String getDomain_name() {
        return domain_name;
    }

    public void setDomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public float getLoad() {
        return load;
    }

    public void setLoad(float load) {
        this.load = load;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public float getRam() {
        return ram;
    }

    public void setRam(float ram) {
        this.ram = ram;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }    
    
    public String toString()
    {
        return this.getDomain_name() + "\n" + this.getUuid() + "\n" + this.getRam() + "\n" + this.getMemory() + "\n" + this.getLoad() + "\n" + this.getCpu();
    }
}