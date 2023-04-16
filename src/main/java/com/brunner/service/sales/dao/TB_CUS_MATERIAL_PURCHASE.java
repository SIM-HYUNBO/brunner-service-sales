package com.brunner.service.sales.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import com.brunner.service.util.LogUtil;

public class TB_CUS_MATERIAL_PURCHASE {
	private static final Logger logger = Logger.getLogger(TB_CUS_MATERIAL_PURCHASE.class.getName());
	
	public static int insert_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId,
			String purchaseSerialNo,
			String purchaseDate,
			String vendorId, 
			String materialName, 
			String materialUnit, 
			int unitPrice,
			float purchaseCount,
			float purchaseAmount,
			float paidAmount,
			String purchaseComment
			) throws IOException {
		
 		String sqlId = "insert_TB_CUS_MATERIAL_PURCHASE_01";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("purchaseDate", purchaseDate);
		params.put("purchaseSerialNo", userId);
		params.put("vendorId", vendorId);
		params.put("materialName", materialName);
		params.put("materialUnit", materialUnit);
 		params.put("unitPrice", unitPrice);
		params.put("purchaseCount", purchaseCount);
		params.put("purchaseAmount", purchaseAmount);
		params.put("paidAmount", paidAmount);
		params.put("purchaseComment", purchaseComment);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	

	public static int update_01(
			SqlSession session,
			String txnId,
			String systemCode,
			String userId,
			String purchaseSerialNo,
			float purchaseCount,
			float purchaseAmount,
			float paidAmout,
			String purchaseComment
			) throws IOException {
		
 		String sqlId = "update_TB_CUS_MATERIAL_PURCHASE_01";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
 		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("purchaseSerialNo", purchaseSerialNo);
		params.put("purchaseCount", purchaseCount);
		params.put("purchaseAmount", purchaseAmount);
		params.put("paidAmount", paidAmout);
		params.put("purchaseComment", purchaseComment);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	

	public static int update_02(
			SqlSession session,
			String txnId,
			String systemCode,
			String userId, 
			String purchaseSerialNo
			) throws IOException {
		
 		String sqlId = "update_TB_CUS_MATERIAL_PURCHASE_02";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("purchaseSerialNo", purchaseSerialNo);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}		
	
	public static List<HashMap<String, Object>> select_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId,
			String fromPurchaseDate,
			String toPurchaseDate) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_CUS_MATERIAL_PURCHASE_01";
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("fromPurchaseDate", fromPurchaseDate);
		params.put("toPurchaseDate", toPurchaseDate);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}

	public static List<HashMap<String, Object>> select_02(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId, 
			String purchaseSerialNo) throws IOException {
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_CUS_MATERIAL_PURCHASE_02";
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("purchaseSerialNo", purchaseSerialNo);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}	
	
	public static List<HashMap<String, Object>> select_03(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId,
			String fromPurchaseDate,
			String toPurchaseDate,
			String vendorId) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_CUS_MATERIAL_PURCHASE_03";
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("fromPurchaseDate", fromPurchaseDate);
		params.put("toPurchaseDate", toPurchaseDate);
		params.put("vendorId", vendorId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}	
}