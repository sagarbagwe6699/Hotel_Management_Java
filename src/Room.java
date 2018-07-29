
public class Room {
	int price;
	int rnum;
	int rava;
	int ac;
	
	Room(int price,int rnum,int ac){
		this.price=price;
		this.rnum=rnum;
		this.ac=ac;
		this.rava=1;
	}
	Room(int rnum){
		this.price=1000;
		this.rnum=rnum;
		this.ac=1;
		this.rava=1;
	}
	
	void changeava() {
		if(rava==0) {
			rava=1;
		}
		else {
			rava=0;
		}
	}
	
	
}
