
public class Rectilinear {
	public static int rectilinear(int k, int l, int m, int n, int p, int q, int r, int s) {
		long start = System.currentTimeMillis();
        int areaA = (m - k) * (n - l);
        int areaB = (r - p) * (s - q);
        int totalArea = areaA + areaB;

        // check if rectangles intersect
        if (k<p || l<q) {
            int intersectionX1 = Math.max(k, p);
            int intersectionX2 = Math.min(m, r);
            int intersectionY1 = Math.max(l, q);
            int intersectionY2 = Math.min(n, s);
            int intersectionArea = (intersectionX2 - intersectionX1) * (intersectionY2 - intersectionY1);
            totalArea = totalArea - intersectionArea;
        }
        if (totalArea < 0) //it probably did a wrap-around and is greater than Integer.MAX_VALUE
        {
            return -1;
        }
        long end = System.currentTimeMillis();
        long totalTime = end - start;
        System.out.println("time taken: "+totalTime);
        return totalArea;
    }
	
	public static void main(String[] args) {
		int K = -2147483647;
		int L =   7483647; 

		int M = 2140000007;
				 
				int N =  1147483647;
				int P = -147483646;
				int Q = -147483646;

				int R =   1447483647;
				int S = 9483647;
				 

		//int K = -4;int  L = 1;int  M = 2;int  N = 6;int  P = 0;int  Q = -1;int  R = 4;int  S = 3;
		System.out.println(rectilinear(K, L, M, N, P, Q, R, S));
	}
}
