package org.kosta.myproject.model.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Authorities implements Serializable{
	private static final long serialVersionUID = -5726348539928823908L;
	private String id;
	private String authority;
}
