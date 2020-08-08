package login;

public class Code {
	private String code;
	private String label;

	public Code(String code, String label) {
		this.code = code;
		this.label = label;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getJobCode() {
		return code;
	}

	public String getLabel() {
		return label;
	}

	public void setJobCode(String code) {
		this.code = code;
	}

}
