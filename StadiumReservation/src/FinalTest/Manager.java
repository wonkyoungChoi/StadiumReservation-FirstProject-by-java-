package FinalTest;

import java.util.Scanner;

//경기장 매치 예약 프로그램

class ManagerSystem {
	String stadium[] = { "\tJava 경기장" , "\t\t C# 경기장" , "\t\t   HTML 경기장\n" };
	String reservetime[] = {"12:00 ~ 14:00", "14:00 ~ 16:00" , "16:00 ~ 18:00" , "18:00 ~ 20:00" , "20:00 ~ 22:00" , "22:00 ~ 24:00"};
	String time[][] = new String[stadium.length][reservetime.length];
	String reserve[][] = new String[stadium.length][reservetime.length];
	String alpha[] = {"a","b","c","d","e","f"};
	
	
	//시간과 예약에 관한 2차 배열 선언 메소드
	void array() {
	for(int i=0; i<stadium.length; i++) {
		for (int j=0; j<reservetime.length; j++) {
			time[i][j] = reservetime[j];
			reserve[i][j] = "상대없음";
			}
	}
	}
	
	//알파벳으로 바꾼 시간배열을 다시 시간으로 바꿔주는 배열 선언 메소드
	void arrayTime() {  
		for(int i=0; i<stadium.length; i++) {
			for (int j=0; j<reservetime.length; j++ ) {
				time[i][j] = reservetime[j];
			}
		}
	}
	
	//시간선택 출력 메소드
	void printselect() {
		System.out.print("시간선택 : ");
	for(int i=0; i<reservetime.length; i++) {
		System.out.print(reservetime[i] + "("+ alpha[i] + ")");
		if(i<reservetime.length-1)
		System.out.print(", ");
		}
	System.out.println("\n");
	System.out.print("시간을 선택해주세요(알파벳 입력) >>");
	}
	
	
	//경기장 이름, 시간과 예약상태 출력 메소드
	void print() {
		System.out.println();	    
		for(int i = 0; i<stadium.length; i++) {   //경기장 이름 출력	
			System.out.print(stadium[i]);
		}
		System.out.println();
		for(int i=0; i<time[0].length;i++) {   //시간과 예약상태 출력
			for(int j=0; j<time.length; j++) 
				System.out.print(time[j][i]  +"  " + reserve[j][i] + "   |   ");
				System.out.println();
		}
		System.out.println();
	}
	
	//경기장 하나씩 출력
	void stdprint(int a) { 
			System.out.println();
			
			if(a==1)   //선택한 경기장 번호가 1일 경우
				System.out.println("\tJava 경기장");
			else if(a==2)   //선택한 경기장 번호가 2일 경우
				System.out.println("\tC# 경기장");
			else if(a==3)   //선택한 경기장 번호가 3일 경우
				System.out.println("\tHTML 경기장");

				
			
			System.out.println();      //선택한 경기장의 시간과 예약상태 출력
			for(int i=0; i<time[a-1].length; i++) {
				System.out.println(time[a-1][i] + "  " + reserve[a-1][i]);
				}
			System.out.println();
	}

	//예약 메소드
	void reservation(int a , String b) {
		for(int i=0; i<reservetime.length; i++) {
			time[a-1][i]=alpha[i]; //입력받을 알파벳과 비교하기 위해 시간을 알파벳으로 바꿔주기
		}         

		for(int i = 0; i<time[a-1].length; i++) {
			if(time[a-1][i].equals(b)&&reserve[a-1][i]=="매치성사") {  //매치가 성사되어있을 경우
				System.out.println();
	            System.out.println("이미 매치가 성사되었습니다.");
	            System.out.println("다른 시간대를 선택해주세요.");
	            arrayTime();    //알파벳으로 바뀐 시간 배열 다시 시간으로 바꿔주기
	            stdprint(a);    //선택한 경기장 출력
	            return;
	         }
			else if(time[a-1][i].equals(b)&&reserve[a-1][i].equals("상대있음")) { //예약상태가 상대있음으로 된 시간대를 선택한 경우
	             reserve[a-1][i] = "매치성사";  //예약상태가 매치성사로 바뀜
	             arrayTime();    //알파벳으로 바뀐 시간 배열 다시 시간으로 바꿔주기
	             stdprint(a);    //선택한 경기장 출력
	             return;
	          }
			else if(time[a-1][i].equals(b)) {
				reserve[a-1][i] = "상대있음";  //예약상태가 상대있음으로 바뀜
				arrayTime();    //알파벳으로 바뀐 시간 배열 다시 시간으로 바꿔주기
				stdprint(a);    //선택한 경기장 출력
				return;
			} 		
			else if(i == reservetime.length-1) { 
				arrayTime();   //알파벳으로 바뀐 시간 배열 다시 시간으로 바꿔주기
				System.out.println();
				System.out.println("없는 시간대입니다.");
				System.out.println();
			}
		}	
	}
	

	

	//취소 메소드
	void cancel(int a, String b) {
		for(int i=0; i<reservetime.length; i++) {
			time[a-1][i]=alpha[i];  //입력받을 알파벳과 비교하기 위해 시간을 알파벳으로 바꿔주기
		}
		for(int i = 0; i<time[a-1].length; i++) {
			if(time[a-1][i].equals(b)&&reserve[a-1][i]=="상대없음") {  //취소할 매치가 없을 경우
				System.out.println();
	            System.out.println("취소할 예약이 없습니다.");
	            arrayTime();    //알파벳으로 바뀐 시간 배열 다시 시간으로 바꿔주기
	            stdprint(a);    //선택한 경기장 출력
	            return;
	         }
			else if(time[a-1][i].equals(b)&&reserve[a-1][i].equals("매치성사")) {  //매치가 성사되어있을 경우
	             reserve[a-1][i] = "상대있음";  //예약상태가 상대있음으로 바뀜
	             arrayTime();   //알파벳으로 바뀐 시간 배열 다시 시간으로 바꿔주기
	             stdprint(a);   //선택한 경기장 출력
	             return;
	          }
			else if(time[a-1][i].equals(b)) {
				reserve[a-1][i] = "상대없음";  //예약상태가 상대없음으로 바뀜
				arrayTime(); //알파벳으로 바뀐 시간 배열 다시 시간으로 바꿔주기
				stdprint(a); //선택한 경기장 출력
				return;
			}
			else if(i == reservetime.length-1) {
				arrayTime();    //알파벳으로 바뀐 시간 배열 다시 시간으로 바꿔주기
				System.out.println();
				System.out.println("없는 시간대입니다.");
				System.out.println();
			}
		}
	}
}
	

public class Manager {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ManagerSystem A = new ManagerSystem();
		A.array();
		System.out.println("경기 매치 예약 프로그램입니다.");
		for(;;) {
			System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
			int num = scanner.nextInt();
			
			//끝내기
			if (num==4) return;
			
			//예약
			if (num==1) {
				A.print();
				System.out.print("경기장을 선택해주세요(Java 경기장(1), C# 경기장(2), HTML 경기장(3)) 숫자 입력>>");
				int stdnum = scanner.nextInt();
				System.out.println();
				
				if(stdnum!=1 && stdnum!=2 && stdnum!=3)  //경기장 번호를 잘못 선택했을 경우
					System.out.println("없는 경기장입니다.\n");
				
				else {  //경기장을 올바르게 선택했을 경우
				A.printselect();   
				String reserveAlpha = scanner.next();
				A.reservation(stdnum, reserveAlpha);
				}
				
			}
			
			//조회
			if (num==2) {
				A.print();
				System.out.println();
				System.out.println("조회를 완료하였습니다.\n");
			}
			
			//취소
			if (num==3) {
				A.print();
				System.out.print("경기장을 선택해주세요(Java 경기장(1), C# 경기장(2), HTML 경기장(3)) 숫자 입력>>");
				int stdnum = scanner.nextInt();
				System.out.println();
				
				if(stdnum!=1 && stdnum!=2 && stdnum!=3)  //경기장 번호를 잘못 선택했을 경우
					System.out.println("없는 경기장입니다.");
				
				else {   //경기장을 올바르게 선택했을 경우
				A.printselect();
				String reserveAlpha = scanner.next();
				A.cancel(stdnum, reserveAlpha);
				}
			}
		}
		
	}
}

