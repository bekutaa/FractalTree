import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FractalTree extends PApplet {

private double fractionLength = 0.8f;
private int smallestBranch = 8;
private double branchAngle = 0.5f;
private float bLength = 10;
private int bThick = 8;

public void setup()
{
	size(640,480);
	// frameRate(600);
//	noLoop();
}

public void draw()
{
	background(0);
	stroke(0,255,0);
	strokeWeight(bThick/0.9f);
	line(320,480,320,380);
	drawBranches(320,380,bLength,3*Math.PI/2,bThick);

	if(bLength < 100)
		bLength++;
}

public void drawBranches(float x, float y, double branchLength, double angle, int thickness)
{
	
	double angle1 = angle + branchAngle;
	double angle2 = angle - branchAngle;

	branchLength = branchLength*fractionLength;

	int drawWidth = (int)(thickness*0.9f);
	if(drawWidth < 1)
	{
		drawWidth = 1;
	}

	float endX1 = (float)(branchLength*Math.cos(angle1) + x);
	float endY1 = (float)(branchLength*Math.sin(angle1) + y);

	float endX2 = (float)(branchLength*Math.cos(angle2) + x);
	float endY2 = (float)(branchLength*Math.sin(angle2) + y);

	stroke(0,255,0);
	strokeWeight(drawWidth);
	line(x,y,endX1,endY1);
	line(x,y,endX2,endY2);

	if(branchLength > smallestBranch)
	{
		drawBranches(endX1,endY1,branchLength,angle1+branchAngle/2,drawWidth);
		drawBranches(endX2,endY2,branchLength,angle2-branchAngle/2,drawWidth);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
