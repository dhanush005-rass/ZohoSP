package problem;

class Complexpattern {

    public static void pattern1(int num)
    {
        int c = 1; // Counter for numbers
        for (int i = 1; i < num; i++) {
            
            // Print leading spaces
            for (int j = i; j < num - 1; j++) {
                System.out.print("  ");
            }

            // Store row numbers temporarily
            int[] row = new int[num];
            for (int j = 0; j < num; j++) {
                row[j] = c++;
            }

            // Check if current row is even or odd
            if (i % 2 == 0) {
                // Even row: reverse print
                for (int j = num - 1; j >= 0; j--) {
                    System.out.print(row[j] + " ");
                }
            } else {
                // Odd row: normal print
                for (int j = 0; j < num; j++) {
                    System.out.print(row[j] + " ");
                }
            }

            System.out.println(); // Move to next row
        } System.out.println();
    }
    public static void pattern2(int r) {
        int start = r * (r - 1) / 2 + 1; // starting number for first row

        for (int i = 0; i < r; i++) {
            int n = start;
            int step = r + 1 - i;

            for (int j = 0; j <= i; j++) {
                System.out.print(n + " ");
                n += step;
                step++;
            }

            start -= (r - 1 - i); // decrease starting number for next row
            System.out.println();
        }System.out.println();
    }
    public static void pattern3(int num)
    {
    	int pri=1;
    	for(int i=num;i>=1;i--)
    	{
    		for(int j=1;j<=i;j++)
    		{
    			pri=i%2==0?1:0;
    			System.out.print(pri+" ");
    			
    		}
    		System.out.println();
    	}System.out.println();
    }
    
    public static void pattern4(int num)
    {
    	int add=0,ans=0;
    	for(int i=1;i<=num;i++)
    	{
    		add=num-1;
    		for(int j=1;j<=i;j++)
    		{
    			ans=(j==1)?i:(ans+add--);
    			System.out.print(ans+" ");
    			
    		}
    		System.out.println();
    	}System.out.println();
    }

    public static void main(String[] args) {
        pattern1(4);
        pattern2(5);
        pattern3(4);
        pattern4(6);
    }
}
