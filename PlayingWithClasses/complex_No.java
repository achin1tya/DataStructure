package l10;

public class complex_No {
	int re;
	int im;
	public void printComplex_No()
	{
		if(this.im>0)
			System.out.println(this.re+"+i"+this.im);
		else
			System.out.println(this.re+"-i"+(-1)*this.im);
	}
	public complex_No(int re,int im)
	{
		this.re=re;
		this.im=im;
	}
	public static complex_No complex_NoAdd(complex_No f1,complex_No f2)		//static
	{
		int newReal=f1.re+f2.re;
		int newImaginary=f1.im+f2.im;
		complex_No n=new complex_No(newReal,newImaginary);
		return n;
	}
	public void add(complex_No n)			//non static
	{
		this.re=this.re+n.re;
		this.im=this.im+n.im;
	}
	public static complex_No  multiply(complex_No a,complex_No b)
	{
		int newReal=(a.re*b.re)-(a.im*b.im);
		int newImaginary=(a.re*b.im)+(a.im*b.re);
		complex_No n=new complex_No(newReal,newImaginary);
		return n;
	}
	public static void main(String[] args) {
		complex_No a=new complex_No(-2,-4);
		complex_No b=new complex_No(4,5);
		a.printComplex_No();
		b.printComplex_No();
		complex_No ans=complex_NoAdd(a, b);
		ans.printComplex_No();
		a.printComplex_No();
		b.printComplex_No();
		a.add(b);
		a.printComplex_No();
		
	}
}
