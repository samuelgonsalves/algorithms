package test1;

public class Memoized
{
	int m[][];
	int basicOps = 0;
	int numberOfRecursiveCalls = 0;
	public void memoizedMatrixChain(int p[])
	{
		int n = p.length - 1;
		m=new int[n+1][n+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=n;j++)
			{
				m[i][j] = Integer.MAX_VALUE;
			}
		}
		System.out.println("Minimum number of multiplications: "+lookupChain(p,1,n));
		print();
	}
	
	public int lookupChain(int p[],int i,int j)
	{
		numberOfRecursiveCalls++;
		if(m[i][j]<Integer.MAX_VALUE)
		{
			return m[i][j];
		}
		if(i==j)
			m[i][j]=0;
		else
			for(int k=i;k<=j-1;k++)
			{
				int q = lookupChain(p, i, k)+lookupChain(p, k+1, j) + p[i-1]*p[k]*p[j];
				if(q<m[i][j])
				{
					m[i][j]=q;
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
		Memoized memObj = new Memoized();
		
		final long startTime = System.nanoTime();
		
		memObj.memoizedMatrixChain(p);
		final long duration = System.nanoTime() - startTime;
		System.out.println("Duration:"+duration/1000000.0);
	}
}
