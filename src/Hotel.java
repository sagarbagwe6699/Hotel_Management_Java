
public class Hotel {
	int rooms;
	int avrm;
	Room arr[];
	public Hotel() {
		rooms=0;
		avrm=0;
		arr=new Room[20];
		for(int i=0;i<20;i++) {
			arr[i]=new Room(i+1);
		}
	}
	
	public void addRoom(int price,int rnum,int ac) {
		if(rooms!=19) {
			arr[rooms]=new Room(price,rnum,ac);
			rooms++;
			avrm++;
		}
		else {
			System.out.println("No more rooms can be created");
		}
	}
	
	public int bookRoom(int rnum) {
		for(int i=0;i<rooms;i++) {
			if(arr[i].rnum==rnum&&arr[i].rava==1) {
				arr[i].rava=0;
				avrm--;
				return 1;
			}
		}
				System.out.println("All rooms are full");
				return 0;
	}
	
	public int checkOut(int rnum) {
		int p=0;
		for(int i=0;i<rooms;i++) {
			if(arr[i].rnum==rnum&&rooms!=avrm) {
				arr[i].rava=1;
				avrm++;
				System.out.println("Checkout Sucessful");
				System.out.println("Total bill : "+ arr[i].price);
				p=arr[i].price;
				return p;
			}
		}
				System.out.print("All rooms are empty.\nCheckout Unsucessful");
				return 0;
	}
	
	public void display() {
		System.out.println("Total rooms : "+rooms);
		System.out.println("Available rooms : "+avrm);
	}
	
	
	public void showAva() {
		for(int i=0;i<rooms;i++) {
			if(arr[i].rava==1&&avrm>1) {
				System.out.println(arr[i].rnum);
			}
			else {
				System.out.println("All rooms are booked");
			}
		}
	}
	
	
	
	
	
}
