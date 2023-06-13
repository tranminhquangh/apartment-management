/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.contracts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author tranp
 */
public class ContractDAO {
    
    //for Admin
    private static final String SEARCH = "SELECT ContractID,ContrTitle,ContrFee,ContrFeeStatus,Username FROM tblContracts WHERE ContrTitle like ? AND ContrStatus=1";  
    private static final String GET_CONTRACT = "select *"
                                                + "FROM tblContracts WHERE ContractID = ?";  
    private static final String UPDATE_CONTRACT = "UPDATE tblContracts SET ContrTitle=?,ContrNumber=?,ContrCreateDate=?,ContrStartDate=?,ContrEndDate=?,ContrFee=?,ContrFeeType=?,ContrDescription=?,ContrBillingDate=?,ContrFeeStatus=?,ContrAttachment=?, ContrStatus=? WHERE ContractID=?";   
    private static final String REMOVE_CONTRACT = "DELETE FROM tblContracts WHERE ContractID = ?";
    
    //for Employee   
    private static final String EMPLOYEE_CONTRACT_SEARCH = "SELECT ContractID,ContrTitle,ContrFee,ContrFeeStatus,Username FROM tblContracts WHERE ContrTitle like ? AND ContrStatus=0 AND ContrSignStatus=1";   
    private static final String APPROVE_CONTRACT = "UPDATE tblContracts SET ContrStatus=1"
                                                + " WHERE ContractID=?";
    
    
    //Between Seller and Admin
    //Admin will update room and asign all rooms that Seller owns to Sellers username
    
    
    //for Customer
    
    //1. when seller sell a room 
    private static final String UPDATE_TEMP_CONTRACT = "UPDATE tblContracts SET Username = ? WHERE ContractID=?";//asign temp contract to seller

    //2. when buyer buys room 
    //generate buyer's contract
    private static final String INSERT_BUYER_CONTRACT = "INSERT INTO tblContracts(ContractID,ContrNumber,ContrCreateDate,ContrSignStatus,ContrFeeStatus,ContrStatus,Username) VALUES(?,?,?,?,?,?,?)";
    
    //generate seller's contract
    private static final String GET_SELLER = "SELECT Username FROM tblContracts WHERE ContractID = ?";
    private static final String INSERT_SELLER_CONTRACT = "INSERT INTO tblContracts(ContractID,ContrNumber,ContrCreateDate,ContrSignStatus,ContrFeeStatus,ContrStatus,Username) VALUES(?,?,?,?,?,?,?)";

    //3. Input Buyer,Seller contract
    private static final String UPDATE_CUSTOMER_CONTRACT = "UPDATE tblContracts SET ContrTitle=?,ContrStartDate=?,ContrEndDate=?,ContrFee=?,ContrFeeType=?,ContrDescription=?,ContrBillingDate=?,ContrAttachment=? WHERE ContractID=?";   
    
    //4. Check whether both contract are similar
    
    
    //5.Sign contract (select Fullname from User)
    private static final String INSERT_BUYER_SIGNATURE = "UPDATE tblContracts SET BuyerSignature = ? WHERE ContractID=?";
    private static final String INSERT_SELLER_SIGNATURE = "UPDATE tblContracts SET SellerSignature = ? WHERE ContractID=?";

    
    //display Customer's Contract list
    private static final String SEARCH_CUSTOMER_CONTRACT = "SELECT A.ContractID,A.Username, B.RoleID \n" +
                                                        "FROM tblContracts A, tblAccount B\n" +
                                                        "WHERE A.Username = B.Username AND A.Username = ? AND A.ContrTitle=?";

    
    
    //when buyer and selle both sign and confirm 
    private static final String REMOVE_TEMP_CONTRACT = "DELETE FROM tbcContracts WHERE ContractID = ?";
    
    //when both don't sign and aree to remove contract or contract expired
    private static final String REMOVE_BUYER_CONTRACT = "DELETE FROM tbcContracts WHERE ContractID = ?";
    private static final String REMOVE_SELLER_CONTRACT = "DELETE FROM tbcContracts WHERE ContractID = ?";
    private static final String INSERT_TEMP_CONTRACT = "INSERT INTO tblContracts(ContractID,ContrStatus,Username) VALUES(?,?,?)";

    public List<ContractDTO> getSearchListProduct(String search) throws SQLException{ //return user list
        List<ContractDTO> list= new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1,"%"+search+"%");
                rs = ptm.executeQuery();
                while(rs.next()){
                    String contractID = rs.getString("ContractID");
                    String contrTitle = rs.getString("ContrTitle");
                    float contrFee = rs.getFloat("ContrFee");
                    String userName = rs.getString("Username");
                    String status;
                    int contrFeeStatus = rs.getInt("ContrFeeStatus");
                    if(contrFeeStatus==1){
                        status="Paid";
                        
                    }else{
                        status="Unpaid";
                       
                    }
                    list.add(new ContractDTO(contractID,contrTitle,0,"","","",contrFee,"","","","",status,"","",userName,"",""));
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return list;
    }
    
    public ContractDTO getContract(String contractID) throws SQLException{
       

        ContractDTO contract = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn =  DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(GET_CONTRACT);
                ptm.setString(1, contractID);
                rs = ptm.executeQuery();
                if(rs.next()){
                    String contrTitle = rs.getString("ContrTitle");
                    int contrNumber = rs.getInt("ContrNumber");
                    String contrCreateDate = rs.getString("ContrCreateDate");
                    String contrStartDate = rs.getString("ContrStartDate");
                    String contrEndDate = rs.getString("ContrEndDate");
                    float contrFee = rs.getFloat("ContrFee");
                    String contrFeeType = rs.getString("ContrFeeType");
                    String contrDescription = rs.getString("ContrDescription");
                    String contrSignStatus;
                    String contrBillingDate = rs.getString("ContrBillingDate");
                    
                    String feeStatus;
                    int contrFeeStatus = rs.getInt("ContrFeeStatus");
                    if(contrFeeStatus==1){
                        feeStatus="Paid";
                        
                    }else{
                        feeStatus="Unpaid";
                       
                    }
                    String contrAttachment = rs.getString("ContrAttachment");
                    
                    String contrStatus;
                    int contractStatus = rs.getInt("ContrStatus");
                    if(contractStatus==1){
                        contrStatus="Active";
                        
                    }else{
                        contrStatus="Unactive";
                       
                    }
                    
                    String userName = rs.getString("Username");
                    String buyerSignature = rs.getString("BuyerSignature");
                    String sellerSignature = rs.getString("SellerSignature");
                    
                    contract = new ContractDTO(contractID,contrTitle,contrNumber,contrCreateDate,contrStartDate,contrEndDate,contrFee,contrFeeType,contrDescription,"Signed",contrBillingDate,feeStatus,contrAttachment,contrStatus,userName,buyerSignature,sellerSignature); 
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        
        }
        return contract;
    }
    
    //UPDATE tblContracts SET ContrTitle=?,ContrNumber=?,ContrCreateDate=?,ContrStartDate=?,ContrEndDate=?,ContrFee=?,
    //ContrFeeType=?,ContrDescription=?,ContrBillingDate=?,ContrFeeStatus=?,ContrAttachment=? WHERE ContractID=?";
    public boolean updateContract(ContractDTO contract) throws SQLException{
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn =  DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(UPDATE_CONTRACT);
                
                ptm.setString(1, contract.getContrTitle());
                ptm.setInt(2, contract.getContrNumber());
                ptm.setString(3, contract.getContrCreateDate());
                ptm.setString(4, contract.getContrStartDate());
                ptm.setString(5, contract.getContrEndDate());
                ptm.setFloat(6, contract.getContrFee());
                ptm.setString(7, contract.getContrFeeType());
                ptm.setString(8, contract.getContrDescription());
                ptm.setString(9, contract.getContrBillingDate());
                
                int feeStatus;
                String contractFeeStatus = contract.getContrFeeStatus();
                if(contractFeeStatus.equals("Paid")){
                    feeStatus=1;
                    ptm.setInt(10, feeStatus);
                }else{
                    feeStatus=0;
                    ptm.setInt(10, feeStatus);
                }
                
                ptm.setString(11, contract.getContrAttachment());
                
                int contractStatus;
                String contrStatus = contract.getContrStatus();
                if(contrStatus.equals("Active")){
                    contractStatus=1;
                    ptm.setInt(12, contractStatus);
                }else{
                    contractStatus=0;
                    ptm.setInt(12, contractStatus);
                }
                
                ptm.setString(13, contract.getContractID());
                
                check=ptm.executeUpdate()>0?true:false;            
            }
          
        } catch(Exception e){
            e.printStackTrace();
        } finally{

            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        
        }
        return check;
    }
    
    public boolean removeContract(String contractID) throws SQLException{
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn =  DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(REMOVE_CONTRACT);
                
                ptm.setString(1, contractID);
                                
                check=ptm.executeUpdate()>0?true:false;            
            }
          
        } catch(Exception e){
            e.printStackTrace();
        } finally{

            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        
        }
        return check;
    }
    
    //for Employee   
    public List<ContractDTO> getEmployeeSearchListProduct(String search) throws SQLException{ //return user list
        List<ContractDTO> list= new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(EMPLOYEE_CONTRACT_SEARCH);
                ptm.setString(1,"%"+search+"%");
                rs = ptm.executeQuery();
                while(rs.next()){
                    String contractID = rs.getString("ContractID");
                    String contrTitle = rs.getString("ContrTitle");
                    float contrFee = rs.getFloat("ContrFee");
                    String userName = rs.getString("Username");
                    String status;
                    int contrFeeStatus = rs.getInt("ContrFeeStatus");
                    if(contrFeeStatus==1){
                        status="Paid";
                        
                    }else{
                        status="Unpaid";
                       
                    }
                    list.add(new ContractDTO(contractID,contrTitle,0,"","","",contrFee,"","","","",status,"","",userName,"",""));
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return list;
    }
    
    public boolean approveContract(String contractID) throws SQLException{
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn =  DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(APPROVE_CONTRACT);
                
                ptm.setString(1, contractID);
                
                
                check=ptm.executeUpdate()>0?true:false;            
            }
          
        } catch(Exception e){
            e.printStackTrace();
        } finally{

            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        
        }
        return check;
    }
    
    
    //for Buyer
    public boolean insertBuyerContract(ContractDTO contract,String userName) throws SQLException{
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn =  DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(INSERT_BUYER_CONTRACT);
                
                ptm.setString(1, contract.getContractID());
                ptm.setInt(2, contract.getContrNumber());
                ptm.setString(3, contract.getContrCreateDate());
                ptm.setInt(4,0);
                ptm.setInt(5,0);
                ptm.setInt(6,0);
                ptm.setString(7, userName);
                
                check=ptm.executeUpdate()>0?true:false;            
            }
          
        } catch(Exception e){
            e.printStackTrace();
        } finally{

            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        
        }
        return check;
    }
    
    
    //for Seller
    public String getSeller(String contractID) throws SQLException{
       

        String seller = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn =  DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(GET_SELLER);
                ptm.setString(1, contractID);
                rs = ptm.executeQuery();
                if(rs.next()){
                    seller = rs.getString("Username");

                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        
        }
        return seller;
    }
    
    public boolean insertSellerContract(ContractDTO contract,String userName) throws SQLException{
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn =  DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(INSERT_SELLER_CONTRACT);
                
                ptm.setString(1, contract.getContractID());
                ptm.setInt(2, contract.getContrNumber());
                ptm.setString(3, contract.getContrCreateDate());
                ptm.setInt(4,0);
                ptm.setInt(5,0);
                ptm.setInt(6,0);
                ptm.setString(7, userName);
                
                check=ptm.executeUpdate()>0?true:false;            
            }
          
        } catch(Exception e){
            e.printStackTrace();
        } finally{

            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        
        }
        return check;
    }
    
    
    //for Both   
    public boolean updateCustomerContract(ContractDTO contract) throws SQLException{
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn =  DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(UPDATE_CUSTOMER_CONTRACT);
                
                ptm.setString(1, contract.getContrTitle());
                ptm.setString(2, contract.getContrStartDate());
                ptm.setString(3, contract.getContrEndDate());
                ptm.setFloat(4, contract.getContrFee());
                ptm.setString(5, contract.getContrFeeType());
                ptm.setString(6, contract.getContrDescription());
                ptm.setString(7, contract.getContrBillingDate());
                ptm.setString(8, contract.getContrAttachment());
               
                ptm.setString(9, contract.getContractID());
                
                check=ptm.executeUpdate()>0?true:false;            
            }
          
        } catch(Exception e){
            e.printStackTrace();
        } finally{

            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        
        }
        return check;
    }
    
    
    /**
     *
     * @param args
     * @return
     * @throws SQLException
     */
//    public static void main(String[] args) throws SQLException {
//        String UPDATE_CONTRACT = "UPDATE tblContracts SET ContrTitle=?,ContrNumber=?,ContrCreateDate=?,ContrStartDate=?,ContrEndDate=?,ContrFee=?,ContrFeeType=?,ContrDescription=?,ContrBillingDate=?,ContrFeeStatus=?,ContrAttachment=?, ContrStatus=? WHERE ContractID=?";
//
//        boolean check=false;
//        Connection conn=null;
//        PreparedStatement ptm=null;
//        try{
//            conn =  DBUtils.getConnection();
//            if(conn!=null){
//                ptm = conn.prepareStatement(UPDATE_CONTRACT);
//                
//                ptm.setString(1, "Sample customer");
//                ptm.setInt(2, 123);
//                ptm.setString(3, "");
//                ptm.setString(4, "");
//                ptm.setString(5, "");
//                ptm.setFloat(6, 1);
//                ptm.setString(7, "");
//                ptm.setString(8, "abc");
//                ptm.setString(9, "");
//                
//               
//                ptm.setInt(10, 1);
//               
//                
//                ptm.setString(11, "");
//                
//                
//                ptm.setInt(12, 1);
//                
//                   
//                
//                ptm.setString(13, "1");
//                
//                check=ptm.executeUpdate()>0?true:false;            
//            }
//          
//        } catch(Exception e){
//            e.printStackTrace();
//        } finally{
//
//            if(ptm!=null) ptm.close();
//            if(conn!=null) conn.close();
//        
//        }
//        
//    }
}
