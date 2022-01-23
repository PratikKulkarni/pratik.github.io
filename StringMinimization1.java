import java.util.*;

class StringMinimization1{
	public static void main(String[] args){
		String s;
		Scanner sc=new Scanner(System.in);
		s=sc.next();
		int ind=-1,count,maxInd,max_count,n,left,right,flag=0,len=-1;
		do{
		n=s.length();
		if(n>1){
			if(s.charAt(0)!=s.charAt(n-1)){
			flag=1;
		//s=s.substring(ind+1)+s.substring(0,ind);
		len=n;
		}
		else{
			left=0;
			for(int i=1;i<(n-1);i++){
				if(s.charAt(i)==s.charAt(i-1)){
					left=i;
				}
				else
					break;
			}
			if(left==(n-2)){
				flag=1;
				len=0;
			}
			else{
				right=n-1;
				for(int i=(n-2);i>=1;i--){
					if(s.charAt(i)==s.charAt(i+1))
						right=i;
					else
						break;
				}
				//count=1;
				ind=left+1;
				//max_count=1;
				//maxInd=left+1;
				for(int i=(left+2);i<right;i++){
					if(s.charAt(i)==s.charAt(i-1)){
						//count++;
						//ind=i;
						/*if(count>max_count){
							max_count=count;
							maxInd=ind;
						}*/
						break;
					}
					else{
						count=1;
						ind=i;
					}
				}
				s=s.substring(ind+1,right)+s.substring(left+1,ind+1);
				//System.out.println(s);
			}
		}
		}
		else{
			len=1;
			flag=1;
		}

		}
		while(flag==0);
		System.out.println(len);
	}
}