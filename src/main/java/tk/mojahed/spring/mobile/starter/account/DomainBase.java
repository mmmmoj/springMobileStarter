package tk.mojahed.spring.mobile.starter.account;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class DomainBase implements Serializable {

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}