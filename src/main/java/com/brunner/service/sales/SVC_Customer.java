/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.brunner.service.sales;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.brunner.service.SVC_AuthorityGroup.Constants_AuthorityGroup;
import com.brunner.service.SVC_AuthorityGroup.Messages_AuthorityGroup;
import com.brunner.service.sales.dao.TB_CUS_CUSTOMER_MST;
import com.brunner.service.util.Constants;
import com.brunner.service.util.ExceptionUtil;
import com.brunner.service.util.MapUtil;
import com.brunner.service.util.Messages;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import mw.utility.BrunnerLogger;

@Component
public class SVC_Customer {
	private final String CLASS = this.getClass().getName();
	private final Logger logger = BrunnerLogger.getLogger(CLASS);

	@PostConstruct
	public void init() {
		System.out.println(String.format("init bean [%s]", this.getClass().getName()));
	}	
	
	public JsonObject TXN_Customer_registerCustomer(
			SqlSession session,
			JsonObject request) {
		
		final String METHOD = new Exception().getStackTrace()[0].getMethodName();
		
		JsonObject reply = null;
		String resultCode = Constants_Customer.resultCode_systemException;
		String resultMessage = Constants_Customer.emptyString;
		String txnId = request.get(Constants.msgFieldName_inputData).getAsJsonObject().get(Constants.msgFieldName_txnId).getAsString();
			
   		logger.log(Level.INFO, String.format(Messages_AuthorityGroup.msg_startService, 
   				txnId, 
   				CLASS, 
   				METHOD));   		

   		int nEffected = 0;
   		
   		try {
    		List<HashMap<String, Object>> rows = TB_CUS_CUSTOMER_MST.select_02(
    				session,
    				txnId,
    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString(),
    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("customerId").getAsString()
    				);
			
   			if(rows.size() > 0) {
	   			nEffected = TB_CUS_CUSTOMER_MST.update_01(
	   					session,
	   					txnId,
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("customerId").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("salesType").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("salesCategory").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("registerName").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("registerNo").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("address").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("phoneNumber").getAsString()
	    				);
	
				if(nEffected == 1) {
	    			resultCode = Constants_Customer.resultCode_success;
	    			resultMessage = String.format(Messages_Customer.msg_successfullyFinished, CLASS, METHOD);
				} else if(nEffected == 0) {
	    			resultCode = Constants_Customer.resultCode_failToUpdateData;
	    			resultMessage = String.format(Messages_Customer.msg_failToUpdateData);
				} else {
					// 오류: 여러건 변경
	    			resultCode = Constants_Customer.resultCode_failToUpdateData;
	    			resultMessage = String.format(Messages_Customer.msg_affectedDataMoreThanOneRow);
				}
   			} else {
	   			nEffected = TB_CUS_CUSTOMER_MST.insert_01(
	   					session,
	   					txnId,
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("customerId").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("salesType").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("salesCategory").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("registerName").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("registerNo").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("address").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("phoneNumber").getAsString(),
	    				"Y"
	    				);
	
				if(nEffected == 1) {
	    			resultCode = Constants_Customer.resultCode_success;
	    			resultMessage = String.format(Messages_Customer.msg_successfullyFinished, CLASS, METHOD);
				} else if(nEffected == 0) {
					// 오류: 변경행 없음  			resultCode = Constants_Customer.resultCode_failToUpdateData;
	    			resultMessage = String.format(Messages_Customer.msg_failToUpdateData);
				} else {
					// 오류: 여러건 변경
	    			resultCode = Constants_Customer.resultCode_failToUpdateData;
	    			resultMessage = String.format(Messages_Customer.msg_affectedDataMoreThanOneRow);
				}
   			}
		} catch (Exception e) {
			resultCode = Constants_Customer.resultCode_systemException;
			resultMessage = ExceptionUtil.getFullMessage(e);
			logger.log(Level.SEVERE, resultMessage);
		}
		finally {
			reply = new JsonObject();
			reply.addProperty(Constants.msgFieldName_txnId, txnId);
			reply.addProperty(Constants.msgFieldName_resultCode, resultCode);
			reply.addProperty(Constants.msgFieldName_resultMessage, resultMessage);

			logger.log(Level.INFO, String.format(Messages_AuthorityGroup.msg_endService, 
	   				txnId, 
	   				CLASS, 
	   				METHOD));
		}
		return reply;
    }
	
	public JsonObject TXN_Customer_unregisterCustomer(
			SqlSession session,
			JsonObject request) {
		
		final String METHOD = new Exception().getStackTrace()[0].getMethodName();
		
		JsonObject reply = null;
		String resultCode = Constants_Customer.resultCode_systemException;
		String resultMessage = Constants_Customer.emptyString;
		String txnId = request.get(Constants.msgFieldName_inputData).getAsJsonObject().get(Constants.msgFieldName_txnId).getAsString();
			
   		logger.log(Level.INFO, String.format(Messages_AuthorityGroup.msg_startService, 
   				txnId, 
   				CLASS, 
   				METHOD));   	

   		int nEffected = 0;
   		
   		try {
    		List<HashMap<String, Object>> rows = TB_CUS_CUSTOMER_MST.select_02(
    				session,
    				txnId,
    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString(),
    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("customerId").getAsString()
    				);
			
   			if(rows.size() > 0) {
	   			nEffected = TB_CUS_CUSTOMER_MST.update_02(
	   					session,
	   					txnId,
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString(),
	    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("customerId").getAsString()
	    				);
	
				if(nEffected == 1) {
	    			resultCode = Constants_Customer.resultCode_success;
	    			resultMessage = String.format(Messages_Customer.msg_successfullyFinished, CLASS, METHOD);
				} else if(nEffected == 0) {
					// 오류: 변경행 변경행 없음	resultCode = Constants_Customer.resultCode_failToUpdateData;
	    			resultMessage = String.format(Messages_Customer.msg_failToUpdateData);
				} else {
					// 오류: 여러건 변경
	    			resultCode = Constants_Customer.resultCode_failToUpdateData;
	    			resultMessage = String.format(Messages_Customer.msg_affectedDataMoreThanOneRow);
				}
   			} else {
    			resultCode = Constants_Customer.resultCode_noDataFound;
    			resultMessage = String.format(Messages_Customer.msg_notExistCustomer, 
    					request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("customerId").getAsString());
   			}
		} catch (Exception e) {
			resultCode = Constants_Customer.resultCode_systemException;
			resultMessage = ExceptionUtil.getFullMessage(e);
			logger.log(Level.SEVERE, resultMessage);
		}
		finally {
			reply = new JsonObject();
			reply.addProperty(Constants.msgFieldName_txnId, txnId);
			reply.addProperty(Constants.msgFieldName_resultCode, resultCode);
			reply.addProperty(Constants.msgFieldName_resultMessage, resultMessage);

			logger.log(Level.INFO, String.format(Messages_AuthorityGroup.msg_endService, 
	   				txnId, 
	   				CLASS, 
	   				METHOD));
		}
		return reply;
    }	

	public JsonObject TXN_Customer_viewUserCustomerList(
			SqlSession session,
			JsonObject request) {
		
		final String METHOD = new Exception().getStackTrace()[0].getMethodName();
		
		JsonObject reply = null;
		String resultCode = Constants_Customer.resultCode_systemException;
		String resultMessage = Constants_Customer.emptyString;
		String txnId = request.get(Constants.msgFieldName_inputData).getAsJsonObject().get(Constants.msgFieldName_txnId).getAsString();
			
   		logger.log(Level.INFO, String.format(Messages_AuthorityGroup.msg_startService, 
   				txnId, 
   				CLASS, 
   				METHOD));   	
   		
   		List<HashMap<String, Object>> rows = null;
   		
   		try {
    		rows = TB_CUS_CUSTOMER_MST.select_01(
    				session,
    				txnId,
    				request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
    				String.format("%s", request.get(Constants_Customer.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString()));

    		JsonArray jCustomerList = new JsonArray();
    		for(int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
    			JsonObject jRow = new JsonObject();
    			HashMap<String, Object> row = rows.get(rowIndex);
       			jRow.addProperty("customerId", MapUtil.getNullableString(row, "CUSTOMER_ID"));
       		    jRow.addProperty("salesType", MapUtil.getNullableString(row, "SALES_TYPE"));
       			jRow.addProperty("salesCategory", MapUtil.getNullableString(row, "SALES_CATEGORY"));
    			jRow.addProperty("registerName", MapUtil.getNullableString(row, "REGISTER_NAME"));
    			jRow.addProperty("registerNo", MapUtil.getNullableString(row, "REGISTER_NO").toString());
    			jRow.addProperty("address", MapUtil.getNullableString(row, "ADDRESS"));
    			jRow.addProperty("phoneNumber", MapUtil.getNullableString(row, "PHONE_NUMBER").toString());
    			
    			jCustomerList.add(jRow);
    		}
    		resultCode = Constants_AuthorityGroup.resultCode_success;

    		reply = new JsonObject();
    		reply.addProperty(Constants.msgFieldName_txnId, txnId);
			reply.add("customerList", jCustomerList);
			reply.addProperty(Constants.msgFieldName_resultCode, resultCode);
			reply.addProperty(Constants.msgFieldName_resultMessage, resultMessage);
    		
		} catch (Exception e) {
			resultCode = Constants_Customer.resultCode_systemException;
			resultMessage = ExceptionUtil.getFullMessage(e);
			logger.log(Level.SEVERE, resultMessage);
		}
		finally {
			logger.log(Level.INFO, String.format(Messages_AuthorityGroup.msg_endService, 
	   				txnId, 
	   				CLASS, 
	   				METHOD));
		}
		return reply;
    }	
	
	class Constants_Customer extends Constants {
	}	

	static class Messages_Customer extends Messages {
		public static String msg_alreadyExistCustomer = "Customer [%s], Unit [%s] already exist.";
		public static String msg_notExistCustomer = "Customer [%s] not exist.";

	}	
}
