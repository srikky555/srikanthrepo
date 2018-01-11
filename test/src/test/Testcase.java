package test;

public class Testcase {
	
static String a;
	

void get()
{
	System.out.println( a);
}


	public static void main(String[] args) {
		Testcase.a ="ferror";
	
		Testcase r = new Testcase();
		r.get();		

}
}