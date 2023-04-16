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
import com.brunner.service.sales.dao.TB_CUS_MATERIAL_PURCHASE;
import com.brunner.service.util.Constants;
import com.brunner.service.util.ExceptionUtil;
import com.brunner.service.util.MapUtil;
import com.brunner.service.util.Messages;
import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

import mw.utility.BrunnerLogger;

@Component
public class SVC_MaterialPurchase {
	private final String CLASS = this.getClass().getName();
	private final Logger logger = BrunnerLogger.getLogger(CLASS);

	@PostConstruct
	public void init() {
		System.out.println(String.format("init bean [%s]", this.getClass().getName()));
	}	
	
	public JsonObject TXN_MaterialPurchase_registerMaterialPurchase(
			SqlSession session,
			JsonObject request) {
		
		final String METHOD = new Exception().getStackTrace()[0].getMethodName();
		
		JsonObject reply = null;
		String resultCode = Constants_MaterialPurchase.resultCode_systemException;
		String resultMessage = Constants_MaterialPurchase.emptyString;
		String txnId = request.get(Constants.msgFieldName_inputData).getAsJsonObject().get(Constants.msgFieldName_txnId).getAsString();
		
   		logger.log(Level.INFO, String.format(Messages_AuthorityGroup.msg_startService, 
   				txnId, 
   				CLASS, 
   				METHOD));   			

   		int nEffected = 0;
   		
   		try {
   			String purchaseSerialNo = MapUtil.getNullableString(request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject(), "purchaseSerialNo");
	   		if(purchaseSerialNo == null || purchaseSerialNo.isEmpty() == true) {
	   			// 신규 등록
	   			nEffected = TB_CUS_MATERIAL_PURCHASE.insert_01(
	   					session,
	   					txnId,
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString(),
	    				MapUtil.getNullableString(request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject(), "purchaseSerialNo"),
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("purchaseDate").getAsString(),
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("vendorId").getAsString(),
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("materialName").getAsString(),
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("materialUnit").getAsString(),
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("unitPrice").getAsInt(),
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("purchaseCount").getAsFloat(),
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("purchaseAmount").getAsFloat(),
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("paidAmount").getAsFloat(),
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("purchaseComment").getAsString()
	    				);
	
				if(nEffected == 1) {
	    			resultCode = Constants_MaterialPurchase.resultCode_success;
	    			resultMessage = String.format(Messages_MaterialPurchase.msg_successfullyFinished, CLASS, METHOD);
				} else if(nEffected == 0) {
					// 오류: 변경행 없음  			resultCode = Constants_MaterialPurchase.resultCode_failToUpdateData;
	    			resultMessage = String.format(Messages_MaterialPurchase.msg_failToUpdateData);
				} else {
					// 오류: 여러건 변경
	    			resultCode = Constants_MaterialPurchase.resultCode_failToUpdateData;
	    			resultMessage = String.format(Messages_MaterialPurchase.msg_affectedDataMoreThanOneRow);
				}
	   		} else {
	   			// 기존 업데이트
	   			
	    		List<HashMap<String, Object>> rows = TB_CUS_MATERIAL_PURCHASE.select_02(
	    				session,
	    				txnId,
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString(),
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("purchaseSerialNo").getAsString()
	    				);
				
	   			if(rows.size() > 0) {
		   			nEffected = TB_CUS_MATERIAL_PURCHASE.update_01(
		   					session,
		   					txnId,
		    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
		    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString(),
		    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("purchaseSerialNo").getAsString(),
		    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("purchaseCount").getAsFloat(),
		    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("purchaseAmount").getAsFloat(),
		    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("paidAmount").getAsFloat(),
		    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("purchaseComment").getAsString()
		    				);
		
					if(nEffected == 1) {
		    			resultCode = Constants_MaterialPurchase.resultCode_success;
		    			resultMessage = String.format(Messages_MaterialPurchase.msg_successfullyFinished, CLASS, METHOD);
					} else if(nEffected == 0) {
		    			resultCode = Constants_MaterialPurchase.resultCode_failToUpdateData;
		    			resultMessage = String.format(Messages_MaterialPurchase.msg_failToUpdateData);
					} else {
						// 오류: 여러건 변경
		    			resultCode = Constants_MaterialPurchase.resultCode_failToUpdateData;
		    			resultMessage = String.format(Messages_MaterialPurchase.msg_affectedDataMoreThanOneRow);
					}
	   			} else {
	   				// 오류:기존 매출이 없음
	    			resultCode = Constants_MaterialPurchase.resultCode_noDataFound;
	    			resultMessage = String.format(Messages_MaterialPurchase.msg_noSuchPurchaseInfo, purchaseSerialNo);
	   			}
	   		}
   		}
   		catch (Exception e) {
			resultCode = Constants_MaterialPurchase.resultCode_systemException;
			resultMessage = ExceptionUtil.getFullMessage(e);
			logger.log(Level.SEVERE, resultMessage);
		}
		finally {
			reply = new JsonObject();
			reply.addProperty(Constants.msgFieldName_txnId,	txnId);
			reply.addProperty(Constants.msgFieldName_resultCode, resultCode);
			reply.addProperty(Constants.msgFieldName_resultMessage, resultMessage);

			logger.log(Level.INFO, String.format(Messages_AuthorityGroup.msg_endService, 
	   				txnId, 
	   				CLASS, 
	   				METHOD));
		}
		return reply;
    }
	
	public JsonObject TXN_MaterialPurchase_unregisterMaterialPurchase(
			SqlSession session,
			JsonObject request) {
		
		final String METHOD = new Exception().getStackTrace()[0].getMethodName();
		
		JsonObject reply = null;
		String resultCode = Constants_MaterialPurchase.resultCode_systemException;
		String resultMessage = Constants_MaterialPurchase.emptyString;
		String txnId = request.get(Constants.msgFieldName_inputData).getAsJsonObject().get(Constants.msgFieldName_txnId).getAsString();
		
		
   		logger.log(Level.INFO, String.format(Messages_AuthorityGroup.msg_startService, 
   				txnId, 
   				CLASS, 
   				METHOD));   	
   		
   		int nEffected = 0;
   		
   		try {
   			String purchaseSerialNo = MapUtil.getNullableString(request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject(), "purchaseSerialNo");
   			
    		List<HashMap<String, Object>> rows = TB_CUS_MATERIAL_PURCHASE.select_02(
    				session,
    				txnId,
    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString(),
    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("purchaseSerialNo").getAsString()
    				);
			
   			if(rows.size() > 0) {
	   			nEffected = TB_CUS_MATERIAL_PURCHASE.update_02(
	   					session,
	   					txnId,
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString(),
	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("purchaseSerialNo").getAsString()
	    				);
	
				if(nEffected == 1) {
	    			resultCode = Constants_MaterialPurchase.resultCode_success;
	    			resultMessage = String.format(Messages_MaterialPurchase.msg_successfullyFinished, CLASS, METHOD);
				} else if(nEffected == 0) {
	    			resultCode = Constants_MaterialPurchase.resultCode_failToUpdateData;
	    			resultMessage = String.format(Messages_MaterialPurchase.msg_failToUpdateData);
				} else {
	    			resultCode = Constants_MaterialPurchase.resultCode_failToUpdateData;
	    			resultMessage = String.format(Messages_MaterialPurchase.msg_affectedDataMoreThanOneRow);
				}
   			} else {
   				// 오류:기존 매출이 없음
    			resultCode = Constants_MaterialPurchase.resultCode_noDataFound;
    			resultMessage = String.format(Messages_MaterialPurchase.msg_noSuchPurchaseInfo, purchaseSerialNo);
   			}
		} catch (Exception e) {
			resultCode = Constants_MaterialPurchase.resultCode_systemException;
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

	public JsonObject TXN_MaterialPurchase_viewMaterialPurchaseList(
			SqlSession session,
			JsonObject request) {
		
		final String METHOD = new Exception().getStackTrace()[0].getMethodName();
		
		JsonObject reply = null;
		String resultCode = Constants_MaterialPurchase.resultCode_systemException;
		String resultMessage = Constants_MaterialPurchase.emptyString;		
		String txnId = request.get(Constants.msgFieldName_inputData).getAsJsonObject().get(Constants.msgFieldName_txnId).getAsString();
			
   		logger.log(Level.INFO, String.format(Messages_AuthorityGroup.msg_startService, 
   				txnId, 
   				CLASS, 
   				METHOD));   	

   		List<HashMap<String, Object>> rows = null;
   		
   		try {
   			if(request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().has("vendorId") == false ||
   			   request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("vendorId").equals(JsonNull.INSTANCE) ||
   			request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("vendorId").getAsString().equals("")){
  	    		rows = TB_CUS_MATERIAL_PURCHASE.select_01(
   	    				session,
   	    				txnId,
   	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
   	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString(),
   	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("fromDate").getAsString(),
   	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("toDate").getAsString()
   	    				);   				
   			} 
   			else {
   				rows = TB_CUS_MATERIAL_PURCHASE.select_03(
   	    				session,
   	    				txnId,
   	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("systemCode").getAsString(), 
   	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("userId").getAsString(),
   	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("fromDate").getAsString(),
   	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("toDate").getAsString(),
   	    				request.get(Constants_MaterialPurchase.msgFieldName_inputData).getAsJsonObject().get("vendorId").getAsString()
   	    				);
    			}
   			

    		JsonArray jMaterialList = new JsonArray();
    		for(int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
    			JsonObject jRow = new JsonObject();
    			HashMap<String, Object> row = rows.get(rowIndex);
    			jRow.addProperty("purchaseSerialNo", row.get("PURCHASE_SERIAL_NO").toString());
       			jRow.addProperty("purchaseDate", MapUtil.getNullableString(row, "PURCHASE_DATE"));
       		    jRow.addProperty("vendorId", MapUtil.getNullableString(row, "VENDOR_ID"));
       		    jRow.addProperty("registerName", MapUtil.getNullableString(row, "REGISTER_NAME"));
       			jRow.addProperty("materialName", MapUtil.getNullableString(row, "MATERIAL_NAME"));
    			jRow.addProperty("materialUnit", MapUtil.getNullableString(row, "MATERIAL_UNIT"));
    			jRow.addProperty("unitPrice", MapUtil.getNullableString(row, "UNIT_PRICE").toString());
    			jRow.addProperty("purchaseCount", MapUtil.getNullableString(row, "PURCHASE_COUNT"));
    			jRow.addProperty("purchaseAmount", MapUtil.getNullableString(row, "PURCHASE_AMOUNT").toString());
    			jRow.addProperty("paidAmount", MapUtil.getNullableString(row, "PAID_AMOUNT").toString());
       			jRow.addProperty("purchaseComment", MapUtil.getNullableString(row, "PURCHASE_COMMENT").toString());
       		    			
    			jMaterialList.add(jRow);
    		}

    		reply = new JsonObject();
    		reply.addProperty(Constants.msgFieldName_txnId, txnId);
			reply.add("materialPurchaseList", jMaterialList);

    		resultCode = Constants_AuthorityGroup.resultCode_success;

    		reply.addProperty(Constants.msgFieldName_resultCode, resultCode);
			reply.addProperty(Constants.msgFieldName_resultMessage, resultMessage);
    		
		} catch (Exception e) {
			resultCode = Constants_MaterialPurchase.resultCode_systemException;
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
	
	class Constants_MaterialPurchase extends Constants {
	}	

	static class Messages_MaterialPurchase extends Messages {
		public static String msg_noSuchPurchaseInfo = "Material purchase info [%s] not exist.";

	}	
}