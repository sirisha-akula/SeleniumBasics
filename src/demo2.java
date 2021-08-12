
public class demo2 {

	
		public  demo2() {
			System.out.println("Parent class constructor");
		}

		public static void main(String[] args) {
			// wrapper classes - data conversion
			
			String s = "100";
			String s1 = "true";
			System.out.println(s+5); //1005
			
			//converting to integer
			int i = Integer.parseInt(s);
			System.out.println(i+5); //105
			
			//converting to double
					double  d = Double.parseDouble(s);
					System.out.println(d+5); //105
					
					//converting to float
					float  f = Float.parseFloat(s);
					System.out.println(f+5); //105
					
					//converting to long
					long  l = Long.parseLong(s);
					System.out.println(l+5); //105
					
					boolean b = Boolean.parseBoolean(s1);
					System.out.println(b);
					
					int a = 100;
					System.out.println(a+2);
					
					boolean b1 = false;
					System.out.println(b1);
					
					//converting to string
					String s2 = String.valueOf(a);
					System.out.println(s2+"hello");

					String s3 = String.valueOf(b1);
					System.out.println(s3+"color");
		}

		
		
			public final void div() {
				System.out.println("this is final div");

	}

}
