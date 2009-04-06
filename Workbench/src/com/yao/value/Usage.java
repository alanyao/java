package com.yao.value;

public class Usage {
    
    private String customerID;
    private String customerName;
    private String cycle;
    private String readDate;
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString() + "\n");
        sb.append("customerID: " + customerID + "\n");
        sb.append("customerName: " + customerName + "\n");
        sb.append("cycle: " + cycle + "\n");
        sb.append("readDate: " + readDate + "\n");
        return sb.toString();
    }

}
