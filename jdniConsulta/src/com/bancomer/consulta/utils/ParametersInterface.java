package com.bancomer.consulta.utils;

public interface ParametersInterface {

	// Commands para PRM_CMD
	public static final int CMD_MAIN = 0;
	public static final int CMD_OPEN_INBOX = 1;
	public static final int CMD_INIT_CASE = 2;
	public static final int CMD_EXEC_CASE = 3;
	public static final int CMD_ADVANCE_CASE = 4;
	public static final int CMD_XML_SAVE = 5;
	public static final int CMD_MSG_COMPOSE = 6;
	public static final int CMD_SEND_MSG = 7;
	public static final int CMD_MSG_SENDED = 8;
	public static final int CMD_MSG_RECIVED = 9;
	public static final int CMD_MSG_READED = 10;
	public static final int CMD_SEND_CHNG_PWD = 11;
	public static final int CMD_CHNG_PWD = 12;
	public static final int CMD_GET_USRES_GROUPS = 13;
	public static final int CMD_GET_BODY_MSG = 14;
	public static final int CMD_DEL_MSG = 15;
	public static final int CMD_GET_USRES_GROUPS_OPER = 16;
	public static final int CMD_GENERIC_INTERFACE = 17;
	public static final int CMD_CANCEL_LEAVE = 18;
	public static final int CMD_UP_BLOQ_USER = 20;
	public static final int CMD_EXIT = 99;

	// Session's Attributes
	public static final String ATT_USER = "usuario";
	public static final String ATT_INBOX = "inbox";
	public static final String ATT_CASE = "caso";
	public static final String ATT_MSG = "msg";
	public static final String ATT_TREE = "tree.model";
	public static final String ATT_NOXML= "noxml";
	public static final String ATT_PRIMERA= "primeravez";

	// Parameters
	public static final String PRM_CMD = "cmd";
	public static final String PRM_CASE = "caso";
	public static final String PRM_CASE_OPER = "casoOper";
	public static final String PRM_RESP = "responsable";
	public static final String PRM_OPER = "operacion";
	public static final String PRM_USER_MSG = "usrmsg";
	public static final String PRM_PROM_FILTER = "prmfltr";
	public static final String PRM_MSG_TYPE = "type";
	public static final String PRM_OBSERV = "observ";
	//RMN
	public static final String P7M_DATA = "p7m_data";

}
