package pieces;

public class Position {

	protected int i;
	protected int j;
	
	public Position()
	{
		
	}
	public Position(int i,int j)
	{
		this.i = i; 
		this.j = j;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
	public boolean isEqual(Position p)
	{
		boolean isOk = false;
		if((this.i == p.getI()) && (this.j == p.getJ()))
			isOk = true;
		return isOk;
	}
}
