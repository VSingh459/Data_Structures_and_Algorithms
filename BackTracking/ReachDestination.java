package backTracking;

public class ReachDestination {
	
	public static boolean  reachD(int sx,int sy,int dx,int dy)
	{
		if (sx > dx || sy > dy)
		{
			return false;
		}
		
		if (sx==dx && sy==dy)
		{
			return true;
		}
		
		return reachD(sx+sy,sy,dx,dy) || reachD(sx,sx+sy,dx,dy);
	}
	
	public static boolean reachNinja(int sx,int sy,int dx,int dy)
	{
		if (sx > dx || sy > dy)
		{
			return false;
		}
		
		if (sx==dx && sy==dy)
		{
			return true;
		}
		
		if (dx>dy)
		{
			return reachNinja(sx,sy,dx-dy,dy);
		}
		else
		{
			return reachNinja(sx,sy,dx,dy-dx);
		}
		
	}
	
	

	public static void main(String[] args) {
		
		boolean ans = reachNinja(1,1,3,5);
		System.out.println(ans);

	}

}
