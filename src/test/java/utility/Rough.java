package utility;

public class Rough {
	public static ExcelReader excel = new ExcelReader("/Users/sinhapoo/git/credentials.xlsx"); 
	
	public static void roughMeth1() {
//		System.out.println(excel.getRowCount(1));
		System.out.println(excel.getRowCount("cred"));
		
	}
	
	public static void main(String[] args) {
		Rough.roughMeth1();
	}
}
