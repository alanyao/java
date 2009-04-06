package com.yao.value;

public class ServiceCall {
    
    private String customerID;
    private String customerName;
    private String callTypeCode;
    private String dateOfCallString;

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString() + "\n");
        sb.append("customerID: " + customerID + "\n");
        sb.append("customerName: " + customerName + "\n");
        sb.append("callTypeCode: " + callTypeCode + "\n");
        sb.append("dateOfCallString: " + dateOfCallString + "\n");
        return sb.toString();
    }
}
