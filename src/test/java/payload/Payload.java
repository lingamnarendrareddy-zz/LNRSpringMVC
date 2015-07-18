package payload;

import java.io.Serializable;

public class Payload implements Serializable{

	private String message;
	
	private String correlationId;
	
	private String host;

	public Payload(String string, String host) {
		this.message = string;
		this.host = host;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
}
