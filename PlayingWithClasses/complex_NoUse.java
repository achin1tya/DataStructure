package l10;

public class complex_NoUse {
	public static void main(String[] args) {
		complex_No a=new complex_No(-2,-4);
		complex_No b=new complex_No(4,5);
		a.printComplex_No();
		b.printComplex_No();
		complex_No ans=complex_No.complex_NoAdd(a, b);
		ans.printComplex_No();
		a.printComplex_No();
		b.printComplex_No();
		a.add(b);
		a.printComplex_No();
		
	}
}
