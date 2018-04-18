package l23;

public class Teacher implements comparator<Teacher>{
	
	int id;
	
	public Teacher(int id) {
		
		this.id=id;
	}
	
	//if id are equal return 1;
	//if firstid>second id return -1
	//else return 1
	public int sort(Teacher second) {
		// TODO Auto-generated method stub
		if(this.id==second.id)
			return 0;
		else if(this.id>second.id){
			return -1;
		}
		else if(this.id<second.id)
		{
			return 1;
		}
		return 0;
	}
	
}
