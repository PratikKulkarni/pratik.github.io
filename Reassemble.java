import java.util.*;

class Reassemble{
	public static void main(String[] args){
		int n,ind=-1;
		HashMap<Character,String> using_last=new HashMap<Character,String>();
		for(int i=0;i<args.length;i++){
			n=args[i].length();
			using_last.put(args[i].charAt(n-1),args[i]);
		}
		HashMap<Character,String> using_first=new HashMap<Character,String>();
		for(int i=0;i<args.length;i++){
			using_first.put(args[i].charAt(0),args[i]);
		}
		char ch;
		String first,word,s;
		for(int i=0;i<args.length;i++){
			ch=args[i].charAt(0);
			if(using_last.containsKey(ch)==false){
				ind=i;
			}
		}
		word=args[ind];
		n=args[ind].length();
		ch=args[ind].charAt(n-1);
		while(using_first.containsKey(ch)){
			s=using_first.get(ch);
			s=s.substring(1);
			word=word+s;
			n=s.length();
			ch=s.charAt(n-1);
		}
		System.out.print(word);
	}
}