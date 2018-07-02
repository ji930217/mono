package ein.mono.profil.model.vo;

import java.util.Date;

public class ProfilVo { // 업체(임시)

	private String ptnCode;
	private String ptnOwner;
	private Date ptnBirth;
	private String ptnApp;
	private String ptnLicense;
	private String ptnLogo;
	private String ptnLocation;
	private String ptnStyles;
	private Long ptnIntro;
	
	private String weekdaysStart;
	private String weekdaysEnd;
	private String weekendStart;
	private String weekendEnd;
	
	public ProfilVo() {}

	public ProfilVo(String ptnCode, String ptnOwner, Date ptnBirth, String ptnApp, String ptnLicense, String ptnLogo,
			String ptnLocation, String ptnStyles, Long ptnIntro, String weekdaysStart, String weekdaysEnd,
			String weekendStart, String weekendEnd) {
		super();
		this.ptnCode = ptnCode;
		this.ptnOwner = ptnOwner;
		this.ptnBirth = ptnBirth;
		this.ptnApp = ptnApp;
		this.ptnLicense = ptnLicense;
		this.ptnLogo = ptnLogo;
		this.ptnLocation = ptnLocation;
		this.ptnStyles = ptnStyles;
		this.ptnIntro = ptnIntro;
		this.weekdaysStart = weekdaysStart;
		this.weekdaysEnd = weekdaysEnd;
		this.weekendStart = weekendStart;
		this.weekendEnd = weekendEnd;
	}

	public String getPtnCode() {
		return ptnCode;
	}

	public void setPtnCode(String ptnCode) {
		this.ptnCode = ptnCode;
	}

	public String getPtnOwner() {
		return ptnOwner;
	}

	public void setPtnOwner(String ptnOwner) {
		this.ptnOwner = ptnOwner;
	}

	public Date getPtnBirth() {
		return ptnBirth;
	}

	public void setPtnBirth(Date ptnBirth) {
		this.ptnBirth = ptnBirth;
	}

	public String getPtnApp() {
		return ptnApp;
	}

	public void setPtnApp(String ptnApp) {
		this.ptnApp = ptnApp;
	}

	public String getPtnLicense() {
		return ptnLicense;
	}

	public void setPtnLicense(String ptnLicense) {
		this.ptnLicense = ptnLicense;
	}

	public String getPtnLogo() {
		return ptnLogo;
	}

	public void setPtnLogo(String ptnLogo) {
		this.ptnLogo = ptnLogo;
	}

	public String getPtnLocation() {
		return ptnLocation;
	}

	public void setPtnLocation(String ptnLocation) {
		this.ptnLocation = ptnLocation;
	}

	public String getPtnStyles() {
		return ptnStyles;
	}

	public void setPtnStyles(String ptnStyles) {
		this.ptnStyles = ptnStyles;
	}

	public Long getPtnIntro() {
		return ptnIntro;
	}

	public void setPtnIntro(Long ptnIntro) {
		this.ptnIntro = ptnIntro;
	}

	public String getWeekdaysStart() {
		return weekdaysStart;
	}

	public void setWeekdaysStart(String weekdaysStart) {
		this.weekdaysStart = weekdaysStart;
	}

	public String getWeekdaysEnd() {
		return weekdaysEnd;
	}

	public void setWeekdaysEnd(String weekdaysEnd) {
		this.weekdaysEnd = weekdaysEnd;
	}

	public String getWeekendStart() {
		return weekendStart;
	}

	public void setWeekendStart(String weekendStart) {
		this.weekendStart = weekendStart;
	}

	public String getWeekendEnd() {
		return weekendEnd;
	}

	public void setWeekendEnd(String weekendEnd) {
		this.weekendEnd = weekendEnd;
	}

	@Override
	public String toString() {
		return "PartnersVo [ptnCode=" + ptnCode + ", ptnOwner=" + ptnOwner + ", ptnBirth=" + ptnBirth + ", ptnApp="
				+ ptnApp + ", ptnLicense=" + ptnLicense + ", ptnLogo=" + ptnLogo + ", ptnLocation=" + ptnLocation
				+ ", ptnStyles=" + ptnStyles + ", ptnIntro=" + ptnIntro + ", weekdaysStart=" + weekdaysStart
				+ ", weekdaysEnd=" + weekdaysEnd + ", weekendStart=" + weekendStart + ", weekendEnd=" + weekendEnd
				+ "]";
	}
	
	
}
