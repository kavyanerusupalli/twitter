package com.twitter.interview.tweetviewpath;

import java.util.Objects;

public class Path {
	
	private String n1;
	private String n2;
	private String n3;
	private int occurance;
	
	public Path(String n1,String n2,String n3) {
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}

	public String getN1() {
		return n1;
	}

	public void setN1(String n1) {
		this.n1 = n1;
	}

	public String getN2() {
		return n2;
	}

	public void setN2(String n2) {
		this.n2 = n2;
	}

	public String getN3() {
		return n3;
	}

	public void setN3(String n3) {
		this.n3 = n3;
	}

	public int getOccurance() {
		return occurance;
	}

	public void setOccurance(int occurance) {
		this.occurance = occurance;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(n1,n2,n3);
	}

}
