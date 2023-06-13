/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.contracts;

/**
 *
 * @author tranp
 */
public class ContractDTO {
    private String contractID;
    private String contrTitle;
    private int contrNumber;
    private String contrCreateDate;
    private String contrStartDate;
    private String contrEndDate;
    private float contrFee;
    private String contrFeeType;
    private String contrDescription;
    private String contrSignStatus;
    private String contrBillingDate;
    private String contrFeeStatus;
    private String contrAttachment;
    private String contrStatus;
    private String userName;
    private String buyerSignature;
    private String sellerSignature;

    public ContractDTO() {
    }

    public ContractDTO(String contractID, String contrTitle, int contrNumber, String contrCreateDate, String contrStartDate, String contrEndDate, float contrFee, String contrFeeType, String contrDescription, String contrSignStatus, String contrBillingDate, String contrFeeStatus, String contrAttachment, String contrStatus, String userName, String buyerSignature, String sellerSignature) {
        this.contractID = contractID;
        this.contrTitle = contrTitle;
        this.contrNumber = contrNumber;
        this.contrCreateDate = contrCreateDate;
        this.contrStartDate = contrStartDate;
        this.contrEndDate = contrEndDate;
        this.contrFee = contrFee;
        this.contrFeeType = contrFeeType;
        this.contrDescription = contrDescription;
        this.contrSignStatus = contrSignStatus;
        this.contrBillingDate = contrBillingDate;
        this.contrFeeStatus = contrFeeStatus;
        this.contrAttachment = contrAttachment;
        this.contrStatus = contrStatus;
        this.userName = userName;
        this.buyerSignature = buyerSignature;
        this.sellerSignature = sellerSignature;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getContrTitle() {
        return contrTitle;
    }

    public void setContrTitle(String contrTitle) {
        this.contrTitle = contrTitle;
    }

    public int getContrNumber() {
        return contrNumber;
    }

    public void setContrNumber(int contrNumber) {
        this.contrNumber = contrNumber;
    }

    public String getContrCreateDate() {
        return contrCreateDate;
    }

    public void setContrCreateDate(String contrCreateDate) {
        this.contrCreateDate = contrCreateDate;
    }

    public String getContrStartDate() {
        return contrStartDate;
    }

    public void setContrStartDate(String contrStartDate) {
        this.contrStartDate = contrStartDate;
    }

    public String getContrEndDate() {
        return contrEndDate;
    }

    public void setContrEndDate(String contrEndDate) {
        this.contrEndDate = contrEndDate;
    }

    public float getContrFee() {
        return contrFee;
    }

    public void setContrFee(float contrFee) {
        this.contrFee = contrFee;
    }

    public String getContrFeeType() {
        return contrFeeType;
    }

    public void setContrFeeType(String contrFeeType) {
        this.contrFeeType = contrFeeType;
    }

    public String getContrDescription() {
        return contrDescription;
    }

    public void setContrDescription(String contrDescription) {
        this.contrDescription = contrDescription;
    }

    public String getContrSignStatus() {
        return contrSignStatus;
    }

    public void setContrSignStatus(String contrSignStatus) {
        this.contrSignStatus = contrSignStatus;
    }

    public String getContrBillingDate() {
        return contrBillingDate;
    }

    public void setContrBillingDate(String contrBillingDate) {
        this.contrBillingDate = contrBillingDate;
    }

    public String getContrFeeStatus() {
        return contrFeeStatus;
    }

    public void setContrFeeStatus(String contrFeeStatus) {
        this.contrFeeStatus = contrFeeStatus;
    }

    public String getContrAttachment() {
        return contrAttachment;
    }

    public void setContrAttachment(String contrAttachment) {
        this.contrAttachment = contrAttachment;
    }

    public String getContrStatus() {
        return contrStatus;
    }

    public void setContrStatus(String contrStatus) {
        this.contrStatus = contrStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBuyerSignature() {
        return buyerSignature;
    }

    public void setBuyerSignature(String buyerSignature) {
        this.buyerSignature = buyerSignature;
    }

    public String getSellerSignature() {
        return sellerSignature;
    }

    public void setSellerSignature(String sellerSignature) {
        this.sellerSignature = sellerSignature;
    }

    

    
}
