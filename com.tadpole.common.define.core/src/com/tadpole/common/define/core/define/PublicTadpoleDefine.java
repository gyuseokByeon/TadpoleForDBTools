/*******************************************************************************
 * Copyright (c) 2013 hangum.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     hangum - initial API and implementation
 ******************************************************************************/
package com.tadpole.common.define.core.define;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 전역 변수 정의 
 * 
 * @author hangum
 *
 */
public class PublicTadpoleDefine {
	/** URL system version information */
	public static final String URL_SYSTEM_VERION = String.format("?%s%s=%s", SystemDefine.DBHUB_MAJOR_VERSION, SystemDefine.DBHUB_SUB_VERSION, SystemDefine.DBHUB_RELEASE_DATE);
	
	/** product type */
	public static enum PRODUCT_TYPE {TadpoleDBHub, TadpoleHistoryHub, TadpoleAPIHub, TadpoleJobHub};
	public static PRODUCT_TYPE ACTIVE_PRODUCT_TYPE = PRODUCT_TYPE.TadpoleDBHub;
	
	/** default search count */
	public static final int INT_SEARCH_COUNT = 200;
	
	/** set user info */
	public static String CERT_USER_INFO = "";
	
	/** define default time zone*/
	public static final String DEFAULT_TIME_ZONE = "Asia/Seoul";
	
	/** default log file name*/
	public static String DEFAULT_LOG_FILE 		= String.format("./logs/%s.log", ACTIVE_PRODUCT_TYPE.name());
	public static String DEFAULT_VELOCITY_LOG_FILE = String.format("./logs/%sVelocity.log", ACTIVE_PRODUCT_TYPE.name());
	
	/** DEFAULT MASK PATTERN 
	 * STARTUP -INITIALIZE
	 * */
	public static String DEFAULT_MASK_PATTERN = "";
	
	/** 감사로그에 sql 저장할때 헤더 */
	public static final String TDB_SQL_HEAD = "/*TDB SQL=";
	
	/**
	 * 환경 정보 파일
	 */
	public static final String TDB_CONFIG_FILE = "tadpole_interface.properties";
	
	/**
	 * Define gateway db list key
	 */
	public static final String GATEWAY_DB_LIST = "GATEWAY_DB_LIST";
	
	/** cookie path */
	public static String _cookiePath = "/";
	
	public static final int systemAdminId = -1;
	
	/** Default resource name */
	public static final String DEFAUL_RESOURCE_NAME = "_TDB_DEF_NAME_";
	
	/** 이벤트 타입 
	 *  상세 사유는 {#TadpoleEventReadon} 
	 */
	public static enum TDB_EVENT_TYPE {ADMIN, USER, DB};
		
		
	/** filter type */
	public static enum FILTER_TYPE {INCLUDE, EXCLUDE};
	
	/** mail type */
	public static enum MAIL_TYPE {NONE, SEND_GRID, SMTP};

	/** 시스템 사용 그룹 정의 */
	public static enum SYSTEM_USE_GROUP {PERSONAL, GROUP}  
	
	/** 디비 연결시 엑션 */
	public static enum DB_CONNECTION_ASK {NO, PASSWORD, OTP, PASSWORD_OTP};
	
	/** 사용자 쿼리를 프리페어 스테이트 먼트로 처리하는 파라미터 타입 */
	public static enum PARAMETER_TYPE {JAVA_BASIC, ORACLE, MYBATIS_SHARP, MYBATIS_DOLLAR};
	
	/** 사용자 디비의 권한 메시지 정의 */
	public static enum AUTH_CODE_DEFINE {VALID, TIME_EXPIRE, AUTH_EXPIRE};

	/** rest api service key */
	public static final String SERVICE_KEY_NAME = "serviceID";
	
	/** default system encrypt password */
	public static final String SYSTEM_DEFAULT_USER = "hangum@tadpolehub.com";
	public static final String SYSTEM_DEFAULT_PASSWORD = "startService.tdb.son";
	
	/** COOKIE USER ID */
	public static final String TDB_COOKIE_UPDATE_CHECK = "TDB_COOKIE_UPDATE_CHECK";
	public static final String TDB_COOKIE_USER_ID = "TDB_USER_ID";
	public static final String TDB_COOKIE_USER_PWD = "TDB_USER_PWD";
	public static final String TDB_COOKIE_USER_SAVE_CKECK = "TDB_USER_SAVE_CHECK";
	public static final String TDB_COOKIE_USER_LANGUAGE = "TDB_USER_LANGUAGE";
	public static final String TDB_COOKIE_USER_IP = "TDB_USER_IP";

	/**
	 * PLAN Statement ID
	 */
	public static final String STATEMENT_ID = "||TDB_STMT_ID||"; //$NON-NLS-1$

	/** 0번째 테이블 컬럼을 선택한다 */
	public static final String DEFINE_TABLE_COLUMN_BASE_ZERO = "TDB_BASE_ZERO";
	public static final String DEFINE_TABLE_COLUMN_BASE_ZERO_TYPE = "TDB_BASE_TYPE";
	
	/**
	 * 특별 컬럼을 정의 합니다. 
	 */
	public static final String SPECIAL_USER_DEFINE_HIDE_COLUMN = "TDB_HIDE";
	
	/**
	 * 분리자
	 */
	public static final String DELIMITER = "||_D_||"; //$NON-NLS-1$
	public static final String DELIMITER_DBL = "||_D_D_||"; //$NON-NLS-1$
	
	/** 라인분리자 */
	public static final String LINE_SEPARATOR = "\n";//System.getProperty("line.separator"); //$NON-NLS-1$
	public static final String DOUBLE_LINE_SEPARATOR = LINE_SEPARATOR + LINE_SEPARATOR;
	
	/** DIR SEPARATOR */
	public static final char DIR_SEPARATOR = File.separatorChar;
	
	/** temp dir 
		임시 디렉토리 생성에 오류 있음. 확인 필요.
		java.io.IOException: Directory '/tmpTempTable1458208430419' could not be created 오류 발생.
		환경 설정에 문제인지(prefix 혹은 디렉토리 미지정).. 아니면 코드상의 오류(DIRECTORY-SEPERATOR 가 빠진 문제)인지 확인 필요
	*/
	public static final String TEMP_DIR = System.getProperty("java.io.tmpdir") + PublicTadpoleDefine.DIR_SEPARATOR;

	/**  쿼리 구분자 */
	public static final String SQL_DELIMITER = ";"; //$NON-NLS-1$
	
	/** tadpole default port */
	public static final String TADPOLE_DEFAULT_PORT = "10081";
	
	/** tadpole url */
	public static final String TADPOLE_URL = "http://127.0.0.1:%s";
	
	/**
	 * tadpole url
	 * 
	 * @return
	 */
	public static String getTadpoleUrl() {
		String tadpolePort = System.getProperty("org.osgi.service.http.port", TADPOLE_DEFAULT_PORT); //$NON-NLS-1$ //$NON-NLS-2$
		return String.format(TADPOLE_URL, tadpolePort);
	}
	
	/** 외부 계정으로 올챙이가 접속 할때의 외부 계정 리스트. 현재는 external_account 의 type에 사용. */
	public enum EXTERNAL_ACCOUNT {AMAZONRDS, DBSAFER};
	
	/** user login type */
	public static enum LOGIN_INPUT_TYPE {NORMAL, LDAP};
	
	/** otp 사용시 otp type
	    ##  DEFAULT (APP에 확인 코드를 날려준다.) 
	 	##  APP_VERIFICATION(앱에서 확인을 누르면 다음으로 넘어간다.)
	 */
	public static enum OTP_METHOD {DEFAULT, APP_VERIFICATION};
	
	/** yes, no */
	public static enum YES_NO {YES, NO}; 
	
	/** Success, Fail */
	public static enum SUCCESS_FAIL {S, F};
	
	/** change resource save */
	public static final String SAVE_FILE = "CHANGE_TADPOLE_RESOURE"; //$NON-NLS-1$
	
	/** erd - select table */
	public static final String SELECT_ERD_TABLE = "SELECT_ERD_TABLE_RESOURE"; //$NON-NLS-1$
	
//	/** auto commit 사용여부를 가립니다. */
//	public static final String AUTOCOMMIT_USE = "_AUTOCOMMIT_USE"; //$NON-NLS-1$
	
	/** Tadpole support browser list  */
	public static enum TADPOLE_SUPPORT_BROWSER {EDGE, FIREFOX, CHROME, SAFARI, IE, OPERA};
	
	/** Tadpole support browser list  */
	public static enum TADPOLE_SUPPORT_BROWSERIP {FIREFOX, CHROME, OPERA};
	
	/** 테드폴 사용자 역활 타입을 지정합니다 */
	public enum USER_ROLE_TYPE {SYSTEM_ADMIN, OBSERVER, DBA, USER, API_USER};
	
	/** 
	 * This variable is user_role_table. 
	 */
	public static enum DB_USER_ROLE_TYPE {SYSTEM_ADMIN, ADMIN, DBA, MANAGER, USER, GUEST};
	
	/**
	 * column masking type
	 */
	public static enum MASKING_COLUMN_TYPE {SCHEMA, TABLE, COLUMN};
	
//	/**
//	 * Setting SQL Client Info
//	 * @return
//	 */
//	public static Properties getSQLClientInfo() {
//		Properties prop = new Properties();
//		prop.setProperty("ApplicationName", String.format("%s %s %s", SystemDefine.NAME, SystemDefine.MAJOR_VERSION, SystemDefine.RELEASE_DATE));
////		prop.setProperty("ClientUser", 		RWT.getRequest().getRemoteHost());
////		prop.setProperty("ClientHostname", 	RWT.getRequest().getLocalAddr());
//		
//		return prop;
//	}
	
	/**
	 * ace editor theme list
		https://docs.c9.io/docs/syntax-highlighting-themes
	*/
	private static Map<String, String> mapTheme = new HashMap<String, String>();
	public static Map<String, String> getMapTheme() {
		if(mapTheme.isEmpty()) {
			mapTheme.put("Chrome", 			"chrome");
			mapTheme.put("Clouds", 			"clouds");
			mapTheme.put("Clouds Midnight", "clouds_midnight");
			mapTheme.put("Cobalt", 			"cobalt");
			mapTheme.put("Crimson Editor", 	"crimson_editor");
			mapTheme.put("Dawn", 			"dawn");
			mapTheme.put("Eclipse", 		"eclipse");
			mapTheme.put("Idle Fingers", 	"idle_fingers");
			mapTheme.put("Kr Theme", 		"kr_theme");
			mapTheme.put("Merbivore", 		"merbivore");
			mapTheme.put("Merbivore Soft", 	"merbivore_soft");
			mapTheme.put("Mono Industrial", "mono_industrial");
			mapTheme.put("Monokai", 		"monokai");
			mapTheme.put("Pastel On Dark", 	"pastel_on_dark");
			mapTheme.put("Solarized Dark", 	"solarized_dark");
			mapTheme.put("Solarized Light", "solarized_light");
			mapTheme.put("TextMate", 		"textmate");
			mapTheme.put("Tomorrow", 		"tomorrow");
			mapTheme.put("Tomorrow Night", 	"tomorrow_night");
			mapTheme.put("Tomorrow Night Blue", 	"tomorrow_night_blue");
			mapTheme.put("Tomorrow Night Bright", 	"tomorrow_night_bright");
			mapTheme.put("Tomorrow Night Eighties", "tomorrow_night_eighties");
			mapTheme.put("Twilight", 				"twilight");
			mapTheme.put("Vibrant Inkv", 			"vibrant_inkv");
		}
		return mapTheme;
	}
	
	/**
	 * db operation type
	 * 
	 * @author hangum
	 *
	 */
	public enum DBOperationType {
		PRODUCTION("Production Server"),
		DR("Disaster Recovery"), 
		DEVELOP("Development Server"), 
		TEST("Test Server"),
		BACKUP("Backup Server"),
		OTHERS("Others");

		private String typeName;
		
		private DBOperationType(String typeName) {
			this.typeName = typeName;
		}
		
		public String getTypeName() {
			return typeName;
		}
		
		public static DBOperationType getNameToType(String name) {
			if(PRODUCTION.typeName.equals(name)) 	return PRODUCTION;
			else if(DR.typeName.equals(name)) 	return DR;
			else if(DEVELOP.typeName.equals(name)) 	return DEVELOP;
			else if(TEST.typeName.equals(name)) 	return TEST;
			else if(BACKUP.typeName.equals(name)) 	return BACKUP;
			else return OTHERS;
		}
	};
	
	/** 에디터 결과를 오픈하는 뷰 타입을 정의 */
	public static enum RESULT_COMP_TYPE {Table, Text, TextJSON, TABLEJSON};
	
	/** 내보내기 종류 정의 (배포탭에서 변수로 사용 하여서 수정시 주의 요망) */
	public static enum EXPORT_METHOD {TEXT, EXCEL, HTML, JSON, XML, SQL};
	
	/** CSV export 시 기본 값 */
	public static String CSV_EXPORT_DEFAULT_VALUE = ",";//"	";
	
	/** 에디터를 열때 오픈하는 타입을 적습니다. */
	public static enum EDITOR_OPEN_TYPE {NONE, STRING, FILE};
	
	/** save resource type */
	public static enum RESOURCE_TYPE {ERD, SQL, AUTO_SQL, OBJECT};
	
	/** define SQL, ERD shared type */
	public static enum SHARED_TYPE {PUBLIC, PRIVATE};
	
	/** executed sql type */
	public static enum SQL_STATEMENT_TYPE {NONE, PREPARED_STATEMENT};
	
	/** 
	 * executed sql history type - 이름을 정할때 10자가 넘지 않아야한다.
	 * 
	 *  EDITOR 		: 에디터에서 실행
	 *  EDIT_DOWN 	: 쿼리 다운로드에서
	 *  API_PROGRAM : API Hub에서 실행
	 *  API_USER 	: SHARED HUB 에서 실행
	 *  REQ_QUERY 	: 사용자 요청 쿼리(예를 들어 사용자 결제를 받아 실행한 쿼리)
	 *  HISTORY_HUB : 히스토리 허브에서 요청한 쿼리 
	 */
	public static enum EXECUTE_SQL_TYPE {EDITOR, EDIT_DOWN, API, API_USER, REQ_QUERY, HISTORYHUB};

	/** 데이터 수정 상태를 가르킵니다 */
	public static enum DATA_STATUS {NEW, MODIFY, DEL};
	
	/** 기본 상태 정의 */
	public static enum BASIC_STATUS {NONE, START, DONE};

	/** objec explorer에서 정의한 action */
	public static enum OBJECT_TYPE {
		TABLES, 
		VIEWS, 
		SYNONYM,
		SEQUENCE,
		LINK,
		INDEXES, 
		CONSTRAINTS,
		PROCEDURES,
		PROCEDURE_PARAMETER,
		FUNCTIONS, 
		TRIGGERS,
		COLLECTIONS,
		JAVASCRIPT,
		PACKAGES,
		SCHEDULE,
		COLUMNS,
		JOBS,
		JAVA,
		ELASTICSEARCH_INDEX
	};

	/** sql type - http://www.orafaq.com/faq/what_are_the_difference_between_ddl_dml_and_dcl_commands */
	public static enum SQL_TYPE {DDL, DML, DCL, TCL};//, DCL, UNKNOWN};

	/** query type */
	public static enum QUERY_DML_TYPE {SELECT, EXPLAIN_PLAN, INSERT, UPDATE, DELETE, UNKNOWN};
	
	/** 쿼리 결과 보기 타입 */
	public static enum QUERY_PALN_RESULT_TYPE {TABLE, /*JSON_TEXT,*/ JSON_TREE};
	
	/** History hub dml type */
	public static enum HISTORY_DML_TYPE {INSERT, UPDATE, DELETE};
	
	/** query ddl type */
	public static enum QUERY_DDL_STATUS {CREATE, ALTER, DROP, TRUNCATE, UNKNOWN};
	public static enum QUERY_DDL_TYPE 	{TABLE, VIEW, SEQUENCE, INDEX, PROCEDURE, FUNCTION, TRIGGER, PACKAGE, SYNONYM, LINK, JOBS, JAVA, UNKNOWN};
	public static enum ACCEAS_CTL_DDL_TYPE {SCHEMA, TABLEoVIEW, FUNCTION, PROCEDURE};
	public static String[] DB_PRIMARY_KEY = {
											"PRI", 
											"PK", 
											"PRIMARY", 
											"PRIMARY KEY",	// pgsql
											};
	
	public static String[] DB_FOREIGN_KEY = {
											"FK", 
											"FOREIGN KEY",	// pgsql
											};
	
	public static String[] DB_MULTI_KEY = {
											"MUL",
											"PRIMARY KEY,FOREIGN KEY"	// pgsql
										};

	/**
	 * is primary key
	 * @param key
	 * @return
	 */
	public static boolean isPK(String key) {
		for(String searchKey : DB_PRIMARY_KEY) {
			if(searchKey.equalsIgnoreCase(key)) return true;
		}
		
		return false;
	}
	
	/**
	 * is foreign key
	 * @param key
	 * @return
	 */
	public static boolean isFK(String key) {
		for(String searchKey : DB_FOREIGN_KEY) {
			if(searchKey.equalsIgnoreCase(key)) return true;
		}
		
		return false;
	}
	
	/**
	 * is multi key
	 * @param key
	 * @return
	 */
	public static boolean isMUL(String key) {
		for(String searchKey : DB_MULTI_KEY) {
			if(searchKey.equalsIgnoreCase(key)) return true;
		}
		
		return false;
	}
	/**
	 * is key
	 * @param key
	 * @return
	 */
	public static boolean isKEY(String key) {
		return isKEY(key, YES_NO.NO.name());
	}
	public static boolean isKEY(String key, String isNull) {
		boolean isReturn = true;

		// 컬럼이 null허용이면 false
		if(isPK(key)) if("YES".equals(isNull)) return false; //$NON-NLS-1$
		if(isFK(key)) if("YES".equals(isNull)) return false; //$NON-NLS-1$
		if(isMUL(key)) if("YES".equals(isNull)) return false; //$NON-NLS-1$
		
		return isReturn;
	}
}