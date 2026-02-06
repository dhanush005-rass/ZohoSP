package pattern;

class pattern {

	private static void patternA(int n)
	{
		int prinval=1;
		for(int row=1;row<=n;row++)
		{
			prinval = row%2==0?0:1;
			for(int col=1;col<=row;col++)
			{
				System.out.print(prinval+ " ");
				prinval= prinval==1?0:1;
			}
			System.out.println();
		}System.out.println();
	}
	
	private static void patternB(int n)
	{
		int prinval=1;
		for(int row=1;row<=n;row++)
		{
			for(int col=1;col<=row;col++)
			{
				System.out.print(prinval++ +" ");
			}
			System.out.println();
		}System.out.println();
	}
	
	private static void patternC(int n)
	{
		for(int row=1;row<=n;row++)
		{
			for(int col=1;col<=(n-row+1);col++)
			{
				System.out.print((n-row+1) +" ");
			}
			System.out.println();
		}System.out.println();
	}
	
	private static void patternD(int n)
	{
		for(int row=1;row<=n;row++)
		{
			for(int col=1;col<=(n-row+1);col++)
			{
				System.out.print(col +" ");
			}
			System.out.println();
		}System.out.println();
	}
	
	private static void patternE(int n)
	{
		for(int row=1;row<=(n*2)-1;row++)
		{
			int rowchange=row>n? (n*2)-row:row;
			for(int col=1;col<=rowchange;col++)
			{
				System.out.print("*" +" ");
			}
			System.out.println();
		}System.out.println();
		
	}
	
	private static void patternF(int n)
	{
		for(int row=1;row<=n;row++)
		{
			for(int col=1;col<=n-row;col++)
			{
				System.out.print(" " +" ");
			}
			for (int col = n - row + 1; col <= n; col++)
			{
	            System.out.print(col + " ");
	        }
			System.out.print("0"+ " ");
			for(int col=1;col<=row;col++)
			{
				System.out.print((n-col+1)+" ");
			}
			System.out.println();
			
		}System.out.println();
		
	}
	
	private static void patternG(int n)
	{
		for(int row=1;row<=n;row++)
		{
			for(int col=1;col<=row-1;col++)
			{
				System.out.print(" " +" ");
			}
			for(int col=1;col<=(n-row+1);col++)
			{
				System.out.print("* ");
			}
			System.out.println();
			
		}System.out.println();
		
	}
	
	private static void patternH(int n) {
	    // Upper half of the diamond
	    for (int row = 1; row <= n; row++) {
	        // Print leading spaces
	        for (int col = row; col < n; col++) {
	            System.out.print("  ");
	        }
	        // Print t characters
	        for (int col = 1; col <= (2 * row - 1); col++) {
	            System.out.print("t ");
	        }
	        System.out.println();
	    }

	    // Lower half of the diamond
	    for (int row = n - 1; row >= 1; row--) {
	        // Print leading spaces
	        for (int col = n; col > row; col--) {
	            System.out.print("  ");
	        }
	        // Print t characters
	        for (int col = 1; col <= (2 * row - 1); col++) {
	            System.out.print("t ");
	        }
	        System.out.println();
	    }System.out.println();
	}
	
	private static void patternI(int n) {
		for (int row = n ; row >= 1; row--) {
	        // Print leading spaces
	        for (int col = n; col > row; col--) {
	            System.out.print("  ");
	        }
	        // Print t characters
	        for (int col = 1; col <= row; col++) {
	            System.out.print("t   ");
	        }
	        System.out.println();
	    }
		for (int row = 1; row <= n; row++) {
	        // Print leading spaces
	        for (int col = row; col < n; col++) {
	            System.out.print("  ");
	        }
	        // Print t characters
	        for (int col = 1; col <= row; col++) {
	            System.out.print("t   ");
	        }
	        System.out.println();
	    }System.out.println();
	    
	}
	
	private static void patternJ(int n)
	{
		for(int row=1;row<=n;row++)
		{
			for(int col=1;col<=n-row;col++)
			{
				System.out.print("  ");
			}
			for(int col=1;col<=(row*2)-1;col++)
			{
				if(row==n)
				{
					System.out.print("t ");
				}
				else
				{
					if(col==1||col==(row*2)-1)
					{
						System.out.print("t ");
					}
					else
					{
						System.out.print("  ");
					}
				}
			}
			System.out.println();
		}System.out.println();
	}
	
	private static void patternK(int n) {
	    int totalRows = n * 2;

	    for (int row = 1; row <= totalRows; row++) {
	        int stars = (row <= n) ? n - row + 1 : row - n;
	        int spaces = totalRows - 2 * stars;

	        // Print left stars
	        for (int i = 1; i <= stars; i++) {
	            System.out.print("* ");
	        }

	        // Print spaces
	        for (int i = 1; i <= spaces; i++) {
	            System.out.print("  ");
	        }

	        // Print right stars
	        for (int i = 1; i <= stars; i++) {
	            System.out.print("* ");
	        }

	        System.out.println();
	    }System.out.println();
	}
	
	private static void patternL(int n)
	{
		int size = 2 * n - 1;

	    for (int i = 1; i <= size; i++) {
	        for (int j = 1; j <= size; j++) {
	            // Adjust distances due to 1-based indexing
	            int top = i - 1;
	            int left = j - 1;
	            int bottom = size - i;
	            int right = size - j;

	            int min = Math.min(Math.min(top, bottom), Math.min(left, right));
	            System.out.print((n - min) + " ");
	        }
	        System.out.println();
	    }System.out.println();
	}
	
	private static void patternM(int n)
	{
		int size = 2 * n - 1;

	    for (int i = 1; i <= size; i++) {
	        for (int j = 1; j <= size; j++) {
	            // Adjust distances due to 1-based indexing
	            int top = i - 1;
	            int left = j - 1;
	            int bottom = size - i;
	            int right = size - j;

	            int min = Math.min(Math.min(top, bottom), Math.min(left, right));
	            System.out.print((min +1) + " ");
	        }
	        System.out.println();
	    }System.out.println();
	}


	public static void main(String [] args)
	{
		patternA(5);
		patternB(5);
		patternC(5);
		patternD(5);
		patternE(5);
		patternF(5);
		patternG(5);
		patternH(5);
		patternI(5);
		patternJ(5);
		patternK(5);
		patternL(5);
		patternM(5);
	}

}
