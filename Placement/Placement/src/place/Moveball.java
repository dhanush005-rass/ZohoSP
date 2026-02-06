package place;

class Moveball {
	private static int[][]mat;
	public  Moveball(int r,int c,int pos)
	{
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++)
			{
				mat[i][j]=0;
			}
		}
		mat[r][r-1]=1;
	}
}
