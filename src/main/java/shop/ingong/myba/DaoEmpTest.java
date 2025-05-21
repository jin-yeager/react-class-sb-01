package shop.ingong.myba;

import java.util.ArrayList;

public class DaoEmpTest {
	public static void main(String[] args) {
		DaoEmp de = new DaoEmp();
		EmpVO pvo = new EmpVO("3", "", "", "");
		int cnt = de.delete(pvo);
		System.out.println("cnt:" + cnt);
	}
}