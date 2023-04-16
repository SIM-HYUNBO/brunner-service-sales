package com.brunner.service.sales.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import com.brunner.service.util.LogUtil;

public class TB_CUS_PRODUCT_MST {
	private static final Logger logger = Logger.getLogger(TB_CUS_PRODUCT_MST.class.getName());
	
	public static int insert_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId, 
			String productName, 
			String productUnit, 
			String productDesc, 
			String unitPrice,
			String useFlag
			) throws IOException {
		
 		String sqlId = "insert_TB_CUS_PRODUCT_MST_01";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("productName", productName);
		params.put("productUnit", productUnit);
 		params.put("productDesc", productDesc);
		params.put("unitPrice", unitPrice);
		params.put("useFlag", useFlag);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	

	public static int update_01(
			SqlSession session,
			String txnId,
			String productDesc, 
			String unitPrice,
			String userId,
			String systemCode,
			String productName, 
			String productUnit 
			
			) throws IOException {
		
 		String sqlId = "update_TB_CUS_PRODUCT_MST_01";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
 		params.put("productDesc", productDesc);
		params.put("unitPrice", unitPrice);
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("productName", productName);
		params.put("productUnit", productUnit);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	

	public static int update_02(
			SqlSession session,
			String txnId,
			String userId,
			String systemCode,
			String productName, 
			String productUnit
			) throws IOException {
		
 		String sqlId = "update_TB_CUS_PRODUCT_MST_02";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
 		params.put("userId", userId);
		params.put("systemCode", systemCode);
		params.put("productName", productName);
		params.put("productUnit", productUnit);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}		
	
	public static List<HashMap<String, Object>> select_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId) throws IOException{
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_CUS_PRODUCT_MST_01";
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}

	public static List<HashMap<String, Object>> select_02(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId, 
			String productName, 
			String productUnit) throws IOException {
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_CUS_PRODUCT_MST_02";
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("productName", productName);
		params.put("productUnit", productUnit);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}	
}