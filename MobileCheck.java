package Com.jara.Object;

interface SIMCardInterface{
	String getnumber();
	String network();
	void activation();
	void deactivation();
	 
}

class jio implements SIMCardInterface{
	
	String number;
	boolean activeted;
	
	public jio(String number, boolean activeted) {
		super();
		this.number = number;
		this.activeted = activeted;
	}

	@Override
	public String getnumber() {
		
		return number;
	}

	@Override
	public String network() {
		
		return "jio";
	}

	@Override
	public void activation() {
		activeted=true;
		System.out.println("sim card is activated");
		
	}

	@Override
	public void deactivation() {
		activeted=false;
		System.out.println("sim card is notactivated");
		
	}

}
class airtel implements SIMCardInterface{

	String number;
	boolean activeted;
	
	public airtel(String number, boolean activeted) {
		super();
		this.number = number;
		this.activeted = activeted;
	}

	@Override
	public String getnumber() {
		
		return number;
	}

	@Override
	public String network() {
		
		return "airtel";
	}

	@Override
	public void activation() {
		activeted=true;
		System.out.println("sim card is activated");
		
	}

	@Override
	public void deactivation() {
		activeted=false;
		System.out.println("sim card is notactivated");
		
	}

}
class bsnl implements SIMCardInterface{
	String number;
	boolean activeted;
	
	public bsnl(String number, boolean activeted) {
		super();
		this.number = number;
		this.activeted = activeted;
	}

	@Override
	public String getnumber() {
		
		return number;
	}

	@Override
	public String network() {
		
		return "bsnl";
	}

	@Override
	public void activation() {
		activeted=true;
		System.out.println("sim card is activated");
		
	}

	@Override
	public void deactivation() {
		activeted=false;
		System.out.println("sim card is notactivated");
		
	}

	
}
interface MobilePhoneInterface{
	void inserting(SIMCardInterface sim);
	void removing(SIMCardInterface sim);
	void makecalls(SIMCardInterface sim,String phonenumber);
	void sendtext(SIMCardInterface sim,String phonenumber,String msg);
}
class MobilePhone implements MobilePhoneInterface{
	SIMCardInterface sim;
	@Override
	public void inserting(SIMCardInterface sim) {
		System.out.println(sim.network()+" sim card inserted");
		
	}

	@Override
	public void removing(SIMCardInterface sim) {
		if(sim!=null) {
			sim.deactivation();
			sim=null;
			System.out.println("sim card removed");
		}
		else {
			System.out.println("no sim card to remove");
		}
		
	}

	@Override
	public void makecalls(SIMCardInterface sim,String phonenumber) {
		if((sim!=null)&&sim.getnumber().equals(phonenumber)) {
			System.out.println("making a call with this "+phonenumber+" with this network "+sim.network());
		}
		else {
			System.out.println("no sim card is provided insert the sim card to make a call");
		}
		
	}

	@Override
	public void sendtext(SIMCardInterface sim,String phonenumber,String msg) {
		if((sim!=null)&&sim.getnumber().equals(phonenumber)) {
			System.out.println("making a sending "+msg+" with this "+phonenumber+" with this network "+sim.network());
		}
		else {
			System.out.println("no sim card is provided insert the sim card to make a call");
		}
		
		
	}
	
}

public class MobileCheck {
	public static void main(String[] args) {
		SIMCardInterface s=new jio("9390189521", true);
		SIMCardInterface s1=new airtel("9390189521", true);
		SIMCardInterface s2=new bsnl("9390189521", true);
		
		MobilePhoneInterface m=new MobilePhone();
		m.inserting(s1);
		m.removing(s1);
		m.makecalls(s1, "9390189521");
		m.sendtext(s1,"9390189521","hello");
		
	}

}
