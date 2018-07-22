package com.ubs.opsit.berlinclock;

/**
 * Colour of Lamp
 *
 */
public enum Colour {
YELLOW("Y"),
RED("R");
	
private String colour;

Colour(String colour){
	this.colour=colour;
}

public String getColour(){
	return colour;
}
}
