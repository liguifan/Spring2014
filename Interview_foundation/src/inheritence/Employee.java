package inheritence;

public class Employee {
		private String name;
//		private Date hireDate;
		
		public Employee(){
			name="no name";
		}
		
		public Employee(String theName){
			name=theName;
			
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public String toString(){
			return (this.name+" Employee class");
		}
}
