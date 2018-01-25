package gui;

import java.awt.Color;

/**
 * @author Thomas Arnold (arnold@aiphes.tu-darmstadt.de)
 * 29.09.2017
 */

/*
 * Used colors for the GUI
 * Separate colors for day / night color modes
 */

public class Colorpalette {

	public static Color[] colors_daylight = {Color.white, Color.black, Color.gray, new Color(200, 200, 200), new Color(100, 100, 100), Color.red, Color.blue};
	public static Color[] colors_moonlight =  {Color.black, Color.white, Color.gray, new Color(50, 50, 50), new Color(175, 175, 175), Color.red, Color.cyan};
	public static Color[][] colors = {colors_daylight, colors_moonlight};
	
	public static Color color_background;
	public static Color color_foreground;
	public static Color color_fade;
	public static Color color_textbox;
	public static Color color_context;
	public static Color color_select;
	public static Color color_bubblenames;
	
	private static int moon = 1;
	
	public static void changeColors() {
		moon = 1-moon;
		setColors();
	}
	
	public static void setColors() {
		
		Color[] myColors = colors[moon];
		
		color_background 	= myColors[0];
		color_foreground 	= myColors[1];
		color_fade 			= myColors[2];
		color_textbox 		= myColors[3];
		color_context 		= myColors[4];
		color_select 		= myColors[5];
		color_bubblenames	= myColors[6];
		
	}
	
}
