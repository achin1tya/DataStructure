package l10;

public class Polynomial {
 DynamicArray poly; 
 public Polynomial()
 {
	 poly=new DynamicArray();
 }
 public void setCoefficient(int deg,int coeff)
 {
	 poly.addInBetween0(deg, coeff);
 }
 public  int getCoefficient(int deg)
 {
	return  poly.get(deg);
 }
 public int degree()
 {
	 for(int i=poly.size()-1;i>=1;i--)
	 {
		 if(poly.get(i)!=0)
		 {
			 return i;
		 }
	 }
	 return 0;
 }
 public void print()
 {
	 for(int i=0;i<this.poly.size();i++)
	 {
		 System.out.print(poly.get(i)+"x^"+i);
	 }
 }
 public static void add(Polynomial p,Polynomial q)
 {
	Polynomial ans=new Polynomial();
	int i=0;
	while(i<=p.degree()&&i<=q.degree())
	{
		ans.poly.set(i, p.poly.get(i)+q.poly.get(i));
	}
	while(i<=p.degree())
	{
		ans.poly.set(i,p.poly.get(i));
	}
 
	while(i<=q.degree())
	{
		ans.poly.set(i,q.poly.get(i));
	}
	ans.print();
 
 }
 public static void main(String[] args) 
	{
		Polynomial p=new Polynomial();
		p.setCoefficient(2,2);
		p.setCoefficient(0, 5);
		Polynomial q=new Polynomial();
		p.print();
		//Polynomial add(p,q);
	}
}

