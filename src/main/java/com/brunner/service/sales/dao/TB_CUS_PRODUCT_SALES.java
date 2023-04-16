package com.brunner.service.sales.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import com.brunner.service.util.LogUtil;

public class TB_CUS_PRODUCT_SALES {
	private static final Logger logger = Logger.getLogger(TB_CUS_PRODUCT_SALES.class.getName());
	
	public static int insert_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId,
			String salesSerialNo,
			String salesDate,
			String customerId, 
			String productName, 
			String productUnit, 
			int unitPrice,
			float salesCount,
			float salesAmount,
			float receivedAmount,
			String salesComment
			) throws IOException {
		
 		String sqlId = "insert_TB_CUS_PRODUCT_SALES_01";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("salesDate", salesDate);
		params.put("salesSerialNo", userId);
		params.put("customerId", customerId);
		params.put("productName", productName);
		params.put("productUnit", productUnit);
 		params.put("unitPrice", unitPrice);
		params.put("salesCount", salesCount);
		params.put("salesAmount", salesAmount);
		params.put("receivedAmount", receivedAmount);
		params.put("salesComment", salesComment);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	

	public static int update_01(
			SqlSession session,
			String txnId,
			String systemCode,
			String userId,
			String salesSerialNo,
			float salesCount,
			float salesAmount,
			float receivedAmout,
			String salesComment
			) throws IOException {
		
 		String sqlId = "update_TB_CUS_PRODUCT_SALES_01";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
 		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("salesSerialNo", salesSerialNo);
		params.put("salesCount", salesCount);
		params.put("salesAmount", salesAmount);
		params.put("receivedAmount", receivedAmout);
		params.put("salesComment", salesComment);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	

	public static int update_02(
			SqlSession session,
			String txnId,
			String systemCode,
			String userId, 
			String salesSerialNo
			) throws IOException {
		
 		String sqlId = "update_TB_CUS_PRODUCT_SALES_02";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("salesSerialNo", salesSerialNo);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}		
	
	public static List<HashMap<String, Object>> select_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId,
			String fromSalesDate,
			String toSalesDate) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_CUS_PRODUCT_SALES_01";
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("fromSalesDate", fromSalesDate);
		params.put("toSalesDate", toSalesDate);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}

	public static List<HashMap<String, Object>> select_02(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId, 
			String salesSerialNo) throws IOException {
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_CUS_PRODUCT_SALES_02";
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("salesSerialNo", salesSerialNo);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}	
	
	public static List<HashMap<String, Object>> select_03(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId,
			String fromSalesDate,
			String toSalesDate,
			String customerId) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_CUS_PRODUCT_SALES_03";
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("fromSalesDate", fromSalesDate);
		params.put("toSalesDate", toSalesDate);
		params.put("customerId", customerId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}	
}