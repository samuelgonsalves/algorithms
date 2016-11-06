public class Recursive
{
	int m[][];
	int p[];
	int s[][];
	int basicOps = 0;
	int n;
	int numberOfRecursiveCalls = 0;
	
	Recursive(int p[])
	{
		this.p = p;
		this.n = p.length - 1;
		m = new int[n+1][n+1];
		s = new int [n+1][n+1];
		numberOfRecursiveCalls++; // For initial recursive call	
		final long startTime = System.nanoTime();
		System.out.println("Minimum number of multiplications:"+recursiveMatrixChain(p, 1, n));
		final long duration = System.nanoTime() - startTime;
		System.out.println("Duration:"+duration/1000000.0);
		print();
	}
	public int recursiveMatrixChain(int p[],int i,int j)
	{
		numberOfRecursiveCalls++;
		if(i == j)
		{
			return 0;
		}
		m[i][j]=Integer.MAX_VALUE;
		for(int k = i ; k < j ; k++)
		{
			int q = recursiveMatrixChain(p, i, k) + recursiveMatrixChain(p, k+1, j) + p[i-1]*p[k]*p[j];
			if(q < m[i][j])
			{
				m[i][j] = q;
			}
			basicOps++;
		}
		return m[i][j];	
	}
	public void print()
	{
		
		
		System.out.println("Number of basic ops: "+basicOps);
		System.out.println("numberOfRecursiveCalls: "+numberOfRecursiveCalls);
		
	}

	public static void main(String[] args)
	{
		int p[] = {1,2,3,4,3,6,8,3,9,10,7,1,2,3,4,3,6,8};
		Recursive recObj = new Recursive(p);
	}
}
