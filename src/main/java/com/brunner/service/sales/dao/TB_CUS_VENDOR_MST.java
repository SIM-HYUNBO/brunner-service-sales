package com.brunner.service.sales.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import com.brunner.service.util.LogUtil;

public class TB_CUS_VENDOR_MST {
	private static final Logger logger = Logger.getLogger(TB_CUS_VENDOR_MST.class.getName());
	
	public static int insert_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId,
			String vendorId,
			String salesType,
			String salesCategory, 
			String registerName, 
			String registerNo, 
			String address, 
			String phoneNumber,
			String useFlag
			) throws IOException {
		
 		String sqlId = "insert_TB_CUS_VENDOR_MST_01";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("vendorId", vendorId);
		params.put("salesType", salesType);
		params.put("salesCategory", salesCategory);
		params.put("registerName", registerName);
		params.put("registerNo", registerNo);
 		params.put("address", address);
		params.put("phoneNumber", phoneNumber);
		params.put("useFlag", useFlag);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	

	public static int update_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId,
			String vendorId,			
			String salesType,
			String salesCategory, 
			String registerName, 
			String registerNo, 
			String address, 
			String phoneNumber
			
			) throws IOException {
		
 		String sqlId = "update_TB_CUS_VENDOR_MST_01";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
 		params.put("salesType", salesType);
 		params.put("salesCategory", salesCategory);
		params.put("registerName", registerName);
		params.put("registerNo", registerNo);
		params.put("address", address);
		params.put("phoneNumber", phoneNumber);
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("vendorId", vendorId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	
	
	public static int update_02(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId,
			String vendorId
			) throws IOException {
		
 		String sqlId = "update_TB_CUS_VENDOR_MST_02";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("vendorId", vendorId);

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
 		String sqlId = "select_TB_CUS_VENDOR_MST_01";
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
			String vendorId) throws IOException{
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_CUS_VENDOR_MST_02";
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("vendorId", vendorId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}	
}