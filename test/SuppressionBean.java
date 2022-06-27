package jb.com;


public class SuppressionBean {
	/**
	 * 抑制設備名稱
	 */
	public String suppDevice;
	/**
	 * 抑制告警類型
	 */
	public String suppAlarmType;
	/**
	 * 抑制告警類別
	 */
	public String suppAlarmCategory;
	public String suppDesc;
	public boolean isShow;
	public SuppressionBean(String suppDevice,String suppAlarmType,String suppAlarmCategory){
		this.suppDevice = suppDevice;
		this.suppAlarmType = suppAlarmType;
		this.suppAlarmCategory = suppAlarmCategory;

	}
}
