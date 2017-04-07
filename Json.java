public class Json{
	public static String parseString(String str,String k){
		int start=0;
		int end=0;
		int len=str.length();
		int i=str.indexOf(k);
		i=i+k.length()+1;
		while(i<len){
			if(str.charAt(i)=='"')
			{
				start=i+1;
				break;
			}
			i=i+1;
		}
		i=i+1;
		while(i<len){
			if(str.charAt(i)=='"')
			{
				
				end=i;
				break;

			}
			i=i+1;
		}
		if(start>end)
			return null;
		return str.substring(start,end);


	}
	public static String parseDict(String str,String k){
		int start=0;
		int end=0;
		int count=0;
		int len=str.length();
		int i=str.indexOf(k);
		i=i+k.length()+1;

		while(i<len){
			if(str.charAt(i)=='{')
			{
				start=i+1;
				count=1;
				break;
			}
			i=i+1;
		}
		i=i+1;
		while(i<len){

			if(str.charAt(i)=='{')
			{
				count=count+1;
				
			}else if(str.charAt(i)=='}'){

				count=count-1;
				if(count==0){
					end=i;
					break;
				}

			}
			i=i+1;
			
		}
		if(start>end)
			return null;
		return str.substring(start,end);
		

	}
	public static ArrayList<String> parseArray(String str,String k){

		int start=0;
		int end=0;
		int count=0;
		int len=str.length();
		int i=str.indexOf(k);
		i=i+k.length()+1;
		while(i<len){
			if(str.charAt(i)=='[')
			{
				start=i+1;
				count=1;
				break;
			}
			i=i+1;
		}
		i=i+1;
		while(i<len){
			if(str.charAt(i)=='[')
			{
				count=count+1;
				
			}else if(str.charAt(i)==']'){

				count=count-1;
				if(count==0){
					end=i;
					break;
				}

			}
			i=i+1;
		}
		if(start>end)
			return null;
		count=0;
		int pre=0;
		String tmp=str.substring(start,end);
		i=0;

		len=tmp.length();
		ArrayList<String> res=new ArrayList<String>();
		while(i<len)
		{

			if(tmp.charAt(i)=='['||tmp.charAt(i)=='{'){
				count=count+1;
			}else if(tmp.charAt(i)==']'||tmp.charAt(i)=='}'){
				count=count-1;
			}else if(tmp.charAt(i)==','&&count==0){
				pre=i;
				res.add(tmp.substring(0,i));
			}
			i=i+1;
		}
		res.add(tmp.substring(pre+1,tmp.length()));
		return res;
	}
}
