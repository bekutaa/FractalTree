private double fractionLength = 0.8;
private int smallestBranch = 8;
private double branchAngle = 0.5;
private float bLength = 10;
private int bThick = 8;

public void setup()
{
	size(640,480);
}

public void draw()
{
	background(0);
	stroke(0,255,0);
	strokeWeight(bThick/0.9);
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

	int drawWidth = (int)(thickness*0.9);
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
