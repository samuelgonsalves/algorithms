public class DP
{
	int m[][];
	int s[][];
	int n;
	int basicOps =0;
	public void matrixChainOrder(int[] p)
	{
		n=p.length-1;
		m=new int[n+1][n+1];
		s=new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			m[i][i] = 0;
		}
		for(int l=2;l <= n;l++)
		{
			for(int i=1;i<=n-l+1;i++)
			{
				int j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;
					for(int k=i;k<j;k++)
					{
						int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
						if(q < m[i][j])
						{
							m[i][j] = q;
							s[i][j] = k;
						}
						basicOps++;
					}
					
			}
		}
		System.out.println("Minimum number of multiplications:"+m[1][n]);
		System.out.println("Number of basic ops:"+basicOps);
	}

	public static void main (String[] args) 
	{
		
		DP dpObj=new DP();
		
		final double startTime = System.nanoTime();
		
		int[] p={1,2,3,4,3,6,8,3,9,10,7,1,2,3,4,3,6,8};
	
		dpObj.matrixChainOrder(p);
		final double duration = System.nanoTime() - startTime;
		System.out.println("Duration:"+duration/1000000.0);
	}
}

