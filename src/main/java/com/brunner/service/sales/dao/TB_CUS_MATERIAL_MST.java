package com.brunner.service.sales.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import com.brunner.service.util.LogUtil;

public class TB_CUS_MATERIAL_MST {
	private static final Logger logger = Logger.getLogger(TB_CUS_MATERIAL_MST.class.getName());
	
	public static int insert_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId, 
			String materialName, 
			String materialUnit, 
			String materialDesc, 
			String unitPrice,
			String useFlag
			) throws IOException {
		
 		String sqlId = "insert_TB_CUS_MATERIAL_MST_01";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("materialName", materialName);
		params.put("materialUnit", materialUnit);
 		params.put("materialDesc", materialDesc);
		params.put("unitPrice", unitPrice);
		params.put("useFlag", useFlag);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	

	public static int update_01(
			SqlSession session,
			String txnId,
			String materialDesc, 
			String unitPrice,
			String userId,
			String systemCode,
			String materialName, 
			String materialUnit 
			
			) throws IOException {
		
 		String sqlId = "update_TB_CUS_MATERIAL_MST_01";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
 		params.put("materialDesc", materialDesc);
		params.put("unitPrice", unitPrice);
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("materialName", materialName);
		params.put("materialUnit", materialUnit);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	

	public static int update_02(
			SqlSession session,
			String txnId,
			String userId,
			String systemCode,
			String materialName, 
			String materialUnit
			) throws IOException {
		
 		String sqlId = "update_TB_CUS_MATERIAL_MST_02";
 		int nEffected = 0;
 		HashMap<String, Object> params = new HashMap<String, Object>();
 		params.put("userId", userId);
		params.put("systemCode", systemCode);
		params.put("materialName", materialName);
		params.put("materialUnit", materialUnit);

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
 		String sqlId = "select_TB_CUS_MATERIAL_MST_01";
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
			String materialName, 
			String materialUnit) throws IOException {
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_CUS_MATERIAL_MST_02";
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("materialName", materialName);
		params.put("materialUnit", materialUnit);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}	
}