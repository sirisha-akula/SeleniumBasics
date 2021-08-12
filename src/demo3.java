import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class demo3 {

		int id;
		String name;
		double sal;

		public demo3() {
			super(); //super keyword used to call parent class constructor
			System.out.println("this is default constructor");
		}
		public demo3(int i, String n, double s) {
			this.id = i;
			this.name = n;
			this.sal = s;
			
		}

			public static void main(String[] args) {
				
				ArrayList<Object> ar = new ArrayList<Object>();
				ar.add("red");
				ar.add("yellow");
				ar.add("pink");
				ar.add(2);
				ar.add(true);
				ar.add('e');
			
				ArrayList<Object> ar2 = new ArrayList<Object>();
				ar2.addAll(ar);
				Iterator<Object> it2 = ar2.iterator();
				while(it2.hasNext()) {
					System.out.println(it2.next());
				}
				
				ArrayList<Object> cloneList = (ArrayList<Object>)ar.clone();
				System.out.println(cloneList);
				
				ar.remove(1);


				ArrayList<Object> ar3 = new ArrayList<Object>(Arrays.asList("White",1, false, 'M',false,"White"));
				System.out.println(ar3.get(1));
				
				LinkedHashSet<Object> lh = new LinkedHashSet<Object>(ar3);
				for(Object p:lh) {
					System.out.println(p);
				}

				
				

	}

}
